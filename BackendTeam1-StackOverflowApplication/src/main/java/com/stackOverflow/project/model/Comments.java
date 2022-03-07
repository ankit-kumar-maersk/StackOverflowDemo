package com.stackOverflow.project.model;

import java.util.Date;

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
@Table(name = "Comment")
public class Comments
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long comment_id;
	
	@ManyToOne
	@JoinColumn(name = "user_id",nullable = false)
	private User user;	
	//To be uncommented after the post table is implemented
	
	/*	@ManyToOne
		@JoinColumn(name = "post_id",nullable = false)
		private Post post_id;
	*/
	
	@Column(name = "comment_description", nullable = true)
	private String comment_desc;
	
	@Column(name = "commented_on", nullable = false)
	@JsonFormat(shape=JsonFormat.Shape.STRING , pattern="dd/MM/yyyy")
	private Date commented_on;
	
	
	public long getComment_id() {
		return comment_id;
	}

	public User getUser() {
		return user;
	}
	
	public String getComment_desc() {
		return comment_desc;
	}

	public void setComment_desc(String comment_desc) {
		this.comment_desc = comment_desc;
	}

	public Date getCommented_on() {
		return commented_on;
	}
}
