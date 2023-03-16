package com.example.springboot.classes;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name="taxi")
public class Taxi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "taxi_id")
    private int taxiId;
    
    @Column(name = "registration_number")
    private String registrationNumber;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "driver_name")
    private String driverName;
    
    @Column(name = "location")
    private String location;/**geo coordinates**/   

    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
    
    public int getTaxiId() {
        return taxiId;
    }
    
    public void setTaxiId(int taxiId) {
        this.taxiId = taxiId;
    }
    
    public String getRegistrationNumber() {
        return registrationNumber;
    }
    
    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDriverName() {
        return driverName;
    }
    
    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }
    
    public String getLocation() {
        return location;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
    
}
