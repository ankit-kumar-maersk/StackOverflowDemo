package com.stackOverflow.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackOverflow.project.model.User;
import com.stackOverflow.project.repository.UserRepository;


@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	 public List<User> getuserList() {
	        return userRepository.findAll();
	    }

	public User createUser(User user) {
		return userRepository.save(user);
	}
	
	public User getUserById(long id) {
		return userRepository.findById(id).get();
	}
	
	public String deleteStudentById(long id)
	{
		userRepository.deleteById(id);
		return "user with ID: "+Long.toString(id)+" removed successfully";
	}

	public User updateUserDetails(User user, long id) {
		User currentUser = userRepository.findById(id).orElse(null);
		
		currentUser.setUserName(user.getUserName());
		currentUser.setLocation(user.getLocation());
		currentUser.setEmail(user.getEmail());
		currentUser.setPhone_Number(user.getPhone_Number());
		currentUser.setAbout_Me(user.getAbout_Me());
		currentUser.setUp_Votes(user.getUp_Votes());
		currentUser.setDown_Votes(user.getDown_Votes());
		currentUser.setRep_Score(user.getRep_Score());
		currentUser.setLast_Acess_Date(user.getLast_Acess_Date());
		
		return userRepository.save(currentUser);
	}

}
