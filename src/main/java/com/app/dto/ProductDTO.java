package com.app.dto;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ProductDTO {
	
	@JsonIgnore
	private int productId;
	
	@NotEmpty(message="Product name can't be null or empty.")
	private String productName;
	
	private String productDesc;
	
	public ProductDTO(int productId, String productName, String productDesc) {
		this.productId = productId;
		this.productName = productName;
		this.productDesc = productDesc;
	}

	public ProductDTO() {
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

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productDesc=" + productDesc
				+ "]";
	}
	
	
}