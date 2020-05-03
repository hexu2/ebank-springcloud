package com.hexu.ebank.springintegration.config.common;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger:
 *   basepackage: com.hexu.ebank.user.controller
 *   service:
 *     name: ebank-user
 *     description: ebank-user后端服务接口
 *     developer: hexu
 *     url: com.hexu.ebank
 *     email: 2212925883@qq.com
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {

    @Value(value = "${server.port}")
    String serverPort;

    @Value(value = "${swagger.basepackage}")
    String basepackage;

    @Value(value = "${swagger.service.name}")
    String name;

    @Value(value = "${swagger.service.description}")
    String description;

    @Value(value = "${swagger.service.developer}")
    String developer;

    @Value(value = "${swagger.service.email}")
    String email;

    @Value(value = "${swagger.service.url}")
    String url;

    //构建 api文档的详细信息函数,注意这里的注解引用的是哪个
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(this.name + " App Restful API")
                .description(this.description)
                .termsOfServiceUrl("http://localhost:"+serverPort)
                .contact(new Contact(this.developer,this.url,this.email))
                .version("1.0")
                .build();
    }

    /**
     * API
     * **/
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("SwaggerGroupOneAPI")
                .select()
                .apis(RequestHandlerSelectors.basePackage(this.basepackage))
                .paths(PathSelectors.any())
                .build();
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        //Swagger 静态资源处理
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/csrf/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}

