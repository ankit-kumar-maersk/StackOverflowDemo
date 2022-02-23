package com.stackOverflow.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "badges")
public class Badges {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long badge_id;
	
	@ManyToOne
	@JoinColumn(name = "user_id",nullable = false)
	private User user;


	@Column(name = "badge_name", nullable = false)
	private String badgename;
	
	@Column(name = "badge_class", nullable = false)
	private String badgeclass;

	public long getBadge_id() {
		return badge_id;
	}

	public void setBadge_id(long badge_id) {
		this.badge_id = badge_id;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getBadge_name() {
		return badgename;
	}

	public void setBadge_name(String badge_name) {
		this.badgename = badge_name;
	}

	public String getBadge_class() {
		return badgeclass;
	}

	public void setBadge_class(String badge_class) {
		this.badgeclass = badge_class;
	}
}
