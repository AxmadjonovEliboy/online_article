package uz.boom.core_project_jwt.service;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import uz.boom.core_project_jwt.dto.question.AnswerDTO;
import uz.boom.core_project_jwt.dto.question.QuestionDTO;
import uz.boom.core_project_jwt.dto.question.QuestionTitleAnswerDTO;
import uz.boom.core_project_jwt.dto.quiz.CheckAnswerDTO;
import uz.boom.core_project_jwt.dto.quiz.QuizCreateDTO;
import uz.boom.core_project_jwt.dto.quiz.QuizDTO;
import uz.boom.core_project_jwt.dto.quiz.ResultDTO;
import uz.boom.core_project_jwt.entity.*;
import uz.boom.core_project_jwt.exception.BadRequestException;
import uz.boom.core_project_jwt.exception.NotFoundException;
import uz.boom.core_project_jwt.mapper.AnswerMapper;
import uz.boom.core_project_jwt.mapper.QuestionMapper;
import uz.boom.core_project_jwt.mapper.QuizMapper;
import uz.boom.core_project_jwt.repository.*;
import uz.boom.core_project_jwt.service.base.AbstractService;
import uz.boom.core_project_jwt.service.base.QuizService;
import uz.boom.core_project_jwt.utils.SecurityUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Jarvis on Sun 01:11. 16/04/23
 */
@Service
public class QuizServiceImpl extends AbstractService<QuizRepository, QuizMapper> implements QuizService {

    private final QuestionRepository questionRepository;

    private final QuizQuestionRepository quizQuestionRepository;

    private final QuestionMapper questionMapper;

    private final ResultRepository resultRepository;

    private final AnswerRepository answerRepository;

    private final AnswerMapper answerMapper;

    private final QuizTypeRepository quizTypeRepository;

    public QuizServiceImpl(QuizRepository repository, @Qualifier("quizMapperImpl") QuizMapper mapper, QuestionRepository questionRepository, QuizQuestionRepository quizQuestionRepository, QuestionMapper questionMapper, ResultRepository resultRepository, AnswerRepository answerRepository, AnswerMapper answerMapper, QuizTypeRepository quizTypeRepository) {
        super(repository, mapper);
        this.questionRepository = questionRepository;
        this.quizQuestionRepository = quizQuestionRepository;
        this.questionMapper = questionMapper;
        this.resultRepository = resultRepository;
        this.answerRepository = answerRepository;
        this.answerMapper = answerMapper;
        this.quizTypeRepository = quizTypeRepository;
    }

    /**
     * bu method foydalanuvchi testni bosganda ishlaydi. Bu methodga zpros kelganda u tekshiradi uni tugallanmagan testi bor yuqligini
     * agar tugallanmagan testi yuq bo`lsa yangi test yaratib beradi. Agar tugallanmagan testi bo`lsa o`shani davom etkazish uchun jo`natadi
     * Uni belgilagan javoblarini saqlagan holda jo`natadi
     *
     * @param dto QuizCreateDTO
     * @return QuizDTO
     */
    @Override
    public QuizDTO create(QuizCreateDTO dto) {

        Optional<Quiz> processQuiz = repository.findByQuizTypeId(dto.getQuizTypeId(), SecurityUtils.getCurrentUserDetails().getId());
        if (processQuiz.isPresent()) {
            Quiz quiz = processQuiz.get();
            List<Question> questions = questionRepository.findAllByQuizId(quiz.getId()).orElseThrow(() -> new BadRequestException("BAD REQUEST"));
            List<QuestionDTO> questionDTOS = questionMapper.toDTO_1(questions);
            questionDTOS.forEach(questionDTO -> {
                QuizQuestion quizQuestion1 = quizQuestionRepository.findByQuizIdAndQuestionId(quiz.getId(), questionDTO.getId()).orElseThrow(() -> new NotFoundException("NOT FOUND!"));
                List<Answer> answers = answerRepository.findByQuestionId(questionDTO.getId()).orElseThrow(() -> new NotFoundException("NOT FOUND!"));
                List<AnswerDTO> answerDTOS = answerMapper.toDTO(answers);
                answerDTOS.forEach(answerDTO -> {
                    if (quizQuestion1.getAnswerId().equals(answerDTO.getId())) {
                        answerDTO.setIsRight(Boolean.TRUE);
                    } else {
                        answerDTO.setIsRight(Boolean.FALSE);
                    }
                });
                questionDTO.setAnswers(answerDTOS);
            });

            return new QuizDTO(quiz.getId(), questionDTOS);
        } else {


            Quiz quiz = Quiz.builder()
                    .size(dto.getSize())
                    .isClosed(Boolean.FALSE)
                    .duration(LocalDateTime.now().plusMinutes(30L))
                    .build();
            quiz.setCreatedBy(SecurityUtils.getCurrentUserDetails().getId());

            QuizType quizType = quizTypeRepository.findById(dto.getQuizTypeId()).orElseThrow(() -> new BadRequestException("BAD REQUEST"));

            quiz.setQuizType(quizType);

            Quiz savedQuiz = repository.save(quiz);


            List<Question> questions = questionRepository.findAllBySize(dto.getSize(), dto.getQuizTypeId()).orElseThrow(() -> new BadRequestException("BAD REQUEST!"));

            List<QuizQuestion> quizQuestions = new ArrayList<>();
            questions.forEach(question ->
                    quizQuestions.add(new QuizQuestion(savedQuiz.getId(), question.getId(), -1L, Boolean.FALSE)));

            List<QuestionDTO> questionDTOS = questionMapper.toDTO_1(questions);

            questionDTOS.forEach(questionDTO -> {
                List<Answer> answers = answerRepository.findByQuestionId(questionDTO.getId()).orElseThrow(() -> new NotFoundException("NOT FOUND!"));
                List<AnswerDTO> answerDTOS = answerMapper.toDTO(answers);
                answerDTOS.forEach(answerDTO -> answerDTO.setIsRight(Boolean.FALSE));
                questionDTO.setAnswers(answerDTOS);
            });

            quizQuestionRepository.saveAll(quizQuestions);


            Result result = Result.builder()
                    .authUser(SecurityUtils.getCurrentUserDetails())
                    .result("0")
                    .quizId(savedQuiz.getId())
                    .optional(quizType.getName())
                    .build();
            resultRepository.save(result);

            return new QuizDTO(savedQuiz.getId(), questionDTOS);

        }
    }


