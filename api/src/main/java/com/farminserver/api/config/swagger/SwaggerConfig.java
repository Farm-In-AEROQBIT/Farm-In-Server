package com.farminserver.api.config.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("!prod")
@OpenAPIDefinition(
        servers = {
                @Server(url = "http://localhost:8080", description = "Local"),
        }
)
@io.swagger.v3.oas.annotations.security.SecurityScheme(
        name = "Bearer Authentication",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "Bearer"
)
@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi apiV1() {
        return GroupedOpenApi.builder()
                .group("v1")
                .pathsToMatch("/v1/api/**")
                .addOpenApiCustomizer(openApi ->
                        openApi.info(new io.swagger.v3.oas.models.info.Info()
                                        .title("Farm-in-Server")
                                        .description("Farm in Server REST API")
                                        .version("v1"))
                                .addSecurityItem(new SecurityRequirement().addList("Bearer Authentication"))
                )
                .build();
    }
}
