package com.stackOverflow.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackOverflow.project.model.Log;
import com.stackOverflow.project.repository.LogRepository;

@Service
public class LogService 
{
	@Autowired
	private LogRepository logRepository;
	List<Log> comments = new ArrayList<>();
	
	public List<Log> getAllLogs(long user_id) 
	{
		return logRepository.findAllByUser(user_id);
    }

	public Log createLog(Log log) {
		return logRepository.save(log);
	}
	
	public String deleteLogById(long id)
	{
		logRepository.deleteById(id);
		return "Log with ID: "+Long.toString(id)+" removed successfully";
	}
}
