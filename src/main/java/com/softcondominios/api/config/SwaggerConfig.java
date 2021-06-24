package com.softcondominios.api.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.joda.time.LocalDate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Response;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.softcondominios.api.rest.resource"))
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                .directModelSubstitute(LocalDate.class, String.class)
                .globalResponses(HttpMethod.GET, globalResponses)
                .globalResponses(HttpMethod.POST, globalResponses)
                .globalResponses(HttpMethod.DELETE, globalResponses)
                .globalResponses(HttpMethod.PATCH, globalResponses)
                .globalResponses(HttpMethod.PUT, globalResponses)
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {

        ApiInfo apiInfo = new ApiInfo(
                "Produtos API REST",
                "API REST do sistema de gestão Soft Condominios.",
                "1.0",
                "Terms of Service",
                new Contact("Carlos Machado", "https://github.com/webmaster-pnn/soft-condominios-api",
                        "machadopnn@gmail.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/licesen.html", new ArrayList<VendorExtension>()
        );

        return apiInfo;
    }
    
    final List<Response> globalResponses = Arrays.asList(
            new ResponseBuilder().code("400")
                                        .description("Erro de requisição")
                                        .build(),
            new ResponseBuilder().code("401")
                                        .description("Necessário autenticação")
                                        .build(),
            new ResponseBuilder().code("403")
                                        .description("Acesso negado")
                                        .build(),
            new ResponseBuilder().code("500")
                                        .description("Erro interno no servidor")
                                        .build()
    );
}
