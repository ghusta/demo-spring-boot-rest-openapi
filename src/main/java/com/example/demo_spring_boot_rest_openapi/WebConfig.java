package com.example.demo_spring_boot_rest_openapi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    /**
     * See <a href="https://spring.io/guides/gs/rest-service-cors">example</a>.
     */
    @Bean
    public WebMvcConfigurer corsConfigurer(Environment env) {
        String[] swaggerUiAllowedOrigins = env.getProperty("custom.external-swagger-ui.cors.allowed-origins", "").split(",");
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                if (swaggerUiAllowedOrigins.length != 0) {
                    registry.addMapping("/**") // Apply to all endpoints
                            .allowedOrigins(swaggerUiAllowedOrigins) // Swagger UI container
                            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                            .allowedHeaders("*")
                            .allowCredentials(true);
                }
            }
        };
    }
}