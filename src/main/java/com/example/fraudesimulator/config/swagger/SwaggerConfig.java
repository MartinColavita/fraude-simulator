package com.example.fraudesimulator.config.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@RequiredArgsConstructor
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi openApi() {
        return GroupedOpenApi.builder()
                .group("Fraude Simulator")
                .packagesToScan("com.example.fraudesimulator.controller")
                .build();
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Fraude Simulator API")
                        .version("1.0")
                        .description("Simulador de detección de fraude para transacciones de comerciantes")
                        .contact(new Contact()
                                .name("Martin Colavita")
                                .email("martincolavita@gmail.com")));
    }

}