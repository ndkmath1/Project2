package com.trips.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {

	public static final String DATE_PATTERN = "dd/MM/yyyy";

	public static final String DATE_TIME_PATTERN = "dd/MM/yyyy HH:mm:ss";

	public static Date stringToDate(String s) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat(DATE_PATTERN);
		return df.parse(s);
	}

	public static Date addDays(Date date, int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, days); //minus number would decrement the days
		return cal.getTime();
	}

	public static Timestamp getDateTime(int nextDay, int hour) {
		LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.of(0, 0, 0));
		localDateTime = localDateTime.plusDays(nextDay);
		localDateTime = localDateTime.plusHours(hour);
		Date date = Date.from(ZonedDateTime.of(localDateTime, ZoneId.systemDefault()).toInstant());
		return new Timestamp(date.getTime());
	}
	
	public static String getCurrentDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate localDate = LocalDate.now();
		return dtf.format(localDate);
	}
	
	public static String getNextDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate localDate = LocalDate.now();
		localDate = localDate.plusDays(1);
		return dtf.format(localDate);
	}
	
}
