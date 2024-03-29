package com.congthang.entity;

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
@Table(name = "order_detail")
public class OderDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ORDER_ID")
	private Long orderId;
	@Column(name = "PRODUCT_ID")
	private Long productId;
	@Column(name = "CART_ID")
	private Long cartId;
	@Column(name = "AMOUNT")
	private Double amount;
	@Column(name = "PRICE")
	private Double price;
	@Column(name = "QUANTITY")
	private int quantity;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CART_ID", insertable = false, updatable = false,//
			foreignKey = @ForeignKey(name = "CART_ID"))
	private Cart cart;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRODUCT_ID", insertable = false, updatable = false,//
			foreignKey = @ForeignKey(name = "PRODUCT_ID"))
	private Product product;
	public OderDetail(Long orderId, Long productId, Long cartId, Double amount, Double price, int quantity, Cart cart,
			Product product) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.cartId = cartId;
		this.amount = amount;
		this.price = price;
		this.quantity = quantity;
		this.cart = cart;
		this.product = product;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Long getCartId() {
		return cartId;
	}
	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public OderDetail() {
		super();
	}
	@Override
	public String toString() {
		return "OderDetail [orderId=" + orderId + ", productId=" + productId + ", cartId=" + cartId + ", amount="
				+ amount + ", price=" + price + ", quantity=" + quantity + ", cart=" + cart + ", product=" + product
				+ "]";
	}
	
	
}
