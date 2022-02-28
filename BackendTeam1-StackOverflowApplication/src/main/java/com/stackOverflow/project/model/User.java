package com.stackOverflow.project.model;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "user_table")

public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long user_id;

	@Column(name = "user_name", nullable = false)
	private String UserName;

	@Column(name = "email", nullable = false)
	private String Email;

	@Column(name = "location", nullable = false)
	private String Location;

    @Lob
	@Column(name = "profile_image", nullable = true)
	private File Profile_Image;

	public File getProfile_Image() {
		return Profile_Image;
	}

	public void setProfile_Image(File profile_Image) {
		Profile_Image = profile_Image;
	}

	@Column(name = "phone_Number", nullable = false)
	private String Phone_Number;

	@Column(name = "about_me", nullable = true)
	private String About_Me;

	@Column(name = "up_votes", nullable = false)
	private long Up_Votes;

	@Column(name = "down_votes", nullable = false)
	private long Down_Votes;

	
	@Column(name = "created_on", nullable = false)
	@JsonFormat(shape=JsonFormat.Shape.STRING , pattern="dd/MM/yyyy")
	private Date Created_On;

	@Column(name = "rep_score", nullable = false)
	private long Rep_Score;

	@Column(name = "last_Acess_Date", nullable = false)
	@JsonFormat(shape=JsonFormat.Shape.STRING , pattern="dd/MM/yyyy")
	private Date Last_Acess_Date;

	/***@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "badges", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<Badges> badges;
	
	@OneToMany(mappedBy = "user_id", cascade = CascadeType.ALL)
	private Set<Badges> badge;***/
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "skill_id",nullable = false)
	private Skill skill;

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	public String getPhone_Number() {
		return Phone_Number;
	}

	public void setPhone_Number(String phone_Number) {
		Phone_Number = phone_Number;
	}

	public String getAbout_Me() {
		return About_Me;
	}

	public void setAbout_Me(String about_Me) {
		About_Me = about_Me;
	}

	public long getUp_Votes() {
		return Up_Votes;
	}

	public void setUp_Votes(long up_Votes) {
		Up_Votes = up_Votes;
	}

	public long getDown_Votes() {
		return Down_Votes;
	}

	public void setDown_Votes(long down_Votes) {
		Down_Votes = down_Votes;
	}

	public Date getCreated_On() {
		return Created_On;
	}

	public void setCreated_On(Date created_On) {
		Created_On = created_On;
	}

	public long getRep_Score() {
		return Rep_Score;
	}

	public void setRep_Score(long rep_Score)
	{
		Rep_Score = rep_Score;
	}

	public Date getLast_Acess_Date() 
	{
		return Last_Acess_Date;
	}

	public void setLast_Acess_Date(Date last_Acess_Date) {
		Last_Acess_Date = last_Acess_Date;
	}

}
