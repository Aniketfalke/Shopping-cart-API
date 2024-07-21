package com.mindtree.config;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.extensions.Extension;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.Annotation;
import java.util.List;

/*

@OpenAPIDefinition(
        info =@Info(
                contact = @Contact(
                        name = "Aniket",
                        email = "falkeaniket12@gmail.com"
                ),
                description = "Personal product management API's",
                title = "Product Management",
                version = "1.0",
                termsOfService = "Term of services"
        ),
        servers = {
                @Server(
                description = "Local Env",
                        url = "http://localhost:8081/"
                )
        }
        ,
        security = {
                @SecurityRequirement(
                        name = "basicAuth"
                )
        }
)
@SecurityScheme(
        name = "basicAuth",
        description = "Basic authentication",
        scheme = "basic",
        type = SecuritySchemeType.HTTP,
        in = SecuritySchemeIn.HEADER
)

 */
@Configuration
public class OpenApiConfig {

        @Bean
        public OpenAPI customOpenAPI() {
                return new OpenAPI()
                        .info(new io.swagger.v3.oas.models.info.Info().title("Product Managemen")
                                .contact(new io.swagger.v3.oas.models.info.Contact().email("falkeaniket12@gmail.com").name("Aniket Falke"))
                                .description("Personal product management API's")
                                .version("1.0")
                                .termsOfService("Terms of services"))
                        .servers(List.of(new io.swagger.v3.oas.models.servers.Server().description("Local Env").url("http://localhost:8081/")))
                        .addSecurityItem(new io.swagger.v3.oas.models.security.SecurityRequirement().addList("BasicAuth"))
                        .components(new Components().addSecuritySchemes("BasicAuth", new io.swagger.v3.oas.models.security.SecurityScheme()
                                .name("BasicAuth").type(io.swagger.v3.oas.models.security.SecurityScheme.Type.HTTP).scheme("basic")));
        }
}
