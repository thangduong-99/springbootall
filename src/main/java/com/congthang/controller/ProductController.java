package com.congthang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.congthang.entity.Product;
import com.congthang.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	ProductService productService;

	@RequestMapping("/search/{name}")
	@ResponseBody
	public List<Product> searchByName(@PathVariable("name") String name) {
		List<Product> product =  productService.searchProductByName(name);
		return product;
	}
	@RequestMapping("/getall")
	@ResponseBody
	public List<Product> getAll(){
		List<Product> list = productService.findAllProduct();
		return list;
	}
	@RequestMapping("/getall/{brand}")
	@ResponseBody
	public List<Product> getAllBrand(@PathVariable("brand") String brand){
		List<Product> list = productService.getAllByBrand(brand);
		return list;
	}
}
