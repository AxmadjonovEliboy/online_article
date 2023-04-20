package uz.boom.core_project_jwt.service;

import org.springframework.stereotype.Service;
import uz.boom.core_project_jwt.dto.quiz.QuizTypeCreateDTO;
import uz.boom.core_project_jwt.dto.quiz.QuizTypeDTO;
import uz.boom.core_project_jwt.entity.Answer;
import uz.boom.core_project_jwt.entity.Question;
import uz.boom.core_project_jwt.entity.QuizType;
import uz.boom.core_project_jwt.exception.BadRequestException;
import uz.boom.core_project_jwt.exception.NotFoundException;
import uz.boom.core_project_jwt.mapper.QuizTypeMapper;
import uz.boom.core_project_jwt.repository.AnswerRepository;
import uz.boom.core_project_jwt.repository.QuestionRepository;
import uz.boom.core_project_jwt.repository.QuizTypeRepository;
import uz.boom.core_project_jwt.service.base.AbstractService;
import uz.boom.core_project_jwt.service.base.QuizTypeService;

import java.util.List;

/**
 * @author Jarvis on Tue 23:47. 18/04/23
 */

@Service
public class QuizTypeServiceImpl extends AbstractService<QuizTypeRepository, QuizTypeMapper> implements QuizTypeService {

    private final QuestionRepository questionRepository;

    private final AnswerRepository answerRepository;

    public QuizTypeServiceImpl(QuizTypeRepository repository, QuizTypeMapper mapper, QuestionRepository questionRepository, AnswerRepository answerRepository) {
        super(repository, mapper);
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
    }

    @Override
    public Long create(QuizTypeCreateDTO creteDTO) {
        QuizType quizType = mapper.fromCreateDTO(creteDTO);
        QuizType savedQuizType = repository.save(quizType);
        return savedQuizType.getId();
    }

    @Override
    public List<QuizTypeDTO> getAll() {
        List<QuizType> quizTypes = repository.findAll();
        return mapper.toDTO(quizTypes);
    }

    @Override
    public QuizTypeDTO get(Long id) {
        QuizType quizType = repository.findById(id).orElseThrow(() -> new NotFoundException("QUIZ TYPE NOT FOUND!"));
        return mapper.toDTO(quizType);
    }

    @Override
    public Long update(QuizTypeDTO dto) {
        QuizType quizType = repository.findById(dto.getId()).orElseThrow(() -> new NotFoundException("QUIZ TYPE NOT FOUND!"));
        QuizType updateDTO = mapper.fromUpdateDTO(dto, quizType);
        QuizType saved = repository.save(updateDTO);
        return saved.getId();
    }

    @Override
    public Long delete(Long id) {
        List<Question> questions = questionRepository.findAllByQuizTypeId(id).orElseThrow(() -> new BadRequestException("BAD REQUEST"));
        questions.forEach(question -> question.setDeleted(Boolean.TRUE));
        questionRepository.saveAll(questions);
        questions.forEach(question -> {
            List<Answer> answers = answerRepository.findByQuestionId(question.getId()).orElseThrow(() -> new BadRequestException("BAD REQUEST"));
            answers.forEach(answer -> answer.setDeleted(Boolean.TRUE));
            answerRepository.saveAll(answers);
        });
        QuizType quizType = repository.findById(id).orElseThrow(() -> new NotFoundException("QUIZ TYPE NOT FOUND !"));
        quizType.setDeleted(Boolean.TRUE);
        QuizType saved = repository.save(quizType);
        return saved.getId();
    }
}
