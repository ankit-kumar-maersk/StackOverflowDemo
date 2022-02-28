package com.stackOverflow.project.controller;

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

import com.stackOverflow.project.model.Skill;
import com.stackOverflow.project.service.SkillService;

@RestController
@RequestMapping("value = /stackusersskill")
public class SkillController {
	
	@Autowired
	private SkillService skillService;
	
	
	 @GetMapping("/getSkill/{id}")
	public Skill getSkillById(@PathVariable long id) {
		return skillService.getSkillById(id);
	}

    @PostMapping("/addSkill")
    public ResponseEntity<Skill> addSkill(@RequestBody Skill skill) {
        return new ResponseEntity<Skill>(skillService.createSkill(skill), HttpStatus.CREATED);
    }
    
    @DeleteMapping("/deleteSkill/{id}")
		public String DeleteSkill(@PathVariable long id) {
			return skillService.deleteSkillById(id);
		}

        @PutMapping(value = "/updateSkill/{id}")
        public String updateSkill(@PathVariable long id, @RequestBody Skill skill)
        {
            skillService.updateSkillDetails(skill,id);
            return "Updated!";
        }
		
	}

