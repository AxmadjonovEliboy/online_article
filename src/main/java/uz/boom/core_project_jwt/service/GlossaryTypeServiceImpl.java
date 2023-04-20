package uz.boom.core_project_jwt.service;

import org.springframework.stereotype.Service;
import uz.boom.core_project_jwt.dto.glossary.GlossaryTypeCreateDTO;
import uz.boom.core_project_jwt.dto.glossary.GlossaryTypeDTO;
import uz.boom.core_project_jwt.entity.Glossary;
import uz.boom.core_project_jwt.entity.GlossaryType;
import uz.boom.core_project_jwt.exception.NotFoundException;
import uz.boom.core_project_jwt.mapper.GlossaryTypeMapper;
import uz.boom.core_project_jwt.repository.GlossaryRepository;
import uz.boom.core_project_jwt.repository.GlossaryTypeRepository;
import uz.boom.core_project_jwt.service.base.AbstractService;
import uz.boom.core_project_jwt.service.base.GlossaryTypeService;

import java.util.List;
import java.util.Optional;

/**
 * @author Jarvis on Tue 21:05. 18/04/23
 */
@Service
public class GlossaryTypeServiceImpl extends AbstractService<GlossaryTypeRepository, GlossaryTypeMapper> implements GlossaryTypeService {

    private final GlossaryRepository glossaryRepository;

    public GlossaryTypeServiceImpl(GlossaryTypeRepository repository, GlossaryTypeMapper mapper, GlossaryRepository glossaryRepository) {
        super(repository, mapper);
        this.glossaryRepository = glossaryRepository;
    }

    @Override
    public Long create(GlossaryTypeCreateDTO creteDTO) {
        GlossaryType glossaryType = mapper.fromCreateDTO(creteDTO);
        GlossaryType savedGlossaryType = repository.save(glossaryType);
        return savedGlossaryType.getId();
    }

    @Override
    public List<GlossaryTypeDTO> getAll() {
        List<GlossaryType> glossaryTypes = repository.findAll();
        return mapper.toDTO(glossaryTypes);
    }

    @Override
    public GlossaryTypeDTO get(Long id) {
        GlossaryType glossaryType = repository.findById(id).orElseThrow(() -> new NotFoundException("GLOSSARY TYPE NOT FOUND!"));
        return mapper.toDTO(glossaryType);
    }

    @Override
    public Long update(GlossaryTypeDTO dto) {
        GlossaryType saveGlossaryType = repository.findById(dto.getId()).orElseThrow(() -> new NotFoundException("NOT FOUND!"));
        GlossaryType glossaryType = mapper.fromUpdateDTO(dto, saveGlossaryType);
        GlossaryType save = repository.save(glossaryType);
        return save.getId();
    }

    @Override
    public Long delete(Long id) {
        Optional<GlossaryType> glossaryType = repository.findById(id);
        if (glossaryType.isPresent()) {
            List<Glossary> glossaries = glossaryRepository.findAllByGlossaryTypeId(id).orElseThrow(() -> new NotFoundException("NOT FOUND"));
            glossaries.forEach(glossary -> {
                Glossary savedGlossary = glossaryRepository.findById(glossary.getId()).orElseThrow(() -> new NotFoundException("NOT FOUND"));
                savedGlossary.setDeleted(Boolean.TRUE);
                glossaryRepository.save(savedGlossary);
            });
        }
        GlossaryType savedGlossaryType = glossaryType.orElseThrow();
        savedGlossaryType.setDeleted(Boolean.TRUE);
        GlossaryType save = repository.save(savedGlossaryType);
        return save.getId();
    }
}
