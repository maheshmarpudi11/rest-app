package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.entity.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer>{

	ProductEntity findByProductName(String name);

	List<ProductEntity> findByProductNameAndProductCost(String name,String cost);
	
	//@Modifying
	@Query("select p from ProductEntity p where p.productName = :name and p.productCost =:cost")
	List<ProductEntity> searchBy(@Param("name")  String name, @Param("cost") String cost);

}
