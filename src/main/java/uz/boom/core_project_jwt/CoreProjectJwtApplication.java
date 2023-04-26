package uz.boom.core_project_jwt;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import uz.boom.core_project_jwt.entity.AuthUser;
import uz.boom.core_project_jwt.enums.Language;
import uz.boom.core_project_jwt.enums.Role;
import uz.boom.core_project_jwt.repository.AuthUserRepository;

@SpringBootApplication
@RequiredArgsConstructor
public class CoreProjectJwtApplication {

    private final PasswordEncoder passwordEncoder;
    private final AuthUserRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(CoreProjectJwtApplication.class, args);
    }

//    @Bean
    public void run() throws Exception {
        CommandLineRunner runner1 = (a) -> {
            AuthUser user = AuthUser.builder()
                    .fullName("Jarvis")
                    .email("jarvis@gmail.com")
                    .password(passwordEncoder.encode("jarvis"))
                    .phoneNumber("+998997777777")
                    .role(Role.SUPPER_ADMIN)
                    .language(Language.UZB)
                    .status(true)
                    .isNonLocked(true)
                    .build();
            user.setCreatedBy(-1L);
            repository.save(user);
        };
        runner1.run("s", "b");
    }

}
