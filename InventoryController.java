package com.techpalle1.springbootrest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techpalle1.springbootrest.entity.Product;
import com.techpalle1.springbootrest.service.InventoryService;

@RestController
@RequestMapping("/api/v2")
public class InventoryController {
	
	private final InventoryService service;
	
	@Autowired
	public InventoryController(InventoryService service)
	{
		this.service=service;
	}
   
	@PostMapping("/saveProduct")
	public ResponseEntity<Product> saveProduct(@RequestBody Product p)
	{
		Product obj=service.saveProduct(p);
		return ResponseEntity.ok(obj);
	}
	@GetMapping("/readAllProducts")
	public List<Product> readAllProducts()
	{
		List<Product> products=service.readAllProducts();
		return products;
	}
	//-------------------------------------------------------//
	@GetMapping("/readProduct/{pno}")
	public Optional<Product> readProduct(@PathVariable int pno)
	{
		return service.readProduct(pno);
	}
	
	
	
	
	@PutMapping("/updateProduct/{pno}")
	public Product updateProduct(@PathVariable int  pno, @RequestBody Product np)
	{
		return service.updateProduct(pno, np);
	}
	@DeleteMapping("/deleteProduct/{pno}")
	public void deleteProduct(@PathVariable int pno)
	{
		service.deleteProduct(pno);
	}
}
