package com.techpalle1.springbootrest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.techpalle1.springbootrest.entity.Product;
import com.techpalle1.springbootrest.repository.InventoryRepository;

@Service
public class InventoryService {
	
	private final InventoryRepository repository;
	@Autowired
	public InventoryService(InventoryRepository repository)
	{
		this.repository=repository;
	}
	// insertion operation
	
	public Product saveProduct(Product p)
	{
		Product obj=repository.save(p);
		return obj;
	}
  //	READ OPERATION
	public List<Product> readAllProducts()
	{
		List<Product> products=repository.findAll();
		return products;
	}
	//-------------------------------------------------------------------------//
	public Optional<Product> readProduct(int pno){
		 Optional<Product> product= repository.findById(pno);
		 return product;
	}
				
	//UPDATE OPERATION BASED ON ID
	public Product updateProduct(int pno,Product np)
	{
		Optional<Product> item=repository.findById(pno);
		if(item.isPresent())
		{
			Product p=item.get();
			p.setPname(np.getPname());
			p.setPprice(np.getPprice());
			p.setPqty(np.getPqty());
			return repository.save(p);
		}
		else
		{
			throw new RuntimeException("Product not foind");
		}
	}
	//DELETE OPRATION
	public void deleteProduct(int pno)
	{
		repository.deleteById(pno);	
	}
	
}
