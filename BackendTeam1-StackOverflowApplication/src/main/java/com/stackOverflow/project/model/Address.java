package com.stackOverflow.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Address")
public class Address {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long address_id;

    @OneToOne
	@JoinColumn(name = "user_id",nullable = false)
	private User user;

    @Column(name = "country_id", nullable = true)
	private int country_id;

    @Column(name = "city_id", nullable = true)
	private int city_id;

    @Column(name = "street_address", nullable = true)
	private String street_address;

    @Column(name = "pincode", nullable = true)
	private int pincode;

    public long getAddress_id() {
        return address_id;
    }

    public void setAddress_id(long address_id) {
        this.address_id = address_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
  
    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public String getStreet_address() {
        return street_address;
    }

    public void setStreet_address(String street_address) {
        this.street_address = street_address;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

}
