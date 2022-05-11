package com.app.entity;

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
	private int pId;
	
	private String pName; // pname
	
	private String pDesc;
	
	private int pCount;

	public ProductEntity() {
	
	}

	public ProductEntity(int pId, String pName, String pDesc, int pCount) {
		this.pId = pId;
		this.pName = pName;
		this.pDesc = pDesc;
		this.pCount = pCount;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpDesc() {
		return pDesc;
	}

	public void setpDesc(String pDesc) {
		this.pDesc = pDesc;
	}

	public int getpCount() {
		return pCount;
	}

	public void setpCount(int pCount) {
		this.pCount = pCount;
	}

	@Override
	public String toString() {
		return "ProductEntity [pId=" + pId + ", pName=" + pName + ", pDesc=" + pDesc + ", pCount=" + pCount + "]";
	}
	
}
