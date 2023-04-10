package uz.boom.core_project_jwt.dto;

import lombok.*;

/**
 * @author Jarvis on Sat 13:20. 08/04/23
 */

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthRegisterDto {

    private String fullName;
    private String email;
    private String password;
    private String phoneNumber;
    private String gender;
}
