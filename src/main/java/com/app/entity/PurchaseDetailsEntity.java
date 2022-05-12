package com.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PurchaseDetailsEntity {
	
	@JsonIgnore
	private int id;
	private String poNumber;
	private String invoice;
	private String pName;
	private String quantity;

	public PurchaseDetailsEntity() {
	}

	public PurchaseDetailsEntity(int id, String poNumber, String invoice, String pName, String quantity) {
		this.id = id;
		this.poNumber = poNumber;
		this.invoice = invoice;
		this.pName = pName;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPoNumber() {
		return poNumber;
	}

	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}

	public String getInvoice() {
		return invoice;
	}

	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "PurchaseDetailsEntity [id=" + id + ", poNumber=" + poNumber + ", invoice=" + invoice + ", pName="
				+ pName + ", quantity=" + quantity + "]";
	}
	

}
