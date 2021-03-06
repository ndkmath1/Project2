package com.trips.entity;
// Generated May 1, 2017 9:59:44 PM by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Account generated by hbm2java
 */
@Entity
@Table(name = "account", catalog = "project_2")
public class Account implements java.io.Serializable {

	private Integer accountId;
	private String email;
	private String password;
	private String name;
	private String phoneNumber;
	private String address;
	private String role;

	public Account() {
	}

	public Account(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public Account(String email, String password, String name, String phoneNumber, String address, String role) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.role = role;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "account_id", unique = true, nullable = false)
	public Integer getAccountId() {
		return this.accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	@Column(name = "email", nullable = false, length = 45)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "password", nullable = false, length = 60)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "name", length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "phone_number", length = 15)
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Column(name = "address", length = 60)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "role", length = 45)
	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
