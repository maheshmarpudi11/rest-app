package com.app.dto;

import java.util.List;

public class ApplicationResponseDTO {
	
	List<ProductDTO> productList;
	
	PurchaseDetailsDTO purchaseDetails;
	
	ErrorResponse errorDetails;

	
	public List<ProductDTO> getProductList() {
		return productList;
	}

	public void setProductList(List<ProductDTO> productList) {
		this.productList = productList;
	}

	public PurchaseDetailsDTO getPurchaseDetails() {
		return purchaseDetails;
	}

	public void setPurchaseDetails(PurchaseDetailsDTO purchaseDetails) {
		this.purchaseDetails = purchaseDetails;
	}

	public ErrorResponse getErrorDetails() {
		return errorDetails;
	}

	public void setErrorDetails(ErrorResponse errorDetails) {
		this.errorDetails = errorDetails;
	}
	
	
	

}
