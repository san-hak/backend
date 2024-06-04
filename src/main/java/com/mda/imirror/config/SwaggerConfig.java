package com.mda.imirror.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "IMirror API",
                version = "v1"
        )
)
@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI() {

        return new OpenAPI();
    }
}
