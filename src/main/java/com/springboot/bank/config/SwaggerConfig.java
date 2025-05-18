package com.springboot.bank.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI()
                .info(new Info()
                        .title("🏦 ok kada Bank & Account API")
                        .version("1.0")
                        .description("This API lets you create and fetch Banks and their linked Accounts."))
                .addSecurityItem(new SecurityRequirement().addList("basicAuth")) // 🛡 Enable "Authorize" button
                .components(new Components()
                        .addSecuritySchemes("basicAuth", new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("basic"))); // 🔐 Define Basic Auth scheme
    }
}
