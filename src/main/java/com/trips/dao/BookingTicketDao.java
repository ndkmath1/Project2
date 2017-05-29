package com.trips.dao;

import com.trips.entity.Station;
import com.trips.entity.StopPoint;

import java.util.List;

/**
 * Created by Khanh Nguyen on 29/5/2017.
 */
public interface BookingTicketDao {

    public List<Station> getStationList(int routeId);

    public List<StopPoint> getStopPointList(int routeId);

}
