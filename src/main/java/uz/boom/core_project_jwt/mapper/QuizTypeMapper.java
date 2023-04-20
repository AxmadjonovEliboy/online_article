package uz.boom.core_project_jwt.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;
import uz.boom.core_project_jwt.dto.quiz.QuizTypeCreateDTO;
import uz.boom.core_project_jwt.dto.quiz.QuizTypeDTO;
import uz.boom.core_project_jwt.entity.QuizType;
import uz.boom.core_project_jwt.mapper.base.BaseMapper;

import java.util.List;

/**
 * @author Jarvis on Tue 23:46. 18/04/23
 */

@Component
@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface QuizTypeMapper extends BaseMapper {

    List<QuizTypeDTO> toDTO(List<QuizType> quizTypes);

    QuizTypeDTO toDTO(QuizType quizType);

    QuizType fromCreateDTO(QuizTypeCreateDTO createDTO);

    QuizType fromUpdateDTO(QuizTypeDTO updateDTO, @MappingTarget QuizType target);

}
