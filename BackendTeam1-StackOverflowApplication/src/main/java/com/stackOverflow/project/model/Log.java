package com.stackOverflow.project.model;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Log")
public class Log
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long log_id;
	
	@ManyToOne
	@JoinColumn(name = "user_id",nullable = false)
	private User user;
	
	@Column(name = "log_description", nullable = true)
	private String log_desc;
	
	@Column(name = "logged_on", nullable = false)
	@JsonFormat(shape=JsonFormat.Shape.STRING , pattern="dd/MM/yyyy")
	private Date logged_on;
	
//To be uncommented after the post table is implemented
/*	@ManyToOne
	@JoinColumn(name = "post_id",nullable = false)
	private Post post_id;
*/
	public long getLog_id() {
		return log_id;
	}

	public void setLog_id(long log_id) {
		this.log_id = log_id;
	}

	public User getUser() {
		return user;
	}
	public String getLog_desc() {
		return log_desc;
	}

	public void setLog_desc(String log_desc) {
		this.log_desc = log_desc;
	}

	public Date getLogged_on() {
		return logged_on;
	}
}
