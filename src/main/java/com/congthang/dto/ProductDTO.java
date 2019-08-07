package com.congthang.dto;

import java.util.Date;

public class ProductDTO {
	private Long productId;
	private String name;
	private String brand;
	private String description;
	private Double price;
	private byte[] image;
    private Date createDate;
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
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public ProductDTO(Long productId, String name, String brand, String description, Double price, byte[] image,
			Date createDate) {
		super();
		this.productId = productId;
		this.name = name;
		this.brand = brand;
		this.description = description;
		this.price = price;
		this.image = image;
		this.createDate = createDate;
	}
	public ProductDTO() {
		super();
	}
    
}
