package com.example.gatewayservice.config;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class GatewayConfig {

    //configuration des route dynamique
    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("ms1-services", r -> r
                        .path("/api/field/**")
                        .or()
                        //.path("api/catagory/**")
                        .uri("lb://ms1-services") // doit etre exactement meme nom qui se trouve sur eurika
                ).route("ms2-services", r -> r
                        .path("/api/liable/**")
                        .uri("lb://ms2-services")
                ).build();
    }
}
