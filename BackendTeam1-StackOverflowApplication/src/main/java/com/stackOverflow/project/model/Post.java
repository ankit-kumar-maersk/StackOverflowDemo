package com.stackOverflow.project.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="posts")
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long post_id;
	
	@Column(name = "title", nullable = false)
	private String post_title;
	
	@Column(name = "description", nullable = false)
	private String post_description;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_on", nullable = false)
	private Date created_on=new Date();
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "lastUpdated_on", nullable = false)
	private Date lastUpdated_on=new Date();
	
	@ManyToOne(cascade= { CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinTable(name="user_id")
	private User user;
	/*
	@ManyToMany()
	@JoinTable(name="questions_tag", joinColumns=@JoinColumn(name="post_id"),inverseJoinColumns=@JoinColumn(name="tag_id"))
	private Set<Tag> tags;
	*/
	@OneToMany(mappedBy="posts",cascade=CascadeType.ALL)
	private List <Answer> answers;
	
	public Long getPost_id() {
		return post_id;
	}
	
	public void setPost_id(Long post_id) {
		this.post_id = post_id;
	}
	public String getPost_title() {
		return post_title;
	}
	public void setPost_title(String post_title) {
		this.post_title = post_title;
	}
	public String getPost_description() {
		return post_description;
	}
	public void setPost_description(String post_description) {
		this.post_description = post_description;
	}
	public Date getCreated_on() {
		return created_on;
	}
	public void setCreated_on(Date created_on) {
		this.created_on = created_on;
	}
	public Date getLastUpdated_on() {
		return lastUpdated_on;
	}
	public void setLastUpdated_on(Date lastUpdated_on) {
		this.lastUpdated_on = lastUpdated_on;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	
	
	
}
