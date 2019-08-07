package com.mazdasales.api.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mazdasales.api.dao.ProductDao;
import com.mazdasales.api.exception.ResourceNotFoundException;
import com.mazdasales.api.model.FootwearType;
import com.mazdasales.api.model.Products;

@Service("ProductService")
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao dao;
	
	@Override
	public List<Products> findAllList() {
		// TODO Auto-generated method stub
		return dao.findAll(new Sort(Sort.Direction.DESC, "id"));
	}

	@Override
	public Products find(Long id) {
		// TODO Auto-generated method stub
		Products products = dao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
		return products;
	}

	@Override
	public ResponseEntity<Products> addProducts(Products products) {
		// TODO Auto-generated method stub
		dao.save(products);
		return ResponseEntity.status(HttpStatus.CREATED).body(products);
		
	}

	@Override
	@Transactional
	public ResponseEntity<Products> updateProduct(Long id, Products products) {
		// TODO Auto-generated method stub
		Products item = dao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
		item.setColor(products.getColor());
		item.setMaterial(products.getMaterial());
		item.setPrice(products.getPrice());
		item.setQuantity(products.getQuantity());
		item.setSize(products.getSize());
		item.setStyle(products.getStyle());
		item.setType(products.getType());
		
		Products updatedProducts = dao.save(item);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(updatedProducts);
	}

	@Override
	@Transactional
	public ResponseEntity<?> deleteProduct(Long id) {
		// TODO Auto-generated method stub
		Products prod = dao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
		dao.delete(prod);
		return ResponseEntity.ok().build();
	}

	@Override
	public Products findByMaterial(String material){
		// TODO Auto-generated method stub
		Products products = dao.findByMaterial(material);
		if(products == null) {
			throw new ResourceNotFoundException("Products", "material", material) ;
		}else {
			return products;
		}
	}

	@Override
	public Products findByStyle(String style) {
		// TODO Auto-generated method stub
		Products products = dao.findByStyle(style);
		if(products == null) {
			throw new ResourceNotFoundException("Products", "style", style) ;
		}else {
			return products;
		}
	}

	@Override
	public Products findBySize(Long size) {
		// TODO Auto-generated method stub
		Products products = dao.findBySize(size);
		if(products == null) {
			throw new ResourceNotFoundException("Products", "size", size) ;
		}else {
			return products;
		}
	}

	@Override
	public List<Products> findByColor(String color) {
		// TODO Auto-generated method stub
		return dao.findByColor(color);
	}

	@Override
	public Long countByStyle(String style) {
		// TODO Auto-generated method stub
		return dao.countByStyle(style);
	}

	@Override
	public Long countByType(FootwearType type) {
		// TODO Auto-generated method stub
		return dao.countByType(type);
	}

	@Override
	public List<Products> findByType(FootwearType type) {
		// TODO Auto-generated method stub
		return dao.findByType(type);
	}

	@Override
	public Long countAll() {
		// TODO Auto-generated method stub
		return dao.count();
	}

	@Override
	public Products findByStyleAndMaterial(String style, String material) {
		// TODO Auto-generated method stub
		return dao.findByStyleAndMaterial(style, material);
	}	
}
