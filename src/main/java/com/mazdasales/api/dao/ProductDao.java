package com.mazdasales.api.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mazdasales.api.model.FootwearType;
import com.mazdasales.api.model.Products;

@Repository
public interface ProductDao extends JpaRepository<Products, Long> {

	Products findByMaterial(String material);
	
	Products findByStyle(String style);
	
	Products findBySize(Long size);
	
	List<Products> findByColor(String color);
	
	List<Products> findByType(FootwearType type);
	
	Long countByStyle(String style);
	
	Long countByType(FootwearType type);
	
	Products findByStyleAndMaterial(String style, String material);
}
