package uz.boom.core_project_jwt.dto.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import uz.boom.core_project_jwt.dto.base.GenericDTO;

/**
 * @author Jarvis on Mon 14:18. 10/04/23
 */
@Getter
@Setter
@ToString
public class AuthUserUpdateDTO extends GenericDTO {


    private String fullName;
    private String email;
    private String phoneNumber;

    public AuthUserUpdateDTO(@NotBlank Long id, String fullName, String email, String phoneNumber) {
        super(id);
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }


}
