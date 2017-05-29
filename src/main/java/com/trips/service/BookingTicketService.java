package com.trips.service;

import com.trips.entity.Bill;
import com.trips.entity.Station;
import com.trips.entity.StopPoint;
import com.trips.util.PaginationUtil;

import java.util.List;

/**
 * Created by Khanh Nguyen on 29/5/2017.
 */
public interface BookingTicketService {

    public List<StopPoint> getStopPointList(int routeId);

    public List<Station> getStationList(int routeId);

    public Bill booking(int wsId, String name, String phoneNumber, String cusStartPoint, String cusEndPoint, int stationIdFirst, int stationIdLast, int seatType);

    public Bill getBillId(int id);

    public PaginationUtil<Bill> paging(int currentPage);

}
