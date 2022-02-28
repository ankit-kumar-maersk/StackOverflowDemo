package com.stackOverflow.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stackOverflow.project.model.Skill;

public interface SkillRepository extends JpaRepository<Skill, Long> {

}
