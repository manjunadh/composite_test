package com.microservices.composite.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservices.composite.model.Product;
import com.microservices.composite.services.ProductService;

@RestController
public class CompositeController {
	private static final Logger LOGGER = LoggerFactory.getLogger(CompositeController.class);
	@Autowired
	private ProductService productService;

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@RequestMapping("/hello")
	public String hello() {
		return "hello exp";
	}

	@RequestMapping("/test")
	public List<Product> test() {
		LOGGER.info("hitting test block in controller");
		return restTemplate().getForObject("http://localhost:9876/products/{id}", List.class);
	}

	@RequestMapping("/products")
	public List<Product> getProducts() {
		LOGGER.info("hitting products block in controller");
		return productService.getProducts();
	}

	@RequestMapping("/products/{id}")
	public Product getByid(@PathVariable String id) {
		LOGGER.info("fetching product info with id controller" + id);
		return productService.getProductById(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/products")
	public String addproducts(Product product) {
		LOGGER.info("adding product controller");
		return productService.addProducts(product);
	}
}
