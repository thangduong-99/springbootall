package com.congthang.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name = "product")
public class Product implements Serializable{
	private static final long serialVersionUID = -1000119078147252957L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PRODUCT_ID")
	private Long productId;
	@Column(name = "NAME")
	private String name;
	@Column(name = "BRAND")
	private String brand;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "PRICE")
	private Double price;
	@Lob
	@Column(name = "IMAGE", length = Integer.MAX_VALUE, nullable = true)
	private byte[] image;
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREAT_DATE", nullable = false)
    private Date createDate;
	public Product(Long productId, String name, String brand, String description, Double price, byte[] image,
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
	public Product() {
		super();
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
