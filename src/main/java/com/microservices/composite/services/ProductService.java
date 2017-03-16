package com.microservices.composite.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.composite.controller.CompositeController;
import com.microservices.composite.dao.ProductRepo;
import com.microservices.composite.model.Product;

@Service
public class ProductService {
	private static final Logger LOGGER = LoggerFactory.getLogger(CompositeController.class);
	@Autowired
	private ProductRepo productRepo;

	public List<Product> getProducts() {
		LOGGER.info("hitting product service for all products");
		List<Product> products = new ArrayList<>();
		productRepo.findAll().forEach(products::add);
		return products;
	}

	public Product getProductById(String id) {
		LOGGER.info("getting product by id " + id);
		return productRepo.findOne(id);
	}

	public String addProducts(Product product) {
		LOGGER.info("adding products in service class");
		productRepo.save(product);
		return "products added";
	}

}
