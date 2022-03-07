package com.stackOverflow.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackOverflow.project.model.Comments;
import com.stackOverflow.project.repository.CommentRepository;

@Service
public class CommentService 
{
	@Autowired
	private CommentRepository commentRepository;
	List<Comments> comments = new ArrayList<>();
	
	public List<Comments> getAllComments(long user_id) 
	{
		return commentRepository.findAllByUser(user_id);
    }
	
	public Comments getCommentById(long id) {
		return commentRepository.findById(id).get();
	}

	public Comments createComment(Comments comment) {
		return commentRepository.save(comment);
	}

	public Comments updateCommentText(Comments commentText, long id) {
		
		Comments currentComment = commentRepository.findById(id).orElse(null);
		currentComment.setComment_desc(commentText.getComment_desc());
		return commentRepository.save(currentComment);
	}
	
	public String deleteCommentById(long id)
	{
		commentRepository.deleteById(id);
		return "Comment with ID: "+Long.toString(id)+" removed successfully";
	}
}
