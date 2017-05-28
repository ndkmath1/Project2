package com.trips.util;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {

	public static final String DATE_TIME_PATTERN = "dd/MM/yyyy HH:mm:ss";

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
		LocalDate localDate = LocalDate.now().plusDays(1);
		return dtf.format(localDate);
	}
	
}
