package com.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.ProductDTO;
import com.app.entity.ProductEntity;
import com.app.repository.ProductRepository;

@Service
@Transactional
public class ProductServiceRepo {

	@Autowired
	private ProductRepository productRepo;

	public ProductDTO createProduct(ProductDTO productDTO) {

		ProductEntity productEntity = new ProductEntity();
		ProductDTO resProductDTO = new ProductDTO();

		BeanUtils.copyProperties(productDTO, productEntity);
		ProductEntity productEntityRes = productRepo.save(productEntity);
		BeanUtils.copyProperties(productEntityRes, resProductDTO);

		return resProductDTO;
	}

	public List<ProductDTO> getAllProducts() {

		List<ProductEntity> listEntity = productRepo.findAll();

		List<ProductDTO> listDto = new ArrayList<>();

		for (ProductEntity entity : listEntity) {

			ProductDTO dto = new ProductDTO();

			BeanUtils.copyProperties(entity, dto);

			listDto.add(dto);

		}

		return listDto;
	}

	public ProductDTO updateProduct(ProductDTO product) {

		ProductEntity productEntity = new ProductEntity();
		ProductDTO resProductDTO = new ProductDTO();

		BeanUtils.copyProperties(product, productEntity);
		ProductEntity productEntityRes = productRepo.save(productEntity);
		BeanUtils.copyProperties(productEntityRes, resProductDTO);

		return resProductDTO;
	}

	public String deleteProduct(int id) {

		productRepo.deleteById(id);

		return "Product is delete with id :" + id;
	}

	public ProductDTO searchByName(String name) {
		ProductDTO resProductDTO = new ProductDTO();

		ProductEntity entity = productRepo.findByProductName(name);
		BeanUtils.copyProperties(entity, resProductDTO);

		return resProductDTO;
	}

	@Transactional(readOnly = true)
	public List<ProductDTO> searchBy(String name, String cost) {

		List<ProductEntity> listEntity = productRepo.findByProductNameAndProductCost(name,cost);

		List<ProductDTO> listDto = new ArrayList<>();

		for (ProductEntity entity : listEntity) {

			ProductDTO dto = new ProductDTO();

			BeanUtils.copyProperties(entity, dto);

			listDto.add(dto);

		}

		return listDto;
	}

}
