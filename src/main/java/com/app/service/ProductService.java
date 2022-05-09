package com.app.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.app.entity.Product;

@Service
public class ProductService {

	static Map<String,Product> productMap;
	
	static {
		productMap = new HashMap<String,Product>();
		productMap.put("Iphone", new Product(1, "Iphone", "iphone desc"));
		productMap.put("OnePlus", new Product(2, "OnePlus", "OnePlus desc"));
		productMap.put("Samsung", new Product(3, "Samsung", "Samsung desc"));
	
	}

	public Product createProduct(Product product) {
		productMap.put(product.getProductName(), product);
		
		return productMap.get(product.getProductName());
	}

	public List<Product> getAllProducts() {

		List<Product> products = new ArrayList();
		Set<String> keys = productMap.keySet();
		
		for (String key : keys) {
			products.add(productMap.get(key));			
		}
		
		return products;
	}

	public Product updateProduct(Product product) {
		productMap.put(product.getProductName(), product);
		
		return productMap.get(product.getProductName());
	}

	public String deleteProduct(String name) {
		productMap.remove(name);
		
		return "Product is removed with name : "+name ;
	}
	
	
	
	
	
	
	
}
