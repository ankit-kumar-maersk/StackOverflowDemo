package com.stackOverflow.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackOverflow.project.model.Comment;
import com.stackOverflow.project.repository.CommentRepository;

@Service
public class CommentService 
{
	@Autowired
	private CommentRepository commentRepository;
	List<Comment> comments = new ArrayList<>();
	
	public List<Comment> getAllComments(long user_id) 
	{
		return commentRepository.findAllByUser(user_id);
    }
	
	public Comment getCommentById(long id) {
		return commentRepository.findById(id).get();
	}

	public Comment createComment(Comment comment) {
		return commentRepository.save(comment);
	}

	public Comment updateCommentText(Comment commentText, long id) {
		
		Comment currentComment = commentRepository.findById(id).orElse(null);
		currentComment.setComment_desc(commentText.getComment_desc());
		return commentRepository.save(currentComment);
	}
	
	public String deleteCommentById(long id)
	{
		commentRepository.deleteById(id);
		return "Comment with ID: "+Long.toString(id)+" removed successfully";
	}
}
