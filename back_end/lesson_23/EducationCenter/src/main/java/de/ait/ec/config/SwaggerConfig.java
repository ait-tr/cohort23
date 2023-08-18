package de.ait.ec.config;

import de.ait.ec.dto.StandardResponseDto;
import io.swagger.v3.core.converter.AnnotatedType;
import io.swagger.v3.core.converter.ModelConverters;
import io.swagger.v3.core.converter.ResolvedSchema;
import io.swagger.v3.oas.models.*;
import io.swagger.v3.oas.models.headers.Header;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.parameters.RequestBody;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

/**
 * 8/16/2023
 * EducationCenter
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openApi() {
        ResolvedSchema resolvedSchema = ModelConverters.getInstance()
                .resolveAsResolvedSchema(
                        new AnnotatedType(StandardResponseDto.class).resolveAsRef(false));

        return new OpenAPI()
                .components(new Components()
                        .addSchemas("EmailAndPassword", emailAndPassword())
                        .addSecuritySchemes("cookieAuth", securityScheme())
                        .addSchemas("StandardResponseDto", resolvedSchema.schema.description("StandardResponseDto")))
                .addSecurityItem(buildSecurity())
                .paths(buildAuthenticationPath())
                .info(new Info().title("Todo Service API").version("0.1"));
    }

    static Paths buildAuthenticationPath() {
        return new Paths()
                .addPathItem("/login", buildAuthenticationPathItem())
                .addPathItem("/logout", buildLogoutPathItem());
    }

    private static PathItem buildLogoutPathItem() {
        return new PathItem().post(
                new Operation()
                        .addTagsItem("Authentication")
                        .responses(new ApiResponses()
                                .addApiResponse("200", new ApiResponse().description("Успешный выход"))));
    }
    private static PathItem buildAuthenticationPathItem() {
        return new PathItem().post(
                new Operation()
                        .addTagsItem("Authentication")
                        .requestBody(buildAuthenticationRequestBody())
                        .responses(new ApiResponses()
                                .addApiResponse("200",
                                        new ApiResponse()
                                                .description("Успешная аутентификация")
                                                .content(new Content().addMediaType("application/json",
                                                        new MediaType().schema(new Schema<>().$ref("StandardResponseDto"))))
                                                .headers(
                                                        Collections
                                                                .singletonMap("Set-Cookie",
                                                                        new Header()
                                                                                .example("JSESSIONID=1234")
                                                                                .description("Идентификатор сессии"))))
                                .addApiResponse("401",
                                        new ApiResponse()
                                                .description("Неверный логин или пароль")
                                                .content(new Content()
                                                        .addMediaType("application/json",
                                                                new MediaType()
                                                                        .schema(new Schema<>().$ref("StandardResponseDto")))))));
    }

    static RequestBody buildAuthenticationRequestBody() {
        return new RequestBody().content(
                new Content()
                        .addMediaType("application/x-www-form-urlencoded",
                                new MediaType()
                                        .schema(new Schema<>()
                                                .$ref("EmailAndPassword"))));
    }

    static SecurityRequirement buildSecurity() {
        return new SecurityRequirement().addList("CookieAuthentication");
    }

    static Schema<?> emailAndPassword() {
        return new Schema<>()
                .type("object")
                .description("Email и пароль пользователя")
                .addProperty("username", new Schema<>().type("string"))
                .addProperty("password", new Schema<>().type("string"));
    }

    static SecurityScheme securityScheme() {
        return new SecurityScheme()
                .name("cookieAuth")
                .type(SecurityScheme.Type.APIKEY)
                .in(SecurityScheme.In.COOKIE)
                .name("JSESSOINID");
    }


}
