package com.springjpa.mapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springjpa.mapping.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