    /**
     * Bu method savol_id, quiz_id va jvobni_id si kelsa tekshirib javobni belgilab,
     * huddi  mashu savolni belgilagan javobi bilan qaytarib jo`natadi
     *
     * @param dto
     * @return
     */
    public QuestionDTO checkAnswer(CheckAnswerDTO dto) {
        QuizQuestion quizQuestion = quizQuestionRepository.findByQuizIdAndQuestionId(dto.getQuizId(), dto.getQuestionId()).orElseThrow(() -> new BadRequestException("BAD REQUEST"));
        quizQuestion.setAnswerId(dto.getAnswerId());

        Answer answer = answerRepository.findById(dto.getAnswerId()).orElseThrow(() -> new BadRequestException("BAD REQUEST"));
        if (answer.getIsRight()) {
            quizQuestion.setIsRight(Boolean.TRUE);
            Result result = resultRepository.findByQuizId(dto.getQuizId()).orElseThrow(() -> new BadRequestException("BAD REQUEST"));
            int i = Integer.parseInt(result.getResult());
            i++;
            result.setResult(String.valueOf(i));
            resultRepository.save(result);
        }
        QuizQuestion saved = quizQuestionRepository.save(quizQuestion);
        Question question = questionRepository.findById(dto.getQuestionId()).orElseThrow(() -> new BadRequestException("BAD REQUEST"));

        List<Answer> answers = answerRepository.findByQuestionId(question.getId()).orElseThrow(() -> new NotFoundException("NOT FOUND!"));
        List<AnswerDTO> answerDTOS = answerMapper.toDTO(answers);
        answerDTOS.forEach(answerDTO -> {
            if (saved.getAnswerId().equals(answerDTO.getId())) {
                answerDTO.setIsRight(Boolean.TRUE);
            } else {
                answerDTO.setIsRight(Boolean.FALSE);
            }
        });
        QuestionDTO questionDTO = questionMapper.toDTO(question);

        questionDTO.setAnswers(answerDTOS);
        return questionDTO;
    }


    /**
     * Bu method tugatish tugmasini bosganda ishlaydi, bunga quizni_id si kirib keladi va o`sha quizni resultini qaytarib beradi;
     *
     * @param quizId
     * @return
     */
    public ResultDTO result(Long quizId) {
        Result result = resultRepository.findByQuizId(quizId).orElseThrow(() -> new NotFoundException("RESULT NOT FOUND !"));
        Quiz quiz = repository.findById(quizId).orElseThrow(() -> new NotFoundException("QUIZ NOT FOUND"));
        ResultDTO resultDTO = new ResultDTO(result.getId(), result.getResult(), result.getQuizId(), result.getOptional());
        quiz.setIsClosed(Boolean.TRUE);
        repository.save(quiz);
        return resultDTO;
    }


    /**
     * Bu method resultlarning listini qaytaradi barcha ishlagan testlarining natijalari turadi
     *
     * @return
     */
    public List<ResultDTO> resultArchiveList() {
        List<Result> results = resultRepository.findAllByAuthUserId(SecurityUtils.getCurrentUserDetails().getId()).orElseThrow(() -> new BadRequestException("BAD REQUEST"));
        List<ResultDTO> resultDTOS = new ArrayList<>();
        results.forEach(result -> {
            resultDTOS.add(new ResultDTO(result.getId(), result.getResult(), result.getQuizId(), result.getOptional()));
        });
        return resultDTOS;
    }

    /**
     *  Bu method quizId berilsa o`sha ishlagan quizini to`liq savollarini va u savolni to`g`ri yoki xato ishlaganini ko`rsatadi gan massiv qaytaradi
     * @param quizId
     * @return
     */
    public List<QuestionTitleAnswerDTO> resultArchive(Long quizId) {

        List<Question> questions = questionRepository.findAllByQuizId(quizId).orElseThrow(() -> new BadRequestException("BAD REQUEST"));

        List<QuestionTitleAnswerDTO> questionTitleAnswerDTOS = new ArrayList<>();

        questions.forEach(question -> {
            QuizQuestion quizQuestion = quizQuestionRepository.findByQuizIdAndQuestionId(quizId, question.getId()).orElseThrow(() -> new BadRequestException("BAD REQUEST"));
            questionTitleAnswerDTOS.add(new QuestionTitleAnswerDTO(question.getId(), question.getTitle(), quizQuestion.getIsRight()));
        });

        return questionTitleAnswerDTOS;
    }


}
