package com.stackOverflow.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stackOverflow.project.model.Comments;

public interface CommentRepository extends JpaRepository<Comments, Long>{

	List<Comments> findAllByUser(long user_id);
	
		
}