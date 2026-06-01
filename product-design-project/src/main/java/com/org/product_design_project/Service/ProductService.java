package com.org.product_design_project.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.product_design_project.Dao.ProductDao;
import com.org.product_design_project.Entity.Product;

@Service
public class ProductService {
	@Autowired
	private ProductDao dao;

	// save
	public Product saveProduct(Product product) {
		return dao.saveProduct(product);

	}

	// find all

	public List<Product> listallrecords() {
		return dao.findAll();
	}

	// find by name

	public List<Product> findnamerecord(String PartName) {
		return dao.filterName(PartName);

	}

	// filter by category

	public List<Product> filtercategory(String category) {
		return dao.filterByCategory(category);
	}
	// sortedBy prize

	public List<Product> sortbyprize() {
		return dao.sortedByPrice();
	}
	// find Inventory value

	public Double findinventoryval() {
		return dao.findInventory();
	}
}
