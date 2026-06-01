package com.org.product_design_project.Repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.org.product_design_project.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, String> {

	
	
	
	List<Product> findByCategory(String category);
	
	List<Product> findByPartNameContainingIgnoreCase(String partName);
	

	@Query("select p from Product p order by p.prize ASC")
	List<Product> findByOrderByPrizeAsc();
	
	@Query("select sum(p.prize*p.stock) from Product p")
	Double findByInventoryValue();
	
	
}
