package com.stackOverflow.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stackOverflow.project.model.Answer;
import com.stackOverflow.project.repository.AnswerRepository;



@Service
public class AnswerService {
	
	@Autowired
	private AnswerRepository answerRepository;
	
	//if not needed, then we will remove it
	public List<Answer> getAllAnswers() {
		return answerRepository.findAll();
	}
	
	
	public List<Answer> getAnswersByPostId(long postId)
	{
		ArrayList<Answer> answers= new ArrayList<Answer>();
		answerRepository.findByPostId(postId).forEach(answers::add);		
		return answers;
	}
	
	public List<Answer> getAnswersByUserId(long userId)
	{
		ArrayList<Answer> answers= new ArrayList<Answer>();
		answerRepository.findByUserId(userId).forEach(answers::add);		
		return answers;
	}
	
	//after tag table implementation
	/*public List<Answer> getAnswersByTagId(long tagId)
	{
		ArrayList<Answer> answers= new ArrayList<Answer>();
		answerRepository.findByTagId(tagId).forEach(answers::add);		
		return answers;
	}*/
	
	public Answer getAnswersById(long ansId)
	{
		return answerRepository.findById(ansId).get();		
	}
	
	
	public Answer postAnswer(Answer answer)
	{
		return answerRepository.save(answer);
	}
	
	
	public String deleteAnswerById(long ansId)
	{
		answerRepository.deleteById(ansId);
		return "Answer with ID: "+Long.toString(ansId)+"has been removed successfully";
	}

	
	

}
