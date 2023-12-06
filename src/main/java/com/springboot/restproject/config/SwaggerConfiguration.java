package com.springboot.restproject.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public OpenAPI api() {
        Info info = new Info()
                .title("Spring Boot Open API Test with Swagger")
                .version("v0.0.1")
                .description("This is the API specification for the rest project.");
        return new OpenAPI()
                .components(new Components())
                .info(info);
    }
}
