package com.congthang.dto;

import java.util.ArrayList;
import java.util.List;

public class CartInfo {

  private int orderNum;
  private AppUserDTO appUserDTO;
  private final List<CartLineInfo> cartLines = new ArrayList<CartLineInfo>();

  public CartInfo() {

  }

  public int getOrderNum() {
    return orderNum;
  }

  public void setOrderNum(int orderNum) {
    this.orderNum = orderNum;
  }

  public AppUserDTO getAppUserDTO() {
    return appUserDTO;
  }

  public void setAppUserDTO(AppUserDTO appUserDTO) {
    this.appUserDTO = appUserDTO;
  }

  public List<CartLineInfo> getCartLines() {
    return cartLines;
  }

  private CartLineInfo findLineByProductId(long id) {
    for (CartLineInfo line : this.cartLines) {
      if (line.getProductInfo().getProductId().equals(id)) {
        return line;
      }
    }
    return null;
  }

  public void addProduct(ProductInfo productInfo, int quantity) {
    CartLineInfo line = this.findLineByProductId(productInfo.getProductId());

    if (line == null) {
      line = new CartLineInfo();
      line.setQuantity(0);
      line.setProductInfo(productInfo);
      this.cartLines.add(line);
    }
    int newQuantity = line.getQuantity() + quantity;
    if (newQuantity < 0) {
      this.cartLines.remove(line);
    } else {
      line.setQuantity(newQuantity);
    }

  }

  public void validate() {

  }

  public void updateProduct(long id, int quantity) {
    CartLineInfo line = this.findLineByProductId(id);

    if (line != null) {
      if (quantity < 0) {
        this.cartLines.remove(line);
      } else {
        line.setQuantity(quantity);
      }
    }
  }

  public void removeProduct(ProductInfo productInfo) {
    CartLineInfo line = this.findLineByProductId(productInfo.getProductId());
    if (line != null) {
      this.cartLines.remove(line);
    }

  }

  public boolean isEmpty() {
    return this.cartLines.isEmpty();
  }

  public int getQuantityTotal() {
    int quantity = 0;
    for (CartLineInfo line : this.cartLines) {
      quantity += line.getQuantity();
    }
    return quantity;
  }

  public double getAmountTotal() {
    double total = 0;
    for (CartLineInfo line : this.cartLines) {
      total += line.getQuantity();
    }
    return total;
  }
}
