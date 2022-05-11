package com.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.app.entity.ProductEntity;
import com.app.repository.ProductRepository;

@SpringBootApplication
public class RestAppApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(RestAppApplication.class, args);
	}
	
	@Autowired
	private ProductRepository productRepo;

	@Override
	public void run(String... args) throws Exception {
		
		ProductEntity product = new ProductEntity();
		product.setpName("iphone");
		product.setpDesc("iphone desc");
		product.setpCount(10);
		
		
		
	}

}




























