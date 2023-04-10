package uz.boom.core_project_jwt.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;
import uz.boom.core_project_jwt.mapper.base.BaseMapper;

/**
 * @author Jarvis on Sat 11:14. 08/04/23
 */
@Component
@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AuthUserMapper extends BaseMapper {

}
