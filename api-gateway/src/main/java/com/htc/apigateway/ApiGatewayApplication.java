package com.htc.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.htc.apigateway.filters.ErrorFilter;
import com.htc.apigateway.filters.PostFilter;
import com.htc.apigateway.filters.PreFilter;
import com.htc.apigateway.filters.RouteFilter;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
@EnableSwagger2
@EnableWebMvc
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select().apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build();
	}
	
	@Bean
	public PreFilter preFilter() {
		return new PreFilter();
	}

	@Bean
	public PostFilter postFilter() {
		return new PostFilter();
	}

	@Bean
	public ErrorFilter errorFilter() {
		return new ErrorFilter();
	}

	@Bean
	public RouteFilter routeFilter() {
		return new RouteFilter();
	}

}
