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
@Table(name = "Comments")
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
	
}
