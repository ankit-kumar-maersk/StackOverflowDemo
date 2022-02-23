package com.stackOverflow.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stackOverflow.project.model.Comments;

public interface CommentRepository extends JpaRepository<Comments, Long>{
	
		
}