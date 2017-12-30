package com.bartendingfeature.demo;

import com.bartendingfeature.demo.model.Drink;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;


@SpringBootApplication
public class BartenderApp {


		private Logger logger = LoggerFactory.getLogger(BartenderApp.class);

		@Bean
		public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder){
			return restTemplateBuilder.build();
		}

		public static void main(String[] args) {

			SpringApplication.run(BartenderApp.class, args);
		}

		@Bean
		public CommandLineRunner runner(RestTemplate restTemplate){
			return args ->{

			};
		}
}
