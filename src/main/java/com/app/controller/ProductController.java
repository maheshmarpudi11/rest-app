package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Product;
import com.app.service.ProductService;

// @Controller - MVC
@RestController // @Controller + @ResponseBody
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	

	// @RequestMapping(value="/create", requestMethod=GET)
	@PostMapping(value="/create")  
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		
		Product savedProduct = productService.createProduct(product);
		
		return new ResponseEntity<Product>(savedProduct, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/products")  
	public ResponseEntity<List<Product>> getAllProducts() {
		
		List<Product> savedProductList = productService.getAllProducts();
		
		return new ResponseEntity<List<Product>>(savedProductList,HttpStatus.OK);
	}
	
	
	@PutMapping("/update")  
	public Product updateProduct(@RequestBody Product product) {
		
		Product savedProduct = productService.updateProduct(product);
		return savedProduct;
	}
	
	@DeleteMapping("/delete/{name}")  
	public String deleteProduct(@PathVariable("name") String name) {
		
		String response = productService.deleteProduct(name);
		return response;
	}
	
	
	
	
}
