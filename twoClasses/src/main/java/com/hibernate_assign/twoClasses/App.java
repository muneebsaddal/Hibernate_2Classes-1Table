package com.hibernate_assign.twoClasses;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import javax.persistence.criteria.*;

public class App {
	
	public static void main(String[] args) {
		Configuration cg = new Configuration().configure().addAnnotatedClass(CustomerComb.class);
		SessionFactory sessionFactory = cg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
//		insertData(session);
//		showData(session);
//		deleteById(session);
//		updateById(session);
		updateQuery(session);
		selectQuery(session);
		deleteQuery(session);
		
		session.close();
		sessionFactory.close();
	}
	
	public static void insertData(Session session) {
		CustomerDetail customerDetail = new CustomerDetail();
		CustomerComb customer = new CustomerComb();
		customerDetail.setCustomerAddress("H no 1234, Street abc, City blank");
		customerDetail.setCreditScore(4);
		customerDetail.setRewardPoints(3);
		customer.setCustomerId(2);
		customer.setCustomerName("b");
		customer.setCustomerDetail(customerDetail);
		Transaction trans = session.beginTransaction();
		session.save(customer);
		trans.commit();
	}
	
	private static void showData(Session session) {
		Transaction trans = session.beginTransaction();
	    CriteriaBuilder builder = session.getCriteriaBuilder();
	    CriteriaQuery<CustomerComb> criteria = builder.createQuery(CustomerComb.class);
	    criteria.from(CustomerComb.class);
	    List<CustomerComb> result = session.createQuery(criteria).getResultList();
	    for(CustomerComb i:result) {
	    	System.out.println(i.toString());
	    }
	    trans.commit();
	    session.close();
	}
	
	public static void deleteById(Session session) {		
		CustomerComb id = new CustomerComb();
		id.setCustomerId(2);
		Transaction trans = session.beginTransaction();
		session.delete(id);
		trans.commit();
	}
	
	public static void updateById(Session session) {
		CustomerComb id = (CustomerComb) session.load(CustomerComb.class, new Integer(1));
        id.setCustomerName("some one");
        Transaction trans = session.beginTransaction();
        session.update(id);
		trans.commit();
	}
	
	public static void selectQuery(Session session) {
		Transaction trans = session.beginTransaction();
		Query query = session.createQuery("from CustomerComb where customerId= :id ");
		query.setParameter("id", 1);
		List list = query.list();
		for(Object i:list) {
	    	System.out.println(i.toString());
	    }
		trans.commit();
	}
	
	public static void updateQuery(Session session) {
		Transaction trans = session.beginTransaction();
		Query query = session.createQuery("update CustomerComb set customerName = :customerName" + " where customerId= :customerId");
		query.setParameter("customerName", "abc");
		query.setParameter("customerId", 1);
		int result = query.executeUpdate();
		if(result > 0)
			System.out.println("Updated!");
		trans.commit();
	}
	public static void deleteQuery(Session session) {
		Transaction trans = session.beginTransaction();
		Query query = session.createQuery("delete CustomerComb where customerId= :customerId");
		query.setParameter("customerId", 2);
		int result = query.executeUpdate();
		if(result > 0)
			System.out.println("Deleted!");
		trans.commit();
	}
	
	/*** Insert query only support insert from another table. As we are using table which are not similar 
	 * insert query will not work. Instead updateById() and insertData() can be used
	 ***/
}
