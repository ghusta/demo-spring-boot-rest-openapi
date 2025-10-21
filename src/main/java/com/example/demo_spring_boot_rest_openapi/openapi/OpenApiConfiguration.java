package com.example.demo_spring_boot_rest_openapi.openapi;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {

    @Bean
    public OpenAPI worldApiOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("World API")
                        .description("REST API for accessing World DB")
                        .version("0.0.1"));
    }

}
