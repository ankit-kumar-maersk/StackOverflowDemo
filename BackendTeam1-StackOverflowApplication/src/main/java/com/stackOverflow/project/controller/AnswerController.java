package com.stackOverflow.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackOverflow.project.model.Answer;
import com.stackOverflow.project.service.AnswerService;

@RestController
@RequestMapping(value = "/stackusersanswers")
public class AnswerController {
	
	@Autowired
	private AnswerService answerService;
	
	//if not needed, then we will remove it
	@GetMapping("/getAllanswers")
    public List<Answer> getAllAnswers() {
        return answerService.getAllAnswers();
    }
	
	@GetMapping("/posts/{post_id} /answers")
	public List<Answer> getAnswersByPostId(@PathVariable Long post_id)
	{
		return answerService.getAnswersByPostId(post_id);
	}
	
	@GetMapping("/users/{user_id}/answers")
	public List<Answer> getAnswersByUserId(@PathVariable Long user_id)
	{
		return answerService.getAnswersByUserId(user_id);
	}
	
	//@GetMapping("/tags/tag_id /answers")    ....after tag table implementation
	/*public List<Answer> getAnswersByTagId(@PathVariable Long tag_id)
	{
		return answerService.getAnswersByTagId(tag_id);
	}*/
	
	@GetMapping("/answers/{ans_id} ")
	public Answer getAnswerById(@PathVariable Long ans_id)
	{
		return answerService.getAnswersById(ans_id);
	}
	
	@PostMapping("/answers/add ")
	public ResponseEntity<Answer> postAnswer(@RequestBody Answer answer)
	{
	       return new ResponseEntity<Answer>(answerService.postAnswer(answer), HttpStatus.CREATED);
	}
	
	 @DeleteMapping("/answers/{ans_id}/delete")
		public String deleteAnswerById(@PathVariable long ans_id) {
			return answerService.deleteAnswerById(ans_id);
		}

}
