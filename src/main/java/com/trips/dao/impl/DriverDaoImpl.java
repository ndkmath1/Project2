package com.trips.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.trips.dao.DriverDao;
import com.trips.entity.Driver;
import com.trips.model.DriverForm;
import org.springframework.transaction.annotation.Transactional;

@Repository
//@Transactional("hibernateTransactionManager")
public class DriverDaoImpl implements DriverDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveDriver(Driver driver) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(driver);
		
	}

	@Override
	public void updateDriver(Driver driver) {
		Session session = sessionFactory.getCurrentSession();
		session.update(driver);
		
	}

	@Override
	public List<Driver> listDriver() {
		Session session = sessionFactory.getCurrentSession();
		List<Driver> driveList = session.createQuery("from Driver").list();
		for (Driver driver: driveList){
			
		}
		return driveList;
	}

	@Override
	public Driver getDriverById(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.load(Driver.class, id);
	}

	@Override
	public void removeDriver(int id) {
		Session session = sessionFactory.getCurrentSession();
		Driver driver = (Driver) session.load(Driver.class, new Integer(id));
		if(driver != null){
			session.delete(driver);
		}
	}


}
