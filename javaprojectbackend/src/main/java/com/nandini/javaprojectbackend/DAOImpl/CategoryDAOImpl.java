package com.nandini.javaprojectbackend.DAOImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nandini.javaprojectbackend.DAO.CategoryDAO;
import com.nandini.javaprojectbackend.Model.Category;

@Transactional
@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	/* private static List<Category> categories = new ArrayList<Category>();
	
	 * static { Category cat=new Category(); cat.setId(1);
	 * cat.setName("MobileCover"); cat.setDescription("Fancy Mobile Cover");
	 * cat.setImageURL("covers1.png"); categories.add(cat);
	 * 
	 * cat.setId(2); cat.setName("Power Bank");
	 * cat.setDescription("High Capacity power backup");
	 * cat.setImageURL("covers2.png"); categories.add(cat);
	 * 
	 * 
	 * cat.setId(3); cat.setName("Tablets");
	 * cat.setDescription("Different tablets"); cat.setImageURL("covers2.png");
	 * categories.add(cat); }
	 */
	@Autowired
	private SessionFactory sessionFactory;

	public List<Category> list() {
		return sessionFactory.getCurrentSession().createQuery("from Category", Category.class).getResultList();
	}
	
	public Category get(int id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}
	
	public boolean add(Category category) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().persist(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
	}
	

/*	

	
	public boolean update(Category category)
	{
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
	}
	
	

public boolean delete(Category category)
{
	try {
		sessionFactory.getCurrentSession().delete(category);
		return true;
	} catch (Exception ex) {
		ex.printStackTrace();
		return false;
	}
	return true;
}
*/
}
