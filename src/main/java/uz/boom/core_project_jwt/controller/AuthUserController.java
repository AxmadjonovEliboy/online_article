package uz.boom.core_project_jwt.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uz.boom.core_project_jwt.controller.base.AbstractController;
import uz.boom.core_project_jwt.dto.AuthLoginDto;
import uz.boom.core_project_jwt.dto.AuthRegisterDto;
import uz.boom.core_project_jwt.dto.SessionDto;
import uz.boom.core_project_jwt.entity.AuthUser;
import uz.boom.core_project_jwt.response.DataDto;
import uz.boom.core_project_jwt.service.AuthUserService;

import java.util.List;


/**
 * @author Jarvis on Sat 11:14. 08/04/23
 */
@RestController
public class AuthUserController extends AbstractController<AuthUserService> {

    public AuthUserController(AuthUserService service) {
        super(service);
    }

    @PostMapping(value = PATH + "/auth/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DataDto<SessionDto>> login(@RequestBody AuthLoginDto dto) {
        return ResponseEntity.ok(service.login(dto));
    }

    @PostMapping(value = PATH + "/auth/register")
    public ResponseEntity<DataDto<SessionDto>> register(@RequestBody AuthRegisterDto dto) {
//        log.info("AuthUser RegisterDto :  {}  Request Ip Address : {} ", dto, SecurityUtils.getRequestIpAddress(httpServletRequest));
        return ResponseEntity.ok(service.register(dto));
    }

    @GetMapping(value = PATH+"/auths")
    public ResponseEntity<DataDto<List<AuthUser>>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }


}
