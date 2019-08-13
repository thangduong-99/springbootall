package com.congthang.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "App_User", //
		uniqueConstraints = { //
				@UniqueConstraint(name = "APP_USER_UK", columnNames = "User_Name") })
public class AppUser implements Serializable{
	private static final long serialVersionUID = -2054386655979281969L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "User_Id", nullable = false)
	private Long userId;

	@Column(name = "User_Name", length = 36, nullable = false)
	private String userName;

	@Column(name = "Encryted_Password", length = 128, nullable = false)
	private String encrytedPassword;

	@Column(name = "Enabled", length = 1, nullable = false)
	private boolean enabled;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "EMAIL")
	private String email;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEncrytedPassword() {
		return encrytedPassword;
	}

	public void setEncrytedPassword(String encrytedPassword) {
		this.encrytedPassword = encrytedPassword;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public AppUser( String userName, String encrytedPassword, boolean enabled, String firstName,
			String lastName, String email) {
		super();
		this.userName = userName;
		this.encrytedPassword = encrytedPassword;
		this.enabled = enabled;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	public AppUser(Long userId, String userName, String encrytedPassword, boolean enabled, String firstName,
			String lastName, String email) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.encrytedPassword = encrytedPassword;
		this.enabled = enabled;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public AppUser() {
		super();
	}

}