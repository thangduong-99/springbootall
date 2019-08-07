package com.congthang.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.congthang.entity.Product;
import com.congthang.repository.ProductRepository;
import com.congthang.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductRepository productRepository;
	@Override
	public Product creatNewProduct(Product product) {
		productRepository.save(product);
		return product;
	}
	@Override
	public Optional<Product> findProductById(Long id) {
		Optional<Product> product = productRepository.findById(id);
		return product;
	}
	@Override
	public void deleteProductById(Long id) {
		productRepository.deleteById(id);
	}
	@Override
	public List<Product> searchProductByName(String name) {
		List<Product> list = (List<Product>) productRepository.searhProductByName(name);
		return list;
	}
	@Override
	public List<Product> findAllProduct() {
		List<Product> list = (List<Product>) productRepository.findAll();
		return list;
	}
	@Override
	public List<Product> getAllByBrand(String brand) {
		List<Product> list = productRepository.searhProductByBrand(brand);
		return list;
	}
	

}
