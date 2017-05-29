package com.trips.service.impl;

import com.trips.dao.*;
import com.trips.entity.*;
import com.trips.service.BookingTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by Khanh Nguyen on 29/5/2017.
 */
@Service
@Transactional
@Qualifier("hibernateTransactionManager")
public class BookingTicketServiceImpl implements BookingTicketService {

    @Autowired
    BookingTicketDao bookingTicketDao;

    @Autowired
    RouteDao routeDao;

    @Autowired
    DriverDao driverDao;

    @Autowired
    CarDao carDao;

    @Autowired
    WeekScheduleDao weekScheduleDao;

    @Autowired
    BillDao billDao;

    @Override
    public List<StopPoint> getStopPointList(int routeId) {
        return bookingTicketDao.getStopPointList(routeId);
    }

    @Override
    public List<Station> getStationList(int routeId) {
        return bookingTicketDao.getStationList(routeId);
    }

    @Override
    public Bill booking(int wsId, String name, String phoneNumber,
                           String cusStartPoint, String cusEndPoint,
                           int stationIdFirst, int stationIdLast, int seatType) {
        int billStatus;
        if (billDao.getNumBookedSeat(wsId) < 8) {
           billStatus = 1;
        } else {
            billStatus = 0;
        }
        Bill bill = new Bill();
        WeekSchedule weekSchedule = weekScheduleDao.getWeekScheduleId(wsId);
        Car car = weekSchedule.getCar();
        Driver driver = weekSchedule.getCar().getDriver();
        Route route = weekSchedule.getRoute();
        bill.setRoute(route);
        bill.setCar(car);
        bill.setCusEndPoint(cusEndPoint);
        bill.setCusStartPoint(cusStartPoint);
        bill.setCustomerName(name);
        bill.setCustomerPhone(phoneNumber);
        bill.setDateTime(new Date());
        bill.setDriver(driver);
        bill.setSeatType((byte) seatType);
        Station first = billDao.getStationId(stationIdFirst);
        Station last = billDao.getStationId(stationIdLast);
        bill.setStationByStationIdFirst(first);
        bill.setStationByStationIdLast(last);
        bill.setStatus((byte) billStatus);
        int result = billDao.saveBill(bill);
        return billDao.getBillId(result);
    }
}
