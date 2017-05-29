package com.trips.entity;
// Generated May 1, 2017 9:59:44 PM by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Driver generated by hbm2java
 */
@Entity
@Table(name = "driver", catalog = "project_2")
public class Driver implements java.io.Serializable {

	private Integer driverId;
	private String driverName;
	private String phoneNumber;
	private Set<Car> cars = new HashSet<Car>(0);
	private Set<Bill> bills = new HashSet<Bill>(0);
	private Set<ScheduleControl> scheduleControls = new HashSet<ScheduleControl>(0);

	public Driver() {
	}

	public Driver(String driverName, String phoneNumber, Set<Car> cars, Set<Bill> bills,
			Set<ScheduleControl> scheduleControls) {
		this.driverName = driverName;
		this.phoneNumber = phoneNumber;
		this.cars = cars;
		this.bills = bills;
		this.scheduleControls = scheduleControls;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "driver_id", unique = true, nullable = false)
	public Integer getDriverId() {
		return this.driverId;
	}

	public void setDriverId(Integer driverId) {
		this.driverId = driverId;
	}

	@Column(name = "driver_name", length = 45)
	public String getDriverName() {
		return this.driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	@Column(name = "phone_number", length = 15)
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@OneToMany(mappedBy = "driver")
	public Set<Car> getCars() {
		return this.cars;
	}

	public void setCars(Set<Car> cars) {
		this.cars = cars;
	}

	@OneToMany(mappedBy = "driver")
	public Set<Bill> getBills() {
		return this.bills;
	}

	public void setBills(Set<Bill> bills) {
		this.bills = bills;
	}

	@OneToMany(mappedBy = "driver")
	public Set<ScheduleControl> getScheduleControls() {
		return this.scheduleControls;
	}

	public void setScheduleControls(Set<ScheduleControl> scheduleControls) {
		this.scheduleControls = scheduleControls;
	}

}
