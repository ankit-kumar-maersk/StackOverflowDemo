package com.stackOverflow.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stackOverflow.project.model.Log;

public interface LogRepository extends JpaRepository<Log, Long>
{
	List<Log> findAllByUser(long user_id);
}
