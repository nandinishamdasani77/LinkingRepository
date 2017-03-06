package com.nandini.javaprojectbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nandini.javaprojectbackend.DAO.CategoryDAO;
import com.nandini.javaprojectbackend.Model.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;

	private Category category;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.nandini.javaprojectbackend");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	@Test
	public void testAddCategory() {
		category = new Category();
		category.setName("MobileCover");
		category.setDescription("Fancy Mobile Cover");
		category.setImageURL("covers1.png");

		assertEquals("Successfully added in the table", true, categoryDAO.add(category));

	}

}
