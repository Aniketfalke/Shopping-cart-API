package com.mindtree.config;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.extensions.Extension;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.context.annotation.Bean;

import java.lang.annotation.Annotation;

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
)
public class OpenApiConfig {

}
