package com.stackOverflow.project.model;



import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Vote")


public class Vote {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long vote_id;
	
	/*
	@ManyToMany
	@JoinColumn(name = "post_id", referencedColumnName = "post_id")
	private List<post> post;
	*/
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "votetype_id", referencedColumnName = "votetype_id")
	private VoteTypes voteTypes;
	
	@OneToOne
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private User user;
	
	@Column(name = "created_date", nullable = false)
	@JsonFormat(shape=JsonFormat.Shape.STRING , pattern="dd/MM/yyyy")
	private Date Created_Date;

}
