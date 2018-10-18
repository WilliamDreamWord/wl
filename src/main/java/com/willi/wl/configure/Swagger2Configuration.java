package com.willi.wl.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.nio.file.Path;

/**
 * @Author: William
 * @Description:
 * @Date: 2018/8/17 10:20
 **/
@Configuration
public class Swagger2Configuration {

    @Bean
    public Docket createRestApi() {
        return  new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.willi.wl.web"))
                .paths(PathSelectors.any())
                .build();
    }

    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("william's love the api document by swagger2")
                .description("simple style")
                .termsOfServiceUrl("www.william's.com")
                .version("1.0")
                .build();
    }
}
