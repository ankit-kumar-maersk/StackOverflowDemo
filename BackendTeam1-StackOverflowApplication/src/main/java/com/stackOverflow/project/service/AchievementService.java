package com.stackOverflow.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackOverflow.project.repository.AchievementRepository;

@Service
public class AchievementService 
{
	@Autowired
	private AchievementRepository achievementRepository;
	
	public Long getRepScore(long user_id) 
	{
		return achievementRepository.findAllByUser(user_id).getRep_score();
    }

}
