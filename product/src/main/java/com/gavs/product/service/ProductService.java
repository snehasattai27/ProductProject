package com.gavs.product.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gavs.product.model.Product;
import com.gavs.product.model.ProductRepository;


@Service
public class ProductService {
	@Autowired
	private ProductRepository repo;
	public List<Product> getAllTasks()
	{
		return repo.findAll();
	}
}
