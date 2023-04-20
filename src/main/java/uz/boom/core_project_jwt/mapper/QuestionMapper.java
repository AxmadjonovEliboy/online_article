package uz.boom.core_project_jwt.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;
import uz.boom.core_project_jwt.dto.question.QuestionCreateDTO;
import uz.boom.core_project_jwt.dto.question.QuestionDTO;
import uz.boom.core_project_jwt.dto.question.QuestionTitleAnswerDTO;
import uz.boom.core_project_jwt.dto.question.QuestionUpdateDTO;
import uz.boom.core_project_jwt.entity.Question;
import uz.boom.core_project_jwt.mapper.base.BaseMapper;

import java.util.List;

/**
 * @author Jarvis on Sat 16:54. 15/04/23
 */
@Component
@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface QuestionMapper extends BaseMapper {

        List<QuestionDTO> toDTO_1(List<Question> questions);
    List<QuestionTitleAnswerDTO> toDTO(List<Question> questions);

    QuestionDTO toDTO(Question question);

    Question fromCreateDTO(QuestionCreateDTO createDTO);

    Question fromUpdateDTO(QuestionUpdateDTO updateDTO, @MappingTarget Question target);

}
