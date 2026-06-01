package com.org.product_design_project.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@Entity
public class Product {
	@Id
	@Column(unique = true)
	private String partNumber;
	
	private String partName;
	
	private String category;
	
	private double prize;
	
	private int stock;
	
	//convert to Lower case
	
	@PrePersist
	@PreUpdate
	public void convertlower() {
		if(partName !=null) {
			partName=partName.toLowerCase();
		}
	}
	
	//generate getters setters

	

	public String getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}

	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrize() {
		return prize;
	}

	public void setPrize(double prize) {
		this.prize = prize;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
	
	
}
