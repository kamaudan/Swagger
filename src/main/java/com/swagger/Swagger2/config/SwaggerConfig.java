package com.swagger.Swagger2.config;




import com.swagger.Swagger2.controllers.RequisitionController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@PropertySource("classpath:swagger.properties")
@ComponentScan(basePackageClasses = RequisitionController.class)
@Configuration
public class SwaggerConfig {

    private static final String SWAGGER_API_VERSION ="0.1";
    private static final String LICENCE_TEXT = "Licence";
    private static final String title = "Requisition REST API";
    private static final String description = "RESTful API";

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .license(LICENCE_TEXT)
                .version(SWAGGER_API_VERSION)
                .build();
    }

    @Bean
    protected Docket requistionApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())

                .pathMapping("/")
                .select()
                .paths(PathSelectors.regex("/api.*"))
                .build();
    }


}
