package com.lhy.fool.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 *@author 98403
 *@Date: 2019-03-27 14:27
 *@Description: ConditionalOnProperty 动态添加 yml条件属性
 *
 */
@Configuration
@EnableSwagger2
@ConditionalOnProperty(prefix = "swagger",value = {"enable"},havingValue = "true")
public class Swagger2 {

    @Bean
    public Docket createRestApi() {
        ParameterBuilder ticketPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<Parameter>();
        ticketPar.name("xxxx")
                .description("xxxx")
                .modelRef(new ModelRef("string")).parameterType("header")
                .required(false)
                .build();
        //header中的ticket参数非必填，传空也可以
        //根据每个方法名也知道当前方法在设置什么参数
        pars.add(ticketPar.build());
        return new Docket(DocumentationType.SWAGGER_2)
                .globalOperationParameters(pars)
                .apiInfo(apiInfo())
                .select()
                //设置扫描的包名
                .apis(RequestHandlerSelectors.basePackage("com.lhy.fool"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        StringBuffer sb = new StringBuffer();
        sb.append("测试user {id:1; token:52b1c6cfd5de428da7648fd6c3846a42}");
        return new ApiInfoBuilder()
                //文档内容配置信息
                .title("xxx")
                .description(sb.toString())
                .version("1.0")
                .build();
    }
}
