package com.trips.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.trips.util.DateTimeUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.trips.dao.WeekScheduleDao;
import com.trips.entity.WeekSchedule;

@Repository
//@Transactional
//@Qualifier("hibernateTransactionManager")
public class WeekScheduleDaoImpl implements WeekScheduleDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveWeekSchedule(WeekSchedule weekSchedule) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(weekSchedule);
	}

	@Override
	public void updateWeekSchedule(WeekSchedule weekSchedule) {
		Session session = sessionFactory.getCurrentSession();
		session.update(weekSchedule);
	}

	@Override
	public List<WeekSchedule> listWeekSchedule() {
		Session session = sessionFactory.getCurrentSession();
		List<WeekSchedule> weekScheduleList = session.createQuery("from WeekSchedule").list();
		return weekScheduleList;
	}

	@Override
	public WeekSchedule getWeekScheduleById(int id) {
		Session session = sessionFactory.getCurrentSession();
		WeekSchedule weekSchedule = (WeekSchedule) session.load(WeekSchedule.class, new Integer(id));
		return weekSchedule;
	}

	@Override
	public void removeWeekSchedule(int id) {
		Session session = sessionFactory.getCurrentSession();
		WeekSchedule weekSchedule = (WeekSchedule) session.load(WeekSchedule.class, new Integer(id));
		if (null != weekSchedule) {
			session.delete(weekSchedule);
		}
	}

	@Override
	public Query getQuery() {
		return sessionFactory.getCurrentSession().createQuery("from WeekSchedule ");
	}

	@Override
	public Map<Integer, List<WeekSchedule>> getWeekSchedule() {
		Map<Integer, List<WeekSchedule>> m = new HashMap<>();
		for (int i = 1; i <= 7; ++i) {
			Query q = sessionFactory.getCurrentSession()
					.createQuery("from WeekSchedule w where w.dateTime >= :begin and w.dateTime < :end order by w.dateTime asc");
			q.setDate("begin", DateTimeUtil.getDateTime(i, 0));
			q.setDate("end", DateTimeUtil.getDateTime(i+1, 0));
			m.put(i, q.list());
		}
		return m;
	}

}
