package com.gants.rgm.alphaservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@Slf4j
@SpringBootApplication
@EnableAutoConfiguration
@EnableDiscoveryClient
public class AlphaServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(AlphaServiceApplication.class, args);
	}
}//end Application

