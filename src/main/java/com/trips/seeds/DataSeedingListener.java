package com.trips.seeds;

import com.trips.dao.CarDao;
import com.trips.dao.DriverDao;
import com.trips.dao.RouteDao;
import com.trips.dao.WeekScheduleDao;
import com.trips.entity.*;
import com.trips.util.DateTimeUtil;
import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.trips.repository.UserRepository;

@Component
public class DataSeedingListener implements ApplicationListener<ContextRefreshedEvent> {
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository accountRepository;

	@Autowired
	CarDao carDao;

	@Autowired
	RouteDao routeDao;

	@Autowired
	private WeekScheduleDao weekScheduleDao;

	@Autowired
	DriverDao driverDao;

	private DataFactory df = new DataFactory();

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		System.out.println("### onApplicationEvent");
//		insertAccount("ndkmath1@gmail.com", "123456", "Khanh Nguyen", "0123 456 789", "1 Đại Cồ Việt, Hai Bà Trưng");
//		insertAccount("admin@gmail.com", "123456", "Admin", "0978 098 098", "100 Giải Phóng, Hai Bà Trưng");
//		for (int i = 0; i < 100; ++i) {
//			insertAccount(df.getEmailAddress(), df.getRandomChars(6, 10), df.getName(), df.getNumberText(10), df.getAddress());
//		}
		//insertSchedule();
//		insertDriver();
		//insertCar();
	}
	
	private void insertAccount(String email, String password, String name, String phoneNumber, String address) {
		if (accountRepository.findByEmail(email) == null) {
			Account admin = new Account();
			admin.setEmail(email);
			admin.setPassword(passwordEncoder.encode(password));
			admin.setName(name);
			admin.setPhoneNumber(phoneNumber);
			admin.setAddress(address);
			accountRepository.save(admin);
		}
	}

	private void insertSchedule() {
//		WeekSchedule weekSchedule = new WeekSchedule();
//		Car c = carDao.getCarById(1);
//		Route r = routeDao.getRouteById(1);
//		if (c != null && r != null) {
//			weekSchedule.setDateTime(DateTimeUtil.getDateTime(0, 6));
//			weekSchedule.setWeekday(1);
//			weekSchedule.setCar(c);
//			weekSchedule.setRoute(r);
//			weekScheduleDao.saveWeekSchedule(weekSchedule);
//		}

//		for (int i = 0; i < 6; ++i) {
//			WeekSchedule w = new WeekSchedule();
//			Car c = carDao.getCarById(1 + i);
//			Route r = routeDao.getRouteById(1);
//			w.setRoute(r);
//			w.setCar(c);
//			w.setWeekday(1);
//			w.setDateTime(DateTimeUtil.getDateTime(1, 6));
//		}
		for (int j = 1; j <= 14; ++j) {
			for (int i = 1; i <= 5; ++i) {
				dayOfRoute(i, (i - 1) * 6 + 1, j);
			}
		}

	}

	private void dayOfRoute(int route, int carBegin, int nextDay) {
		for (int i = 0; i < 6; ++i) {
			WeekSchedule w = new WeekSchedule();
			Car c = carDao.getCarById(carBegin + i);
			Route r = routeDao.getRouteById(route);
			w.setRoute(r);
			w.setCar(c);
			w.setWeekday(nextDay);
			w.setDateTime(DateTimeUtil.getDateTime(nextDay, 6 + 2*i));
			weekScheduleDao.saveWeekSchedule(w);
		}
	}

	private void insertDriver() {
		for (int i = 1; i < 100; ++i) {
			Driver d = new Driver();
			d.setDriverName(df.getName());
			d.setPhoneNumber(df.getNumberText(10));
			driverDao.saveDriver(d);
		}
	}

	private void insertCar() {
		for (int i = 1; i < 100; ++i) {
			Car c = new Car();
			c.setCarType("Limousine 9 seat");
			c.setNumSeatType1(5);
			c.setNumSeatType2(3);
			c.setLicensePlate(29 + df.getRandomChars(1).toUpperCase() + " - " + df.getNumberText(4));
			Driver d = driverDao.getDriverById(8+i);
			c.setDriver(d);
			carDao.addCar(c);
		}
	}

}
