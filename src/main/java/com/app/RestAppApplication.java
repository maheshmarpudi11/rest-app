package com.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestAppApplication //implements CommandLineRunner
{
	private static final Logger LOGGER = LoggerFactory.getLogger(RestAppApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RestAppApplication.class, args);
		
		LOGGER.info("Application is started..!");
	}
	
	//@Autowired
	//private ProductRepository productRepo;

	/*
	 * @Override public void run(String... args) throws Exception {
	 * 
	 * ProductEntity product = new ProductEntity(); product.setpName("iphone");
	 * product.setpDesc("iphone desc"); product.setpCount(10);
	 * productRepo.save(product);
	 * 
	 * 
	 * 
	 * }
	 */

}




























