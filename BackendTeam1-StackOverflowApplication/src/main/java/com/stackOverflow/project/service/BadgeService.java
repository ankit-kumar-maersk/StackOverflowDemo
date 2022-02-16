package com.stackOverflow.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.stackOverflow.project.model.Badges;
import com.stackOverflow.project.repository.BadgesRepository;


@Service
public class BadgeService {
	
	@Autowired
	private BadgesRepository badgesRepository;
	
	 public List<Badges> getBadgeList() {
	        return badgesRepository.findAll();
	    }
	
	public List<Badges> getSortedBadges(){
		return badgesRepository.findAll(Sort.by(Sort.Direction.ASC,"badgename"));
		
	}
	
	public Badges createBadge(Badges badge) {
		return badgesRepository.save(badge);
	}
	
	public Badges getBadgeById(long id) {
		return badgesRepository.findById(id).get();
	}
	
	public String deleteBadgeById(long id)
	{
		badgesRepository.deleteById(id);
		return "Badge with ID: "+Long.toString(id)+" removed successfully";
	}
	

}
