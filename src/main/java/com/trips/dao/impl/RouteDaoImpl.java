package com.trips.dao.impl;

import com.trips.dao.RouteDao;
import com.trips.entity.Route;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Khanh Nguyen on 28/5/2017.
 */
@Repository
//@Transactional("hibernateTransactionManager")
public class RouteDaoImpl implements RouteDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Route getRouteById(int id) {
        Query q = sessionFactory.getCurrentSession().createQuery("from Route where routeId=:routeId").setParameter("routeId", id);
        return (Route) q.uniqueResult();
    }

}
