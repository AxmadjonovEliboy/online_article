package uz.boom.core_project_jwt.dto.base;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Jarvis on Tue 10:39. 11/04/23
 */
@Getter
@AllArgsConstructor
public abstract class GenericDTO implements BaseDTO {

    @NotBlank
    private Long id;
}
