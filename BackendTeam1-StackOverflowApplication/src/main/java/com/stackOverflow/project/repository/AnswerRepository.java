package com.stackOverflow.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.stackOverflow.project.model.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Long>{
	public List<Answer> findByPostId(Long postId);
	public List<Answer> findByUserId(Long userId);
	//public List<Answer> findByTagId(Long tagId);
	
	
}
