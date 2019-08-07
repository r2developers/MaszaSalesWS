package com.mazdasales.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mazdasales.api.model.FootwearType;
import com.mazdasales.api.model.Products;
import com.mazdasales.api.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductsController {

	@Autowired
	private ProductService productService;
	
	// Get All Products
	@GetMapping("/getAll")
	public Iterable<Products> getProductList(){
		return productService.findAllList();
	}
	
	// Add New Product
	@PostMapping("/add")
	public ResponseEntity<Products> addNewProduct(@RequestBody Products products){
		return productService.addProducts(products);
	}
	
	// Update Product
	@PutMapping("/update/{id}")
	public ResponseEntity<Products> updateProduct(@PathVariable Long id, @RequestBody Products products){
		return productService.updateProduct(id, products);
	}
	
	// Delete Product
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		productService.deleteProduct(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	// Get Product By Id
	@GetMapping("/get/{id}")
	public Products getProductById(@PathVariable Long id) {
		return productService.find(id);
	}
	
	// Products by material
	@GetMapping("/material/{material}")
	public Products getProductByMaterial(@PathVariable(name = "material") String material){
		return productService.findByMaterial(material);
	
	}
	
	// Products by style
	@GetMapping("/style/{style}")
	public Products getProductByStyle(@PathVariable(name = "style") String style){
		return productService.findByStyle(style);
	}
	
	// Products by Size
	@GetMapping("/size/{size}")
	public Products getProductBySize(@PathVariable(name = "size") Long size){
		return productService.findBySize(size);
	}
	
	// Products by color
	@GetMapping("/color/{color}")
	public Iterable<Products> getProductsByColor(@PathVariable(name = "color") String color){
		return productService.findByColor(color);
	}
	
	// Product By Type
	@GetMapping("/type/{type}")
	public List<Products> getProductByType(@PathVariable(name = "type") FootwearType type){
		return productService.findByType(type);
	}
	
	// Products by style and material
	@GetMapping("/{style}/{material}")
	public Products getProductByStyleAndMaterial(@PathVariable String style, @PathVariable String material) {
		return productService.findByStyleAndMaterial(style, material);
	}	
	
	/* ================================================================================================= */
	
	// Count of all product
	@GetMapping("/count/all")
	public Long getAllCount() {
		return productService.countAll();
	}

	// Count Product By Style
	@GetMapping("/count/style/{style}")
	public Long getCountByStyle(@PathVariable(name = "style") String style) {
		return productService.countByStyle(style);
	}
	
	// List of Enum 'Type'
	@GetMapping("/count/type/{type}")
	public Long getTypeList(@PathVariable(name = "type") FootwearType type) {
		return productService.countByType(type);
	}
}
