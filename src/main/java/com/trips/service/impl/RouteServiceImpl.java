package com.trips.service.impl;

import com.trips.dao.RouteDao;
import com.trips.entity.Route;
import com.trips.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Khanh Nguyen on 28/5/2017.
 */
@Service
@Transactional
@Qualifier("hibernateTransactionManager")
public class RouteServiceImpl implements RouteService {

    @Autowired
    RouteDao routeDao;

    @Override
    public List<Route> getRouteList() {
        return routeDao.getListRoute();
    }
}
