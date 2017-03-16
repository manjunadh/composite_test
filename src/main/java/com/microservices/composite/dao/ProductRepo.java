package com.microservices.composite.dao;

import org.springframework.data.repository.CrudRepository;

import com.microservices.composite.model.Product;

public interface ProductRepo extends CrudRepository<Product,String>{

}
