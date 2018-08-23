package com.jusfoun.ssz.web.crowd;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Desc:
 * Author: chengzhx76@qq.com
 * Date: 2017/9/8
 */
@EnableSwagger2
@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan("com.jusfoun.ssz")
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class CrowdServiceApplication {
    @Value("${swagger.path}")
    private String path;
    @Value("${swagger.title}")
    private String title;
    @Value("${swagger.description}")
    private String description;
    @Value("${swagger.contact}")
    private String contact;
    @Value("${swagger.version}")
    private String version;

    public static void main(String[] args) {
        SpringApplication.run(CrowdServiceApplication.class, args);
    }

    @Bean
    public Docket createRestApi() {// 创建API基本信息
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(path))// 扫描该包下的所有需要在Swagger中展示的API，@ApiIgnore注解标注的除外
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {// 创建API的基本信息，这些信息会在Swagger UI中进行显示
        return new ApiInfoBuilder()
                .title(title)// API 标题
                .description(description)// API描述
                .contact(contact)// 联系人
                .version(version)// 版本号
                .build();
    }
}
