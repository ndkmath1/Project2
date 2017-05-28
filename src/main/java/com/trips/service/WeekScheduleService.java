package com.trips.service;

import com.trips.entity.WeekSchedule;
import com.trips.util.PaginationUtil;

import java.util.List;
import java.util.Map;

public interface WeekScheduleService {

    public List<WeekSchedule> getListWeekSchedule();

    public PaginationUtil<WeekSchedule> paging(int currentPage);

    public Map<Integer, List<WeekSchedule>> getWeekSchedule();

}
