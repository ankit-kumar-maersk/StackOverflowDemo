package com.stackOverflow.project.controller;

import java.util.List;

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

import com.stackOverflow.project.model.User;
import com.stackOverflow.project.service.UserService;

@RestController
@RequestMapping(value = "/stackusers")  //http://localhost:8080/stackusers/methods
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/getAllusers")
    public List<User> getAllUser() {
        return userService.getuserList();
    }
	
	@GetMapping("/getuser/{id}")
	public User getUserById(@PathVariable long id) {
		return userService.getUserById(id);
	}

  
    @PostMapping("/addusers")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return new ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);
    }
    
    
	
	@PutMapping("/updateUser/{id}")
	public User UpdateUser(@RequestBody User user, @PathVariable long id) {
		return userService.updateUserDetails(user,id);
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public String DeleteUser(@PathVariable long id) {
		return userService.deleteUserById(id);
	}	

}
