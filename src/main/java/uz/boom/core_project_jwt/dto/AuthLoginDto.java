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
public class AuthLoginDto {
    public String email;
    public String password;
}