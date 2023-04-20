package uz.boom.core_project_jwt.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;
import uz.boom.core_project_jwt.dto.question.AnswerCreateDTO;
import uz.boom.core_project_jwt.dto.question.AnswerDTO;
import uz.boom.core_project_jwt.entity.Answer;
import uz.boom.core_project_jwt.mapper.base.BaseMapper;

import java.util.List;

/**
 * @author Jarvis on Sat 16:54. 15/04/23
 */
@Component
@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AnswerMapper extends BaseMapper {

    List<AnswerDTO> toDTO(List<Answer> answers);

    AnswerDTO toDTO(Answer answer);

    Answer fromCreateDTO(AnswerCreateDTO createDTO);

    List<Answer> fromCreateDTO(List<AnswerCreateDTO> createDTO);

    Answer fromUpdateDTO(AnswerDTO updateDTO, @MappingTarget Answer target);
}
