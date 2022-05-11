package com.app.wrapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.app.dto.ProductDTO;
import com.app.entity.ProductEntity;

@Component
public class ProductWrapper {

	public ProductEntity convertDTOtoEntity(ProductDTO product) {			
		
		ProductEntity entity = new ProductEntity();
		
		entity.setpName(product.getProductName());
		entity.setpDesc(product.getProductDesc());
		entity.setpCount(10);
		
		return entity;
		
	}

	public ProductDTO convertEntityToDTO(ProductEntity productEntityRes) {
		
		ProductDTO productDto = new ProductDTO();
		
		productDto.setProductName(productEntityRes.getpName());
		productDto.setProductDesc(productEntityRes.getpDesc());
	
		return productDto;
		
		
	}

}
