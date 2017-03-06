package com.nandini.javaprojectbackend.DAO;

import java.util.List;

import com.nandini.javaprojectbackend.Model.Category;

public interface CategoryDAO {

	
	List<Category> list();
	
Category get(int id); 
  boolean add(Category category);

}
