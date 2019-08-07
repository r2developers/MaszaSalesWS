package com.mazdasales.api.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.mazdasales.api.model.FootwearType;
import com.mazdasales.api.model.Products;


public interface ProductService {

	public List<Products> findAllList();
	
	public Products find(Long id);
	
	public ResponseEntity<Products> addProducts(Products products);
	
	public ResponseEntity<Products> updateProduct(Long id, Products products);
	
	public ResponseEntity<?> deleteProduct(Long id);

	public Products findByMaterial(String material);
	
	public Products findByStyle(String style);
	
	public Products findBySize(Long size);
	
	public List<Products> findByColor(String color);
	
	public List<Products> findByType(FootwearType type);
	
	public Long countByStyle(String style);
	
	public Long countByType(FootwearType type);
	
	public Long countAll();
	
	public Products findByStyleAndMaterial(String style, String material);
}
