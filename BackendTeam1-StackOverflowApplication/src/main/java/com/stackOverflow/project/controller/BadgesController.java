package com.stackOverflow.project.controller;

import java.util.ArrayList;
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

import com.stackOverflow.project.model.Badges;
import com.stackOverflow.project.service.BadgeService;


@RestController
@RequestMapping(value = "/stackusersbadges")
public class BadgesController {
	
	@Autowired
	private BadgeService badgeService;
	
	@GetMapping("/getAllbadges")
    public List<Badges> getAllUser() {
        return badgeService.getBadgeList();
    }
	
	@GetMapping("/getbadge/{id}")
	public Badges getBadgeById(@PathVariable long id) {
		return badgeService.getBadgeById(id);
	}
	
	
	@GetMapping("/sort/{id}")
	 public List<String> sortedBadges(@PathVariable Long id){
		 List<String> SortedBadgesList = new ArrayList<>();
		 List<Badges> sorted_Badges = badgeService.getSortedBadges();
		 for(Badges badge : sorted_Badges) {
			 if(badge.getUser().getUser_id() == id)
			 SortedBadgesList.add(badge.getBadge_name());
		 }
		return 	SortedBadgesList;	 
	 }
	
	 @PostMapping("/addbadges")
	    public ResponseEntity<Badges> addUser(@RequestBody Badges badge) {
	        return new ResponseEntity<Badges>(badgeService.createBadge(badge), HttpStatus.CREATED);
	    }
	 
	 @DeleteMapping("/deleteBadge/{id}")
		public String DeleteUser(@PathVariable long id) {
			return badgeService.deleteBadgeById(id);
		}
	 
	 
	 
}
