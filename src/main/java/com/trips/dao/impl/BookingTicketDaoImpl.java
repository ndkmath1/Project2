package com.trips.dao.impl;

import com.trips.dao.BookingTicketDao;
import com.trips.entity.Station;
import com.trips.entity.StopPoint;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Khanh Nguyen on 29/5/2017.
 */
@Repository
public class BookingTicketDaoImpl implements BookingTicketDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Station> getStationList(int routeId) {
        Query q = sessionFactory.getCurrentSession()
                .createQuery("from Station s where s.route.routeId=:routeId order by s.stationId asc");
        q.setParameter("routeId", routeId);
        return q.list();
    }

    @Override
    public List<StopPoint> getStopPointList(int routeId) {
        Query q = sessionFactory.getCurrentSession()
                .createQuery("from StopPoint s where s.route.routeId=:routeId order by s.stopPointId asc");
        q.setParameter("routeId", routeId);
        return q.list();
    }
}
