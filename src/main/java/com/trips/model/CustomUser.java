package com.trips.model;

import java.util.Set;

import com.trips.entity.Account;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CustomUser extends User {
	
	private String name;

	private Account account;
	
	public CustomUser(String username, String password, Set<GrantedAuthority> grantedAuthorities, String name, Account account) {
		super(username, password, grantedAuthorities);
		this.name = name;
		this.account = account;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
