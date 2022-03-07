package com.stackOverflow.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.stackOverflow.project.model.Comments;
import com.stackOverflow.project.service.CommentService;

@RestController
@RequestMapping(value = "/stackusercomments")
public class CommentController 
{		
		@Autowired
		private CommentService commentService;
		
		@GetMapping("/getAllComments/{user_id}")
	    public List<Comments> getAllComments(@PathVariable long user_id) {
	        return commentService.getAllComments(user_id);
	    }
		
		@GetMapping("/getComment/{id}")
		public Comments getCommentById(@PathVariable long id) {
			return commentService.getCommentById(id);
		}
		
		 @PostMapping("/addComment")
		    public ResponseEntity<Comments> addComment(@RequestBody Comments comment) {
		        return new ResponseEntity<Comments>(commentService.createComment(comment), HttpStatus.CREATED);
		    }
		 
		 @PutMapping("/updateComment/{id}")
			public Comments UpdateComment(@RequestBody Comments comment, @PathVariable long id) {
				return commentService.updateCommentText(comment,id);
			}
		 
		 @DeleteMapping("/deleteComment/{id}")
			public String DeleteComment(@PathVariable long id) {
				return commentService.deleteCommentById(id);
			}	 
	}
