package com.org.product_design_project.Dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.org.product_design_project.Entity.Product;
import com.org.product_design_project.Repository.ProductRepository;

@Repository
public class ProductDao {

	 @Autowired
		private ProductRepository productrepository;
	 
	 
	 //save
	 public Product saveProduct(Product product) {
		 if(productrepository.existsById(product.getPartNumber())) {
			 throw new RuntimeException("PartNumber already Exist");
		 }
		 if(product.getPrize()<0) {
			 throw new RuntimeException("Prize cannot be Negative...");
		 }
		 if(product.getStock()<0) {
			 throw new RuntimeException("Stock Cannot be negative...");
		 }
		 return productrepository.save(product);
	 }
	 
	 
	 //FindAll
	 public List<Product> findAll(){
		 return productrepository.findAll();
	 }
	 
	 //sorted by price
	 public List<Product> sortedByPrice(){
		 return productrepository.findByOrderByPrizeAsc();
	 }
	 
	 //FindByCategory
	 
	 public List<Product> filterByCategory(String category){
		 return productrepository.findByCategory(category);
	 }
	 
	 //search by name
	 
	 public List<Product> filterName(String partName){
		 return productrepository.findByPartNameContainingIgnoreCase( partName);
	 }
	 //return inventory value
	 public Double findInventory() {
		 return productrepository.findByInventoryValue();
		 
	 }
		
}
