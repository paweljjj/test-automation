package com.pawel.automation.bank;

import com.pawel.automation.bank.common.Mapper;
import com.pawel.automation.bank.common.ModelMapperAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;
import static springfox.documentation.spi.DocumentationType.SWAGGER_2;

@EnableSwagger2
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Bean
    public Mapper mapper() {
        return new ModelMapperAdapter();
    }

    @Bean
    public Docket productApi() {
        return new Docket(SWAGGER_2)
                .select()
                .apis(basePackage("com.pawel.automation"))
                .build();
    }

}
