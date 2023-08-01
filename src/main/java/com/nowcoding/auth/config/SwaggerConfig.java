package com.nowcoding.auth.config;

import com.fasterxml.classmate.TypeResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

@Configuration
@EnableWebMvc
public class SwaggerConfig {

    @Bean
    public Docket api(TypeResolver typeResolver) {
        return new Docket(DocumentationType.OAS_30)
//                .securityContexts(Arrays.asList(securityContext())) // 추가
//                .securitySchemes(Arrays.asList(apiKey())) // 추가
//                .additionalModels(typeResolver.resolve(MemberResponseDto.class))
//                .additionalModels(typeResolver.resolve(ErrorResponse.class))
//                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.nowcoding.auth.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    // 추가
    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .build();
    }

    // 추가
    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Arrays.asList(new SecurityReference("Authorization", authorizationScopes));
    }

    // 추가
    private ApiKey apiKey() {
        return new ApiKey("Authorization", "Authorization", "header");
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Auth API")
                .description("Auth 문서")
                .version("1.0")
                .build();
    }
}
