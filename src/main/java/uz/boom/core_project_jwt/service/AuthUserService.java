package uz.boom.core_project_jwt.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.boom.core_project_jwt.dto.AuthLoginDto;
import uz.boom.core_project_jwt.dto.AuthRegisterDto;
import uz.boom.core_project_jwt.dto.SessionDto;
import uz.boom.core_project_jwt.entity.AuthUser;
import uz.boom.core_project_jwt.mapper.AuthUserMapper;
import uz.boom.core_project_jwt.repository.AuthUserRepository;
import uz.boom.core_project_jwt.response.DataDto;
import uz.boom.core_project_jwt.security.jwt.JwtService;
import uz.boom.core_project_jwt.service.base.AbstractService;

import java.util.List;

/**
 * @author Jarvis on Sat 11:14. 08/04/23
 */
@Service
public class AuthUserService extends AbstractService<AuthUserRepository, AuthUserMapper> {

    private final AuthenticationManager authenticationManager;
    private final AuthUserRepository repository;

    private final JwtService jwtService;

    public AuthUserService(AuthUserRepository repository,
                           @Qualifier("authUserMapper")
                           AuthUserMapper mapper,
                           AuthenticationManager authenticationManager,
                           AuthUserRepository repository1,
                           JwtService jwtService) {
        super(repository, mapper);
        this.authenticationManager = authenticationManager;
        this.repository = repository1;
        this.jwtService = jwtService;
    }

    public DataDto<SessionDto> login(AuthLoginDto dto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        dto.getEmail(),
                        dto.getPassword()
                )
        );
        AuthUser user = repository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found !!!"));

        var sessionDto = jwtService.createSessionDto(user);
        return new DataDto<>(sessionDto);
    }

    public DataDto<SessionDto> register(AuthRegisterDto dto) {

        return null;
    }


    public DataDto<List<AuthUser>> getAll() {
        List<AuthUser> authUsers = repository.findAll();
        return new DataDto<>(authUsers);
    }
}
