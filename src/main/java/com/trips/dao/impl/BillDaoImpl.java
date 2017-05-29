package com.trips.dao.impl;

import com.trips.dao.BillDao;
import com.trips.entity.Bill;
import com.trips.entity.Station;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Khanh Nguyen on 29/5/2017.
 */
@Repository
public class BillDaoImpl implements BillDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public int saveBill(Bill bill) {
        return (Integer) sessionFactory.getCurrentSession().save(bill);
    }

    @Override
    public Station getStationId(int id) {
        Query q = sessionFactory.getCurrentSession()
                .createQuery("from Station s where s.stationId=:stationId");
        q.setParameter("stationId", id);
        return (Station) q.uniqueResult();
    }

    @Override
    public int getNumBookedSeat(int wsId) {
        Query q = sessionFactory.getCurrentSession()
                .createQuery("from Bill b where b.weekSchedule.weekScheduleId=:wsId");
        q.setParameter("wsId", wsId);
        return q.list().size();
    }

    @Override
    public Bill getBillId(int billId) {
        Query q = sessionFactory.getCurrentSession()
                .createQuery("from Bill b where b.billId=:billId");
        q.setParameter("billId", billId);
        return (Bill) q.uniqueResult();
    }


}
