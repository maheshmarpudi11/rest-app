package com.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_PRODUCT")
public class ProductEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name = "pId")
	private int productId;
	
	private String productName; // pname

	private String productDesc;
	
	private String productCost;
	
	private int productCount;

	public ProductEntity() {
	
	}

	public ProductEntity(int productId, String productName, String productDesc,String productCost, int productCount) {
		this.productId = productId;
		this.productName = productName;
		this.productDesc = productDesc;
		this.productCost = productCost;
		this.productCount = productCount;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public int getProductCount() {
		return productCount;
	}

	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}

	public String getProductCost() {
		return productCost;
	}

	public void setProductCost(String productCost) {
		this.productCost = productCost;
	}
}
