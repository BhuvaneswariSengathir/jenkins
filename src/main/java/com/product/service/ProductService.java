package com.product.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.product.model.Product;

@Service
public class ProductService {
	private static List<Product> list=new ArrayList();
	
	static {
		list.add(new Product(1,"iphone",200000));
		list.add(new Product(2,"redmi",35000));
	}
	public ProductService() {}
	
	
	public List<Product> listAll(){
		return list;
		
	}
	public boolean add(Product product) {
		list.add(product);
		return true;
	}
	public Product getProduct(String name) {
		Product p=null;
		for(Product pro:list) {
			if(pro.getName().equals(name)) {
			p=pro;
			System.out.println(p);
			}
		}
		return p; 
	}
	
	public Product getProductbyId(int id) {
		Product p=null;
		for(Product pro:list) {
			if(pro.getPid()==id) {
				p=pro;
				System.out.println(p);
			}
		}
		return p;
	}
	 public boolean update(int id,String name) {
	        for(Product p:list)
	        if (p.getPid()==id) {
	            p.setName(name);
	            return true;
	        }
	        return false;
	    }
	   public boolean delete(int id) {
		   for(Product p:list) {
	        	 if (p.getPid()==id) {
	 	            list.remove(p);
	 	           return true;
	         }
	      }
	        return false;

	   }
	   
		/*
		 * public boolean listofproduct(List<Product> productList) { for(Product
		 * p:productList) { list.add(p); } return true; }
		 */
	   
	   
	   public boolean listofproduct(List<Product> productList) {
		  
			   list.addAll(productList);
		   
		     return true;
	   }
	   
	   
}
