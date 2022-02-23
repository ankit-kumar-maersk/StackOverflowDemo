package com.stackOverflow.project.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.stackOverflow.project.model.Badges;


public interface BadgesRepository extends JpaRepository<Badges, Long>{

}
