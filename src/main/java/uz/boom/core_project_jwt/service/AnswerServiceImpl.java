package uz.boom.core_project_jwt.service;

import org.springframework.stereotype.Service;
import uz.boom.core_project_jwt.mapper.AnswerMapper;
import uz.boom.core_project_jwt.repository.AnswerRepository;
import uz.boom.core_project_jwt.service.base.AbstractService;
import uz.boom.core_project_jwt.service.base.AnswerService;

/**
 * @author Jarvis on Sat 17:02. 15/04/23
 */
@Service
public class AnswerServiceImpl extends AbstractService<AnswerRepository, AnswerMapper> implements AnswerService {
    public AnswerServiceImpl(AnswerRepository repository, AnswerMapper mapper) {
        super(repository, mapper);
    }
}
