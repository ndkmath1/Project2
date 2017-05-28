package com.trips.dao;

import java.util.List;
import java.util.Map;

import com.trips.entity.WeekSchedule;
import org.hibernate.Query;

public interface WeekScheduleDao {
	
	public void saveWeekSchedule(WeekSchedule weekSchedule);
	
	public void updateWeekSchedule(WeekSchedule weekSchedule);
	
	public List<WeekSchedule> listWeekSchedule();
	
	public WeekSchedule getWeekScheduleById(int id);
	
	public void removeWeekSchedule(int id);

	public Query getQuery();

	public Map<Integer, List<WeekSchedule>> getWeekSchedule();
	
}
