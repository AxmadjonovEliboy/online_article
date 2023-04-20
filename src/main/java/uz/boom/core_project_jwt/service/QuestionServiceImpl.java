package uz.boom.core_project_jwt.service;

import org.springframework.stereotype.Service;
import uz.boom.core_project_jwt.dto.question.AnswerDTO;
import uz.boom.core_project_jwt.dto.question.QuestionCreateDTO;
import uz.boom.core_project_jwt.dto.question.QuestionDTO;
import uz.boom.core_project_jwt.dto.question.QuestionUpdateDTO;
import uz.boom.core_project_jwt.entity.Answer;
import uz.boom.core_project_jwt.entity.Question;
import uz.boom.core_project_jwt.entity.QuizType;
import uz.boom.core_project_jwt.enums.Language;
import uz.boom.core_project_jwt.enums.Level;
import uz.boom.core_project_jwt.exception.BadRequestException;
import uz.boom.core_project_jwt.exception.NotFoundException;
import uz.boom.core_project_jwt.mapper.AnswerMapper;
import uz.boom.core_project_jwt.mapper.QuestionMapper;
import uz.boom.core_project_jwt.repository.AnswerRepository;
import uz.boom.core_project_jwt.repository.QuestionRepository;
import uz.boom.core_project_jwt.repository.QuizTypeRepository;
import uz.boom.core_project_jwt.service.base.AbstractService;
import uz.boom.core_project_jwt.service.base.QuestionService;
import uz.boom.core_project_jwt.utils.SecurityUtils;

import java.util.List;

/**
 * @author Jarvis on Sat 17:00. 15/04/23
 */
@Service
public class QuestionServiceImpl extends AbstractService<QuestionRepository, QuestionMapper> implements QuestionService {

    private final QuizTypeRepository quizTypeRepository;
    private final AnswerRepository answerRepository;
    private final AnswerMapper answerMapper;

    public QuestionServiceImpl(QuestionRepository repository, QuestionMapper mapper, QuizTypeRepository quizTypeRepository, AnswerRepository answerRepository, AnswerMapper answerMapper) {
        super(repository, mapper);
        this.quizTypeRepository = quizTypeRepository;
        this.answerRepository = answerRepository;
        this.answerMapper = answerMapper;
    }

    @Override
    public Long create(QuestionCreateDTO dto) {
        QuizType quizType = quizTypeRepository.findById(dto.getQuizTypeId()).orElseThrow(() -> new NotFoundException("QUIZ TYPE NOT FOUND!"));
        Question question = mapper.fromCreateDTO(dto);
        question.setQuizType(quizType);
        question.setLevel(Level.MEDIUM);
        question.setLanguage(Language.UZB);
        question.setCreatedBy(SecurityUtils.getCurrentUserDetails().getId());
        Question savedQuestion = repository.save(question);
        List<Answer> answers = answerMapper.fromCreateDTO(dto.getAnswers());
        answers.forEach(answer -> {
            answer.setQuestion(savedQuestion);
            answer.setDeleted(Boolean.FALSE);
        });
        answerRepository.saveAll(answers);
        return savedQuestion.getId();
    }

    @Override
    public QuestionDTO get(Long id) {
        Question question = repository.findById(id).orElseThrow(() -> new NotFoundException("QUESTION NOT FOUND!"));
        List<Answer> answers = answerRepository.findByQuestionId(question.getId()).orElseThrow(() -> new NotFoundException("ANSWER NOT FOUND"));
        QuestionDTO questionDTO = mapper.toDTO(question);
        List<AnswerDTO> answerDTOS = answerMapper.toDTO(answers);
        questionDTO.setAnswers(answerDTOS);
        return questionDTO;
    }

    @Override
    public List<QuestionDTO> getAll() {
        List<Question> questions = repository.findAll();
        return getQuestionDTOS(questions);
    }

    public List<QuestionDTO> getAllByType(Long quizType) {
        List<Question> questions = repository.findAllByQuizTypeId(quizType).orElseThrow(() -> new BadRequestException("BAD REQUEST"));
        return getQuestionDTOS(questions);
    }

    private List<QuestionDTO> getQuestionDTOS(List<Question> questions) {
        List<QuestionDTO> list = mapper.toDTO_1(questions);
        list.forEach(questionDTO -> {
            List<Answer> answers = answerRepository.findByQuestionId(questionDTO.getId()).orElseThrow(() -> new BadRequestException("BAD REQUEST"));
            List<AnswerDTO> answerMap = answerMapper.toDTO(answers);
            questionDTO.setAnswers(answerMap);
        });
        return list;
    }

    @Override
    public Long update(QuestionUpdateDTO dto) {
        Question savedQuestion = repository.findById(dto.getId()).orElseThrow(() -> new NotFoundException("QUESTION NOT FOUND!"));
        Question question = mapper.fromUpdateDTO(dto, savedQuestion);
        dto.getAnswers().forEach(answerDTO -> {
            Answer answer = answerRepository.findById(answerDTO.getId()).orElseThrow(() -> new BadRequestException("BAD REQUEST"));
            Answer updateDTO = answerMapper.fromUpdateDTO(answerDTO, answer);
            answerRepository.save(updateDTO);
        });
        Question save = repository.save(question);
        return save.getId();
    }

    @Override
    public Long delete(Long id) {
        Question savedQuestion = repository.findById(id).orElseThrow(() -> new NotFoundException("QUESTION NOT FOUND!"));
        savedQuestion.setDeleted(Boolean.TRUE);
        Question save = repository.save(savedQuestion);
        List<Answer> answers = answerRepository.findByQuestionId(id).orElseThrow(() -> new BadRequestException("BAD REQUEST"));
        answers.forEach(answer -> answer.setDeleted(Boolean.TRUE));
        answerRepository.saveAll(answers);
        return save.getId();
    }
}
