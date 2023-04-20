package uz.boom.core_project_jwt.service;

import org.springframework.stereotype.Service;
import uz.boom.core_project_jwt.dto.article_title.LiteratureCreateDTO;
import uz.boom.core_project_jwt.dto.article_title.LiteratureDTO;
import uz.boom.core_project_jwt.entity.Literature;
import uz.boom.core_project_jwt.enums.LiteratureType;
import uz.boom.core_project_jwt.exception.BadRequestException;
import uz.boom.core_project_jwt.exception.NotFoundException;
import uz.boom.core_project_jwt.mapper.LiteratureMapper;
import uz.boom.core_project_jwt.repository.LiteratureRepository;
import uz.boom.core_project_jwt.service.base.AbstractService;
import uz.boom.core_project_jwt.service.base.LiteratureService;

import java.util.List;

/**
 * @author Jarvis on Tue 03:27. 18/04/23
 */
@Service
public class LiteratureServiceImpl extends AbstractService<LiteratureRepository, LiteratureMapper> implements LiteratureService {
    public LiteratureServiceImpl(LiteratureRepository repository, LiteratureMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public Long create(LiteratureCreateDTO literatureCreateDTO) {
        Literature literature = mapper.fromCreateDTO(literatureCreateDTO);
        Literature save = repository.save(literature);
        return save.getId();
    }

    @Override
    public List<LiteratureDTO> getAllByType(String type) {
        List<Literature> repositoryAll = repository.findAllByLiteratureType(LiteratureType.getByName(type)).orElseThrow(() -> new BadRequestException("BAD REQUEST"));
        return mapper.toDTO(repositoryAll);
    }


    public List<LiteratureDTO> getAll() {
        List<Literature> repositoryAll = repository.findAll();
        return mapper.toDTO(repositoryAll);
    }

    @Override
    public LiteratureDTO get(Long id) {
        Literature literature = repository.findById(id).orElseThrow(() -> new NotFoundException("LITERATURE NOT FOUND!"));
        return mapper.toDTO(literature);
    }

    @Override
    public Long update(LiteratureDTO dto) {
        Literature literature = repository.findById(dto.getId()).orElseThrow(() -> new NotFoundException("LITERATURE NOT FOUND!"));
        Literature updateDTO = mapper.fromUpdateDTO(dto, literature);
        Literature save = repository.save(updateDTO);
        return save.getId();
    }

    @Override
    public Long delete(Long id) {
        Literature literature = repository.findById(id).orElseThrow(() -> new NotFoundException("LITERATURE NOT FOUND!"));
        literature.setDeleted(Boolean.TRUE);
        Literature save = repository.save(literature);
        return save.getId();
    }
}
