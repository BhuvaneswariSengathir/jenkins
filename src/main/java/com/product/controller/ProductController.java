package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.product.model.Product;
import com.product.service.ProductService;

@RestController

public class ProductController {
	@Autowired
	ProductService service;
	
	@GetMapping("/listall")
	public List<Product>list(){
		return service.listAll();
	}
	//@PostMapping("/addproduct")
	@RequestMapping(value="/addproduct",method=RequestMethod.POST)
	public Product add(@RequestBody Product product) {
		service.add(product);
		System.out.println(product);
		return product;
		
	}
	
	@GetMapping("/hello/{name}/{name1}")
	public String sayname(@PathVariable ("name") String name,
			@PathVariable("name1") String name1 ) {
		return name+" "+name1;
	}
	
	@GetMapping("/getname/{name}")
	public Product getProduct(@PathVariable  ("name") String name) {
		return service.getProduct(name);
	}
	@GetMapping("/getid/{id}")
	public Product getProduct(@PathVariable ("id")int id) {
		return service.getProductbyId(id);
	}
	@DeleteMapping("/delete/{id}")
	public boolean deleteProduct(@PathVariable ("id")int id) {
		return service.delete(id);
	}
	
	@PutMapping("/update/{id}/{name}")
	public boolean updateproduct(@PathVariable ("id") int id,@PathVariable String name){
		return service.update(id, name);
		
	}
	@PostMapping("/addall")
	public List<Product> add1(@RequestBody List<Product> productList) {
		service.listofproduct(productList);
		System.out.println(productList);
		return productList;
		
	}
	


}
