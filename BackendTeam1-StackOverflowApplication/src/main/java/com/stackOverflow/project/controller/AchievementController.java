package com.stackOverflow.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackOverflow.project.service.AchievementService;

@RestController
@RequestMapping(value = "/stackuserachievements")
public class AchievementController
{
	@Autowired
	AchievementService achievementService;
	
	
	@GetMapping("/getRepScore/{user_id}")
    public String getRepoScore(@PathVariable long user_id) {
        return achievementService.getRepScore(user_id).toString();
    }
	
}
