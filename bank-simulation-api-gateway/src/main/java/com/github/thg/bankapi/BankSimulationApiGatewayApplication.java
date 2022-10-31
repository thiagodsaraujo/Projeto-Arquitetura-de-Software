package com.github.thg.bankapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BankSimulationApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankSimulationApiGatewayApplication.class, args);
	}

}
