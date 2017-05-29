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
 * Bill generated by hbm2java
 */
@Entity
@Table(name = "bill", catalog = "project_2")
public class Bill implements java.io.Serializable {

	private Integer billId;
	private Car car;
	private Driver driver;
	private Route route;
	private Station stationByStationIdLast;
	private Station stationByStationIdFirst;
	private Date dateTime;
	private String customerName;
	private String customerPhone;
	private String cusStartPoint;
	private String cusEndPoint;
//	private String ticket;
	private Byte status;
	private WeekSchedule weekSchedule;
	private Byte seatType;

	public Bill() {
	}

	public Bill(Car car, Driver driver, Route route, WeekSchedule weekSchedule, Date dateTime, String customerName, String customerPhone,
			String cusStartPoint, String cusEndPoint) {
		this.car = car;
		this.driver = driver;
		this.route = route;
		this.weekSchedule = weekSchedule;
		this.dateTime = dateTime;
		this.customerName = customerName;
		this.customerPhone = customerPhone;
		this.cusStartPoint = cusStartPoint;
		this.cusEndPoint = cusEndPoint;
	}

	public Bill(Car car, Driver driver, Route route, WeekSchedule weekSchedule, Station stationByStationIdLast, Station stationByStationIdFirst,
			Date dateTime, String customerName, String customerPhone, String cusStartPoint, String cusEndPoint,
			Byte status) {
		this.car = car;
		this.driver = driver;
		this.route = route;
		this.weekSchedule = weekSchedule;
		this.stationByStationIdLast = stationByStationIdLast;
		this.stationByStationIdFirst = stationByStationIdFirst;
		this.dateTime = dateTime;
		this.customerName = customerName;
		this.customerPhone = customerPhone;
		this.cusStartPoint = cusStartPoint;
		this.cusEndPoint = cusEndPoint;
//		this.ticket = ticket;
		this.status = status;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "bill_id", unique = true, nullable = false)
	public Integer getBillId() {
		return this.billId;
	}

	public void setBillId(Integer billId) {
		this.billId = billId;
	}

	@ManyToOne
	@JoinColumn(name = "week_schedule_id", nullable = false)
	public WeekSchedule getWeekSchedule() {
		return weekSchedule;
	}

	public void setWeekSchedule(WeekSchedule weekSchedule) {
		this.weekSchedule = weekSchedule;
	}

	@ManyToOne
	@JoinColumn(name = "car_id", nullable = false)
	public Car getCar() {
		return this.car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	@ManyToOne
	@JoinColumn(name = "driver_id", nullable = false)
	public Driver getDriver() {
		return this.driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	@ManyToOne
	@JoinColumn(name = "route_id", nullable = false)
	public Route getRoute() {
		return this.route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	@ManyToOne
	@JoinColumn(name = "station_id_last")
	public Station getStationByStationIdLast() {
		return this.stationByStationIdLast;
	}

	public void setStationByStationIdLast(Station stationByStationIdLast) {
		this.stationByStationIdLast = stationByStationIdLast;
	}

	@ManyToOne
	@JoinColumn(name = "station_id_first")
	public Station getStationByStationIdFirst() {
		return this.stationByStationIdFirst;
	}

	public void setStationByStationIdFirst(Station stationByStationIdFirst) {
		this.stationByStationIdFirst = stationByStationIdFirst;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_time", nullable = false, length = 19)
	public Date getDateTime() {
		return this.dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	@Column(name = "customer_name", nullable = false, length = 60)
	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@Column(name = "customer_phone", nullable = false, length = 15)
	public String getCustomerPhone() {
		return this.customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	@Column(name = "cus_start_point", nullable = false, length = 45)
	public String getCusStartPoint() {
		return this.cusStartPoint;
	}

	public void setCusStartPoint(String cusStartPoint) {
		this.cusStartPoint = cusStartPoint;
	}

	@Column(name = "cus_end_point", nullable = false, length = 45)
	public String getCusEndPoint() {
		return this.cusEndPoint;
	}

	public void setCusEndPoint(String cusEndPoint) {
		this.cusEndPoint = cusEndPoint;
	}

//	@Column(name = "ticket", length = 45)
//	public String getTicket() {
//		return this.ticket;
//	}
//
//	public void setTicket(String ticket) {
//		this.ticket = ticket;
//	}

	@Column(name = "status")
	public Byte getStatus() {
		return this.status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	@Column(name = "seat_type")
	public Byte getSeatType() {
		return this.seatType;
	}

	public void setSeatType(Byte seatType) {
		this.seatType = seatType;
	}

}
