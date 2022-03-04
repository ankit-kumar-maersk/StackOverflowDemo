package com.stackOverflow.project.controller;

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

import com.stackOverflow.project.model.Log;
import com.stackOverflow.project.service.LogService;

@RestController
@RequestMapping(value = "/stackuserlogs")
public class LogController
{
	@Autowired
	LogService logService;
	
	@GetMapping("/getAllLogs/{user_id}")
    public List<Log> getAllComments(@PathVariable long user_id) {
        return logService.getAllLogs(user_id);
    }
	
	 @PostMapping("/addLog")
	    public ResponseEntity<Log> addLog(@RequestBody Log log) {
	        return new ResponseEntity<Log>(logService.createLog(log), HttpStatus.CREATED);
	    }
	 @DeleteMapping("/deletLog/{id}")
		public String DeleteLog(@PathVariable long id) {
			return logService.deleteLogById(id);
		}	 
}
