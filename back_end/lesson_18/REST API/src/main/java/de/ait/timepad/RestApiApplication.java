package de.ait.timepad;

import de.ait.timepad.exceptions.NotFoundException;
import de.ait.timepad.models.Article;
import de.ait.timepad.models.User;
import de.ait.timepad.repositories.ArticlesRepository;
import de.ait.timepad.repositories.UsersRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.rmi.NotBoundException;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class RestApiApplication {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                // разрешаем любому клиенту (allowedOrigins)
                // отправлять запросы на любой урл нашего сервера (addMapping)
                registry.addMapping("/**").allowedOrigins("*");
            }
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(RestApiApplication.class, args);
    }

}
