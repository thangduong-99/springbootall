package com.congthang.dto;

public class ProductInfo {
	private Long productId;
	private String name;
	private double price;
	
	public ProductInfo() {
		
	}

	public ProductInfo(Long productId, String name, double price) {
		super();
		this.productId = productId;
		this.name = name;
		this.price = price;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
