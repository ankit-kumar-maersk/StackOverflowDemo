package com.stackOverflow.project.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Skill")
public class Skill
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long skill_id;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "user_id",nullable = false)
	private User user;
	
	@Column(name = "skill1", nullable = true)
	String skill1;
	
	@Column(name = "skill2", nullable = true)
	String skill2;
	
	@Column(name = "skill3", nullable = true)
	String skill3;
	
	@Column(name = "skill4", nullable = true)
	String skill4;
	
	@Column(name = "skill5", nullable = true)
	String skill5;
	
	public Long getSkill_id() {
		return skill_id;
	}
	public void setSkill_id(Long skill_id) {
		this.skill_id = skill_id;
	}
	public String getSkill1() {
		return skill1;
	}
	public void setSkill1(String skill1) {
		this.skill1 = skill1;
	}
	public String getSkill2() {
		return skill2;
	}
	public void setSkill2(String skill2) {
		this.skill2 = skill2;
	}
	public String getSkill3() {
		return skill3;
	}
	public void setSkill3(String skill3) {
		this.skill3 = skill3;
	}
	public String getSkill4() {
		return skill4;
	}
	public void setSkill4(String skill4) {
		this.skill4 = skill4;
	}
	public String getSkill5() {
		return skill5;
	}
	public void setSkill5(String skill5) {
		this.skill5 = skill5;
	}
}
