package com.example.gatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayServiceApplication.class, args);
    }

	// la fonction DiscoveryClientRouteDefinitionLocator crée un localisateur de routes qui découvre dynamiquement les routes depuis Eureka
    @Bean // sur le browser tu tape localhost:portGateway pour ce cas (8080)/nom d'application qui se trouve sur dashbord d'eureka pour ce cas c'st ms1-service/api/field || cette methode reste static pour etre dynamique on a configure sur le fichier "GatewayConfig" les route dynamique
    public DiscoveryClientRouteDefinitionLocator routesDynamic(ReactiveDiscoveryClient reactiveDiscoveryClient, DiscoveryLocatorProperties discoveryLocatorProperties) {
        return new DiscoveryClientRouteDefinitionLocator(reactiveDiscoveryClient, discoveryLocatorProperties);

    }
}
