package com.app.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApplicationResponseDTO;
import com.app.dto.ProductDTO;
import com.app.exception.RecordNotFound;
import com.app.service.ProductService;
import com.app.service.ProductServiceRepo;

@Validated
// @Controller - MVC
@RestController // @Controller + @ResponseBody
@RequestMapping("/product")
public class ProductController {
	
	//@Autowired
	//private ProductService productService;
	
	@Autowired
	private ProductServiceRepo productService;
	

	// @RequestMapping(value="/create", requestMethod=GET)
	@PostMapping(value="/create")  
	public ResponseEntity<ProductDTO> createProduct(@Valid @RequestBody ProductDTO product) {
		
		ProductDTO savedProduct = productService.createProduct(product);
		
		return new ResponseEntity<ProductDTO>(savedProduct, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/products")  
	public ResponseEntity<List<ProductDTO>> getAllProducts() {
		
		List<ProductDTO> savedProductList = productService.getAllProducts();
		
		return new ResponseEntity<List<ProductDTO>>(savedProductList,HttpStatus.OK);
	}
	
	
	@PutMapping("/update")  
	public ProductDTO updateProduct(@RequestBody ProductDTO product) {
		
		ProductDTO savedProduct = productService.updateProduct(product);
		return savedProduct;
	}
	
	@DeleteMapping("/delete/{id}")  
	public String deleteProduct(@PathVariable(required = true ,name = "id") int id) {
		
		String response = productService.deleteProduct(id);
		return response;
	}
	
	@GetMapping("/searchByName/{name}")  
	public ProductDTO searchByName(@PathVariable("name")
		@Pattern(regexp ="^[A-Za-z]\\w{3,10}$", message = "path variable name should contain only charaters between min 5 to max 10") String name) {
		 
		ProductDTO response = productService.searchByName(name);
		
		if(response == null)
		{
			throw new RecordNotFound("Record not found with this product :" +name);
		}
		
		return response;
	}
	
	@GetMapping("/details")
	public ApplicationResponseDTO getDetails() {
		
		ApplicationResponseDTO response = new ApplicationResponseDTO();
		
		List<ProductDTO> productList = productService.getAllProducts();
		
		response.setProductList(productList);
		
		return response;
	}
	 	
	
	
	
}
