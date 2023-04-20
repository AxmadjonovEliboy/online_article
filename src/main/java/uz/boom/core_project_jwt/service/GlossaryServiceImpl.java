package uz.boom.core_project_jwt.service;

import org.springframework.stereotype.Service;
import uz.boom.core_project_jwt.dto.glossary.GlossaryCreateDTO;
import uz.boom.core_project_jwt.dto.glossary.GlossaryDTO;
import uz.boom.core_project_jwt.entity.Glossary;
import uz.boom.core_project_jwt.entity.GlossaryType;
import uz.boom.core_project_jwt.exception.BadRequestException;
import uz.boom.core_project_jwt.exception.NotFoundException;
import uz.boom.core_project_jwt.mapper.GlossaryMapper;
import uz.boom.core_project_jwt.repository.GlossaryRepository;
import uz.boom.core_project_jwt.repository.GlossaryTypeRepository;
import uz.boom.core_project_jwt.service.base.AbstractService;
import uz.boom.core_project_jwt.service.base.GlossaryService;

import java.util.List;

/**
 * @author Jarvis on Tue 04:17. 18/04/23
 */
@Service
public class GlossaryServiceImpl extends AbstractService<GlossaryRepository, GlossaryMapper> implements GlossaryService {

    private final GlossaryTypeRepository glossaryTypeRepository;

    public GlossaryServiceImpl(GlossaryRepository repository, GlossaryMapper mapper, GlossaryTypeRepository glossaryTypeRepository) {
        super(repository, mapper);
        this.glossaryTypeRepository = glossaryTypeRepository;
    }

    @Override
    public Long create(GlossaryCreateDTO glossaryCreateDTO) {
        Glossary glossary = mapper.fromCreateDTO(glossaryCreateDTO);
        GlossaryType glossaryType = glossaryTypeRepository.findById(glossaryCreateDTO.getGlossaryTypeId()).orElseThrow(() -> new NotFoundException("NOT FOUND"));
        glossary.setGlossaryType(glossaryType);
        Glossary save = repository.save(glossary);
        return save.getId();
    }

    @Override
    public List<GlossaryDTO> getAll() {
        List<Glossary> glossaryList = repository.findAll();
        return mapper.toDTO(glossaryList);
    }
    public List<GlossaryDTO> getAllById(Long id) {
        List<Glossary> glossaryList = repository.findAllByGlossaryTypeId(id).orElseThrow(() -> new BadRequestException("BAD REQUEST"));
        return mapper.toDTO(glossaryList);
    }

    @Override
    public GlossaryDTO get(Long id) {
        Glossary glossary = repository.findById(id).orElseThrow(() -> new NotFoundException("GLOSSARY NOT FOUND!"));
        return mapper.toDTO(glossary);
    }

    @Override
    public Long update(GlossaryDTO dto) {
        Glossary glossary = repository.findById(dto.getId()).orElseThrow(() -> new NotFoundException("GLOSSARY NOT FOUND!"));
        Glossary mappedGlossary = mapper.fromUpdateDTO(dto, glossary);
        Glossary save = repository.save(mappedGlossary);
        return save.getId();
    }

    @Override
    public Long delete(Long id) {
        Glossary glossary = repository.findById(id).orElseThrow(() -> new NotFoundException("GLOSSARY NOT FOUND!"));
        glossary.setDeleted(Boolean.TRUE);
        Glossary save = repository.save(glossary);
        return save.getId();
    }
}
