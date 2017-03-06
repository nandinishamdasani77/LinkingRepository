package com.nandini.javaprojectbackend.DAO;

import java.util.List;

import com.nandini.javaprojectbackend.Model.*;


public interface ProductDAO {

	List<Product> list();
	
	Product getProduct(int id); 
}
