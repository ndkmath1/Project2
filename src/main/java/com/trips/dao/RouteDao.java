package com.trips.dao;

import com.trips.entity.Route;

import java.util.List;

/**
 * Created by Khanh Nguyen on 28/5/2017.
 */
public interface RouteDao {

    public Route getRouteById(int id);

    public List<Route> getListRoute();

}
