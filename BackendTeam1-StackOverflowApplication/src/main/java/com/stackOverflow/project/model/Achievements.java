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
@Table(name = "Achievements")
public class Achievements 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long achievement_id;
	
	@ManyToOne
	@JoinColumn(name = "user_id",nullable = false)
	private User user;
	
	@Column(name = "reputation_Score", nullable = true)
	private long rep_score;

	public User getUser() {
		return user;
	}
	
	public long getRep_score() {
		return rep_score;
	}

	public void setRep_score(long rep_score) {
		this.rep_score = rep_score;
	}
	
	
}
