package com.congthang.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CART_ID")
	private int cartId;
	@Column(name = "USER_ID")
	private int userId;
	@Column(name = "AMOUNT")
	private Double amount;
	@Column(name = "ORDER_DATE")
	private Date orderDate;
	@Column(name = "ORDER_NUM")
	private int orderNum;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", foreignKey = @ForeignKey(name = "USER_ID"))
	private AppUser appUser;
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public AppUser getAppUser() {
		return appUser;
	}
	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}
	public Cart(int cartId, int userId, Double amount, Date orderDate, int orderNum, AppUser appUser) {
		super();
		this.cartId = cartId;
		this.userId = userId;
		this.amount = amount;
		this.orderDate = orderDate;
		this.orderNum = orderNum;
		this.appUser = appUser;
	}
	public Cart() {
		super();
	}
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", userId=" + userId + ", amount=" + amount + ", orderDate=" + orderDate
				+ ", orderNum=" + orderNum + ", appUser=" + appUser + "]";
	}

}
