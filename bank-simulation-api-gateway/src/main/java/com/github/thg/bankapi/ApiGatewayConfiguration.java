package com.github.thg.bankapi;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder){
        return builder.routes()
                .route(r -> r.path("/get")
                        .filters(p-> p
                                .addRequestHeader("token", "tita")
                                .addRequestParameter("cpf", "1234"))
                        .uri("http://httpbin.org:80"))
                .route(p-> p
                        .path("/conta/**")
                        .uri("lb://bank-simulation-api"))
                .route(p-> p
                        .path("/payments/**")
                        .uri("lb://bank-simulation-api-paymentslip"))
                .build();
    }
}
