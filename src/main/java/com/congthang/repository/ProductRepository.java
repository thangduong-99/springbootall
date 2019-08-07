package com.congthang.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.congthang.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	@Query(value = "Select * from product where NAME like %:name%", nativeQuery = true)
	public List<Product> searhProductByName(@Param("name") String name);

	@Query(value = "Select * from product where BRAND = :brand", nativeQuery = true)
	public List<Product> searhProductByBrand(@Param("brand") String brand);
}
