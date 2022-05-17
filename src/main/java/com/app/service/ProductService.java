package com.app.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.constraints.Pattern;

import org.springframework.stereotype.Service;

import com.app.dto.ProductDTO;

@Service
public class ProductService {

	
	  static Map<String,ProductDTO> productMap;
	  
	  static { productMap = new HashMap<String,ProductDTO>();
	  productMap.put("Iphone", new ProductDTO(1, "Iphone", "iphone desc","20000",10));
	  productMap.put("OnePlus", new ProductDTO(2, "OnePlus", "OnePlus desc","30000",5));
	  productMap.put("Samsung", new ProductDTO(3, "Samsung", "Samsung desc","15000",15));
	  
	  }
	 

	public ProductDTO createProduct(ProductDTO product) {
		productMap.put(product.getProductName(), product);
		
		return productMap.get(product.getProductName());
	}

	public List<ProductDTO> getAllProducts() {

		List<ProductDTO> products = new ArrayList();
		Set<String> keys = productMap.keySet();
		
		for (String key : keys) {
			products.add(productMap.get(key));			
		}
		
		return products;
	}

	public ProductDTO updateProduct(ProductDTO product) {
		productMap.put(product.getProductName(), product);
		
		return productMap.get(product.getProductName());
	}

	public String deleteProduct(String name) {
		productMap.remove(name);
		
		return "Product is removed with name : "+name ;
	}

	public ProductDTO searchByName(String name) {
		
		ProductDTO product = productMap.get(name);
		
		return product;
	}
	
	
	
	
	
	
	
}
