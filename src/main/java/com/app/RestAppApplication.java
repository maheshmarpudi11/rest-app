package com.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@RestController
public class RestAppApplication 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(RestAppApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RestAppApplication.class, args);
		LOGGER.info("Application is started..!");
	}
	
}




























