package com.stackOverflow.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackOverflow.project.model.Skill;
import com.stackOverflow.project.repository.SkillRepository;

@Service
public class SkillService {
	@Autowired
	
	private SkillRepository skillRepository;
	
	
	 public Skill getSkillByUserId(long userid) {

		return skillRepository.findById(userid).get();
	}

    public Skill getSkillById(long skillId)
	{
		return skillRepository.findById(skillId).get();		
	}
    
    public Skill createSkill(Skill skill)
	{
		return skillRepository.save(skill);
	}
    
    public String deleteSkillById(long skillId)
	{
		skillRepository.deleteById(skillId);
		return "Skills with ID: "+Long.toString(skillId)+"has been deleted successfully";
	}

    public Skill updateSkillDetails(Skill skill,Long id) {
		
		Skill existingSkill=skillRepository.findById(skill.getSkill_id()).orElse(null);
		existingSkill.setSkill1(skill.getSkill1());
		existingSkill.setSkill2(skill.getSkill2());
		existingSkill.setSkill3(skill.getSkill3());
		existingSkill.setSkill4(skill.getSkill4());
		existingSkill.setSkill5(skill.getSkill5());
		
		return skillRepository.save(existingSkill);
	}

	
	

}
