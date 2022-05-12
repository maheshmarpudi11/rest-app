package com.app.service;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.ProductDTO;
import com.app.entity.ProductEntity;
import com.app.repository.ProductRepository;
import com.app.wrapper.ProductWrapper;

@Service
public class ProductServiceRepo {

	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private ProductWrapper productWrapper;
	
	
	public ProductDTO createProduct(ProductDTO productDTO) {
		
		ProductEntity productEntity = productWrapper.convertDTOtoEntity(productDTO);
		
		System.out.println("productEntity :: "+productEntity);
	
		ProductEntity productEntityRes = productRepo.save(productEntity);
		
		System.out.println("productEntityRes :: "+productEntityRes);
		
		ProductDTO savedProduct = productWrapper.convertEntityToDTO(productEntityRes);
		
		return savedProduct;
	}

	public List<ProductDTO> getAllProducts() {
		// TODO Auto-generated method stub
		return Arrays.asList(new ProductDTO(1, "iphone", "iphone Desc"));
	}

	public ProductDTO updateProduct(ProductDTO product) {
		// TODO Auto-generated method stub
		return null;
	}

	public String deleteProduct(@Pattern(regexp = "^[A-Za-z]") String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public ProductDTO searchByName(
			@Pattern(regexp = "^[A-Za-z]\\w{3,10}$", message = "path variable name should contain only charaters between min 5 to max 10") String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
}
