package com.besysoft.taller_mecanico.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SpringFoxConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.besysoft.taller_mecanico.controller"))
                .paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfo(
                "Taller mecanico API",
                "APIRest construida con Spring para uso de un taller mecanico - Backend",
                "V1",
                null,
                new Contact("Santiago", "https://github.com/santinuin", "santiago.nunez.ingas@gmail.com"),
                null,
                null,
                Collections.emptyList()
        );
    }
}
