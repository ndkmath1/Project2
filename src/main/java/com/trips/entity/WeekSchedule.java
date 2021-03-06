package com.trips.entity;
// Generated May 1, 2017 9:59:44 PM by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * WeekSchedule generated by hbm2java
 */
@Entity
@Table(name = "week_schedule", catalog = "project_2")
public class WeekSchedule implements java.io.Serializable {

	private Integer weekScheduleId;
	private Car car;
	private Route route;
	private int weekday;
	private Date dateTime;

	public WeekSchedule() {
	}

	public WeekSchedule(Car car, Route route, int weekday, Date dateTime) {
		this.car = car;
		this.route = route;
		this.weekday = weekday;
		this.dateTime = dateTime;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "week_schedule_id", unique = true, nullable = false)
	public Integer getWeekScheduleId() {
		return this.weekScheduleId;
	}

	public void setWeekScheduleId(Integer weekScheduleId) {
		this.weekScheduleId = weekScheduleId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "car_id", nullable = false)
	public Car getCar() {
		return this.car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "route_id", nullable = false)
	public Route getRoute() {
		return this.route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	@Column(name = "weekday", nullable = false)
	public int getWeekday() {
		return this.weekday;
	}

	public void setWeekday(int weekday) {
		this.weekday = weekday;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_time", nullable = false, length = 19)
	public Date getDateTime() {
		return this.dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

}
