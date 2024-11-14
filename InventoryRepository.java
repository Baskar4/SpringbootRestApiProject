package com.techpalle1.springbootrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techpalle1.springbootrest.entity.Product;

@Repository
public interface InventoryRepository extends JpaRepository<Product, Integer> {

}
