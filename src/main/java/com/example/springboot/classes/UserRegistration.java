package com.example.springboot.classes;

import java.util.List;


public class UserRegistration {

	private long userId;
	private String name;
    private List<UserType> userTypes;
    private UserType selectedUserType;
	private String emailAddress;
	private String phoneNumber;
	private String password;	
	private String confirmPassword;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<UserType> getUserTypes() {
		return userTypes;
	}

	public void setUserTypes(List<UserType> userType) {
		this.userTypes = userType;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public UserType getSelectedUserType() {
		return selectedUserType;
	}

	public void setSelectedUserType(UserType selectedUserType) {
		this.selectedUserType = selectedUserType;
	}
	
	
	

}
