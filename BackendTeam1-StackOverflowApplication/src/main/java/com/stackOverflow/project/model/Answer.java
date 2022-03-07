package com.stackOverflow.project.model;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Answers")

public class Answer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long answer_id;
	
	
	@ManyToOne
	@JoinColumn(name = "post_id",nullable = false)
	private Post post;
	
	@Column(name = "answered_on", nullable = false)
	@JsonFormat(shape=JsonFormat.Shape.STRING , pattern="dd/MM/yyyy")
	private Date answered_on;
	
	@Column(name = "answer_description", nullable = true)
	private String answer_desc;

	//To be uncommented after the tag table is implemented
		//	@ManyToMany
	
	@ManyToOne
	@JoinColumn(name = "user_id",nullable = false)
	private User user;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="answer_id", referencedColumnName="answer_id")
	private List<Comments> comment;

	public long getAnswer_id() {
		return answer_id;
	}

	public void setAnswer_id(long answer_id) {
		this.answer_id = answer_id;
	}

	public Date getAnswered_on() {
		return answered_on;
	}

	public void setAnswered_on(Date answered_on) {
		this.answered_on = answered_on;
	}

	public String getAnswer_desc() {
		return answer_desc;
	}

	public void setAnswer_desc(String answer_desc) {
		this.answer_desc = answer_desc;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Comments> getComment() {
		return comment;
	}

	public void setComment(List<Comments> comment) {
		this.comment = comment;
	}
	 
	/*public void setPost(Post post)
	{
		this.post=post;
	}
	public Post getPost()
	{
		return post;
	}*/
	

}
