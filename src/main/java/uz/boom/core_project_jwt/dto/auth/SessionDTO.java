package uz.boom.core_project_jwt.dto.auth;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class SessionDTO {
    private String accessToken;
    private String refreshToken;
    private String tokenType;
    private Long refreshTokenExpire;
    private Long issuedAt;
    private Long expiresIn;
}
