package com.trips.dao;

import com.trips.entity.Bill;
import com.trips.entity.Station;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by Khanh Nguyen on 29/5/2017.
 */

public interface BillDao {

    public int saveBill(Bill bill);

    public Station getStationId(int id);

    public int getNumBookedSeat(int wsId);

    public Bill getBillId(int billId);

    public Query getQuery();

}
