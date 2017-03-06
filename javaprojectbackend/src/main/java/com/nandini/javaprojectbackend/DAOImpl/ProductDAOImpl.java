package com.nandini.javaprojectbackend.DAOImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nandini.javaprojectbackend.DAO.ProductDAO;
import com.nandini.javaprojectbackend.Model.Product;

@Transactional
@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO {

	// private static List<Product> products=new ArrayList<Product>();
	/*
	 * static { Product prd=new Product(); prd.setId(1);
	 * prd.setName("MobileCover"); prd.setDescription("Fancy Mobile Cover");
	 * prd.setPrice(100); prd.setQty(10); products.add(prd); prd.setId(2);
	 * prd.setName("Power Bank");
	 * prd.setDescription("High Capacity power backup"); prd.setPrice(100);
	 * prd.setQty(10); products.add(prd); prd.setId(3); prd.setName("Tablets");
	 * prd.setDescription("Different tablets"); prd.setPrice(100);
	 * prd.setQty(10);
	 * 
	 * products.add(prd); }
	 */

	@Autowired
	private SessionFactory sessionFactory;


	public List<Product> list() {
		
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Product",Product.class).getResultList();
	}

	public Product getProduct(int id) {
		/*
		 * for(Product p:products) { if(p.getId()==id) { return p; } } return
		 * null;
		 */
		return sessionFactory.getCurrentSession().get(Product.class, id);
	}

}
