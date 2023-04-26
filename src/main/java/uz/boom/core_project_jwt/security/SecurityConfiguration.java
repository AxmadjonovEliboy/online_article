package uz.boom.core_project_jwt.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import uz.boom.core_project_jwt.security.jwt.JwtAuthenticationFilter;

import java.util.List;

/**
 * @author Jarvis on Sat 11:15. 08/04/23
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true
)
public class SecurityConfiguration {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authenticationProvider;


    private static final String[] WHITE_LIST = {
            "/api/v1/refresh/token",
            "/api/v1/auth/login",
            "/api/v1/auth/register",
            "/api/v1/article-type/getAll",
            "/api/v1/article-type/get/{id}",
            "/api/v1/article-titles/getAll/{articleTypeId}",
            "/api/v1/article-title/get/{id}",
            "/api/v1/articles/getAll",
            "/api/v1/article/get/{id}",
            "/api/v1/literature/getAll",
            "/api/v1/literature/get/{id}",
            "/api/v1/literature/getAll/{type}",
            "/api/v1/glossary/getAll",
            "/api/v1/glossary/getAll/{glossaryTypeId}",
            "/api/v1/glossary/get/{id}",
            "/api/v1/glossary-type/getAll",
            "/api/v1/glossary-type/get/{id}",
            "/api/v1/quiz-type/getAll",
            "/swagger-ui/**",
            "/api/docs/**",
    };


//    @Bean
//    CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.setAllowCredentials(true);
////        configuration.setAllowedOrigins(List.of("https://main.d1bvq2ei1fv6tu.amplifyapp.com"));
//        configuration.addAllowedOriginPattern("*");
//        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "PATCH", "DELETE"));
//        configuration.addAllowedHeader("*");
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }
    //                .cors(httpSecurityCorsConfigurer -> httpSecurityCorsConfigurer
//                        .configurationSource(corsConfigurationSource()))


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();


        http.cors().configurationSource(request -> {
            CorsConfiguration configuration = new CorsConfiguration();
            configuration.setAllowedOriginPatterns(List.of("*"));
            configuration.setAllowedMethods(List.of("GET", "POST", "OPTIONS", "PUT", "DELETE", "PATCH"));
            configuration.setAllowedHeaders(List.of("*"));
            configuration.setAllowCredentials(true);
            return configuration;
        });
        http
                .authorizeHttpRequests()
                .requestMatchers(WHITE_LIST)
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

}
