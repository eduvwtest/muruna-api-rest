package com.muruna.apirest;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.muruna.apirest.constants.AppConstants;

@SpringBootApplication
public class MurunaApiRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(MurunaApiRestApplication.class, args);
    }

    @Bean
    public OpenAPI getOpenApiDocumentation(){
        return new OpenAPI().info(new Info().title(AppConstants.API_REST_TITLE).
                version(AppConstants.API_REST_VERSION));
    }

}
