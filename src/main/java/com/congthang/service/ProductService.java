package com.congthang.service;

import java.util.List;
import java.util.Optional;

import com.congthang.entity.Product;

public interface ProductService {
	public Product creatNewProduct(Product product);

	public Optional<Product> findProductById(Long id);

	public void deleteProductById(Long id);

	public List<Product> searchProductByName(String name);

	public List<Product> findAllProduct();

	public List<Product> getAllByBrand(String brand);
}
