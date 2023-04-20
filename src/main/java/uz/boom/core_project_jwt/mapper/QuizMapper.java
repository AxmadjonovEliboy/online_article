package uz.boom.core_project_jwt.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;
import uz.boom.core_project_jwt.mapper.base.BaseMapper;

/**
 * @author Jarvis on Sun 01:09. 16/04/23
 */
@Component
@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface QuizMapper extends BaseMapper {
}
