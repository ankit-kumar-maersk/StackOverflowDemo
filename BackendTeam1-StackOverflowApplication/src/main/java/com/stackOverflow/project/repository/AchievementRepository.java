package com.stackOverflow.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stackOverflow.project.model.Achievements;

public interface AchievementRepository extends JpaRepository <Achievements, Long> {
	public Achievements findAllByUser(long user_id);

}
