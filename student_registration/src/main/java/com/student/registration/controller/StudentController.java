package com.student.registration.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.registration.dto.UsersDto;
import com.student.registration.entity.Users;
import com.student.registration.service.UsersService;
import com.student.registration.util.ResponseMessage;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private UsersService usersService;
	
	public UsersService getUsersService() {
		return usersService;
	}

	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}

	@PostMapping("/register")
	public ResponseEntity<?> createCourse(@Valid @RequestBody UsersDto users)
	{
		ResponseMessage<Users> responseMessage = new ResponseMessage<Users>();
		responseMessage.setStatus(404);
		responseMessage.setStatusText("Unable to add course");
		Users user1=null;
		
		try {
			
				user1=usersService.creatStudent(users);

			if(user1!=null)
			{
				responseMessage.setResult(user1);
				responseMessage.setStatus(200);
				responseMessage.setStatusText("SUCCESS");
				return new ResponseEntity<ResponseMessage<Users>>(responseMessage, HttpStatus.CREATED);
			}
		}
		catch(Exception e)
		{
			responseMessage.setStatusText(e.getMessage());
			return new ResponseEntity<ResponseMessage<Users>>(responseMessage, HttpStatus.SERVICE_UNAVAILABLE);
		}
		
		
		return new ResponseEntity<ResponseMessage<Users>>(responseMessage, HttpStatus.SERVICE_UNAVAILABLE);
	}

}
