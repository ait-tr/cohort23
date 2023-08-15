package de.ait.timepad.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.ait.timepad.dto.AuthResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.Charset;

/**
 * 8/15/2023
 * REST API
 *
 * @author Marsel Sidikov (AIT TR)
 */
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private ObjectMapper objectMapper;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        // отключаем все, чтобы работало (нам, в приложении, они не нужны)
        httpSecurity.csrf().disable();
        httpSecurity.headers().frameOptions().disable();

        httpSecurity
                .authorizeRequests()
                .antMatchers("/swagger-ui/**").permitAll() // сваггер разрешили всем
                .antMatchers("/api/**").authenticated() // все остальные запросы - только для аутентифицированных пользователей
                .and()
                .formLogin() // активируем встроенную страницу входа
                .successHandler((request, response, authentication) -> { // собственный текст при успешном входе
                    fillResponse(response, HttpStatus.OK, "Login successful");
                })
                .failureHandler(((request, response, exception) -> { // собственный текст при ошибочных данных для входа
                    fillResponse(response, HttpStatus.UNAUTHORIZED, "Incorrect username or password");
                }))
                .and()
                .exceptionHandling() // настраиваем перехват ошибок, чтобы вернуть собственный текст, если пользователь не аутентифицирован
                .defaultAuthenticationEntryPointFor(((request, response, authException) -> { // возвращаем сообщение - запрещено
                    fillResponse(response, HttpStatus.FORBIDDEN, "Forbidden operation");
                }), new AntPathRequestMatcher("/api/**"))
                .and()
                .logout();
        return httpSecurity.build();
    }

    private void fillResponse(HttpServletResponse response, HttpStatus status, String message) {
        try {
            response.setStatus(status.value());
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);

            AuthResponseDto authResponse = AuthResponseDto.builder()
                    .message(message)
                    .build();

            String body = objectMapper.writeValueAsString(authResponse);

            response.getWriter().write(body);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }


    // подключаем к Spring Security наш PasswordEncoder и UserDetailsService
    @Autowired
    public void bindUserDetailsServiceAndPasswordEncoder(
            PasswordEncoder passwordEncoder,
            UserDetailsService authenticatedUsersService,
            AuthenticationManagerBuilder authenticationManager) throws Exception {
        authenticationManager.userDetailsService(authenticatedUsersService).passwordEncoder(passwordEncoder);
    }

}
