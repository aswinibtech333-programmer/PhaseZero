package com.org.product_design_project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.product_design_project.Entity.Product;
import com.org.product_design_project.ResponseStructure.ResponseStructure;
import com.org.product_design_project.Service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService service;

	/*
	 * save
	 * 
	 */
	@PostMapping("/products")
	public ResponseEntity<ResponseStructure<Product>> saveProductController(@RequestBody Product product) {
		Product p = service.saveProduct(product);
		ResponseStructure<Product> rs = new ResponseStructure<>();
		rs.setStatuscode(HttpStatus.CREATED.value());
		rs.setMessage("product record saved..");
		rs.setData(p);

		return new ResponseEntity<>(rs, HttpStatus.CREATED);

	}

	// list all product

	// search by name



	/*
	 * find all
	 */
	@GetMapping("/products")
	public ResponseEntity<ResponseStructure<List<Product>>> listAllProducts() {
		List<Product> p = service.listallrecords();

		ResponseStructure<List<Product>> rs = new ResponseStructure<>();

		rs.setStatuscode(HttpStatus.OK.value());
		rs.setMessage("Product is found");
		rs.setData(p);

		return new ResponseEntity<>(rs, HttpStatus.OK);
	}

	/*
	 * Search by name
	 */

	@GetMapping("/products/search/{partName}")
	public ResponseEntity<ResponseStructure<List<Product>>> searchname(@PathVariable String partName) {
		List<Product> data = service.findnamerecord(partName);
		ResponseStructure<List<Product>> rs = new ResponseStructure<>();

		if (data.isEmpty()) {
			rs.setStatuscode(HttpStatus.NOT_FOUND.value());
			rs.setMessage("record not found");
			rs.setData(data);

			return new ResponseEntity<>(rs, HttpStatus.NOT_FOUND);

		}
		rs.setStatuscode(HttpStatus.OK.value());
		rs.setMessage("record found");
		rs.setData(data);

		return new ResponseEntity<>(rs, HttpStatus.OK);

	}

	// filter by category
	@GetMapping("/products/{category}")
	public ResponseEntity<ResponseStructure<List<Product>>> filtercategory(@PathVariable String category) {
		List<Product> data = service.filtercategory(category);
		ResponseStructure<List<Product>> rs = new ResponseStructure<>();

		if (data.isEmpty()) {
			rs.setStatuscode(HttpStatus.NOT_FOUND.value());
			rs.setMessage("record not found");
			rs.setData(data);

			return new ResponseEntity<>(rs, HttpStatus.NOT_FOUND);

		}
		rs.setStatuscode(HttpStatus.OK.value());
		rs.setMessage("record found");
		rs.setData(data);

		return new ResponseEntity<>(rs, HttpStatus.OK);

	}

	// sort product by price
    @GetMapping("products/sort")
	public ResponseEntity<ResponseStructure<List<Product>>> sortedbyprize() {
		List<Product> data = service.sortbyprize();
		ResponseStructure<List<Product>> rs = new ResponseStructure<>();

		if (data.isEmpty()) {
			rs.setStatuscode(HttpStatus.NOT_FOUND.value());
			rs.setMessage("record not found");
			rs.setData(data);

			return new ResponseEntity<>(rs, HttpStatus.NOT_FOUND);

		}
		rs.setStatuscode(HttpStatus.OK.value());
		rs.setMessage("record found");
		rs.setData(data);

		return new ResponseEntity<>(rs, HttpStatus.OK);

	}
	// return total inventory value
    @GetMapping("products/inventory")
	public ResponseEntity<ResponseStructure<Double>> getInventory() {
		double val=service.findinventoryval();
		ResponseStructure<Double> rs = new ResponseStructure<>();

		
		rs.setStatuscode(HttpStatus.OK.value());
		rs.setMessage("Inventory value fetched successfully");
		rs.setData(val);

		return new ResponseEntity<>(rs, HttpStatus.OK);

	}
		
	}


