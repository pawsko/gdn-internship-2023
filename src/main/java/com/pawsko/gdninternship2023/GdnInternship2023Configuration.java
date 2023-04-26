package com.pawsko.gdninternship2023;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GdnInternship2023Configuration {
    @Bean
    public OpenAPI InternshipTaskOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Gdansk Internship API")
                        .description("API for Gdansk Internship Task Application")
                        .version("v0.0.1")
                        .license(new License()
                                .name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("Github internship task solution repository")
                        .url("https://github.com/pawsko/gdn-internship-2023"));
    }
}
