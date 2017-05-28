package com.trips.service.impl;

import com.trips.dao.WeekScheduleDao;
import com.trips.entity.WeekSchedule;
import com.trips.util.PaginationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trips.service.WeekScheduleService;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Transactional
@Qualifier("hibernateTransactionManager")
public class WeekScheduleServiceImpl implements WeekScheduleService {

    @Autowired
    WeekScheduleDao weekScheduleDao;

    @Override
    public List<WeekSchedule> getListWeekSchedule() {
        return weekScheduleDao.listWeekSchedule();
    }

    @Override
    public PaginationUtil<WeekSchedule> paging(int currentPage) {
        return new PaginationUtil<WeekSchedule>(weekScheduleDao.getQuery(), currentPage);
    }

    @Override
    public Map<Integer, List<WeekSchedule>> getWeekSchedule() {
        return weekScheduleDao.getWeekSchedule();
    }

    @Override
    public WeekSchedule getWeekScheduleId(int id) {
        return weekScheduleDao.getWeekScheduleId(id);
    }

    @Override
    public List<WeekSchedule> findWeekSchedule(Integer routeId, Date date) {
        return weekScheduleDao.findWeekSchedule(routeId, date);
    }


}
