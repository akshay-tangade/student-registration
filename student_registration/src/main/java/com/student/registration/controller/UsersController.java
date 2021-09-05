package com.student.registration.controller;

import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.registration.dto.UsersDto;
import com.student.registration.entity.Users;
import com.student.registration.repository.UsersRepository;
import com.student.registration.service.UsersService;
import com.student.registration.util.ResponseMessage;

@RestController
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
	private UsersService usersService;
	
	@Autowired
	private UsersRepository usersRepository;

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
			
				user1=usersService.creatUsers(users);

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
	
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Integer id)
	{
		ResponseMessage<Users> responseMessage = new ResponseMessage<Users>();
		responseMessage.setStatus(404);
		responseMessage.setStatusText("Course Not found");
		
		try {
			
			if(userIsPresent(id))
			{
				usersService.removeUsersById(id);
			
				responseMessage.setResult(null);
				responseMessage.setStatus(200);
				responseMessage.setStatusText("SUCCESS");
				return new ResponseEntity<ResponseMessage<Users>>(responseMessage, HttpStatus.OK);
			}
		}
		catch(Exception e)
		{
			responseMessage.setStatusText(e.getMessage());
			return new ResponseEntity<ResponseMessage<Users>>(responseMessage, HttpStatus.SERVICE_UNAVAILABLE);
		}
		
		return new ResponseEntity<ResponseMessage<Users>>(responseMessage, HttpStatus.NOT_FOUND);
	}
	
	
//	@PutMapping("/update")
//	public ResponseEntity<?> updateCourse(@RequestParam Integer id,@Valid @RequestBody UsersDto user)
//	{
//		ResponseMessage<Users> responseMessage = new ResponseMessage<Users>();
//		responseMessage.setStatus(404);
//		responseMessage.setStatusText("Course Not found, invalid ID");
//		Users student=null;
//		
//		try {
//			
//			if(userIsPresent(id))
//			{
//				student=usersService.updateUsersById(id, user);
//			
//				if(student!=null)
//				{
//					responseMessage.setResult(student);
//					responseMessage.setStatus(200);
//					responseMessage.setStatusText("SUCCESS");
//					return new ResponseEntity<ResponseMessage<Users>>(responseMessage, HttpStatus.OK);
//				}
//			}
//		}
//		catch(Exception e)
//		{
//			responseMessage.setStatusText(e.getMessage());
//			return new ResponseEntity<ResponseMessage<Users>>(responseMessage, HttpStatus.SERVICE_UNAVAILABLE);
//		}
//		
//		
//		return new ResponseEntity<ResponseMessage<Users>>(responseMessage, HttpStatus.SERVICE_UNAVAILABLE);
//	}
//	
//	@GetMapping("/view/{id}")
//	public ResponseEntity<?> getUsersById(@PathVariable Integer id)
//	{
//		ResponseMessage<Users> responseMessage = new ResponseMessage<Users>();
//		responseMessage.setStatus(404);
//		responseMessage.setStatusText("Course Not found");
//		
//		Users user=null;
//		
//		try {
//			
//			if(userIsPresent(id)) {
//				user=usersService.getUsersById(id);
//				
//				if(user!=null)
//				{
//					responseMessage.setResult(user);
//					responseMessage.setStatus(200);
//					responseMessage.setStatusText("SUCCESS");
//					responseMessage.setTotalElements(1);
//					return new ResponseEntity<ResponseMessage<Users>>(responseMessage, HttpStatus.OK);
//				}
//			}
//		}
//		catch(Exception e)
//		{
//			responseMessage.setStatusText(e.getMessage());
//			return new ResponseEntity<ResponseMessage<Users>>(responseMessage, HttpStatus.SERVICE_UNAVAILABLE);
//		}
//		
//		return new ResponseEntity<ResponseMessage<Users>>(responseMessage, HttpStatus.NOT_FOUND);
//	}
//	
//	
//	@GetMapping("/view")
//	public ResponseEntity<?> getAllUsers()
//	{
//		ResponseMessage<List<Users>> responseMessage = new ResponseMessage<List<Users>>();
//		responseMessage.setStatus(404);
//		responseMessage.setStatusText("Course Not found");
//		
//		List<Users> user=null;
//		
//		try {
//			
//			
//				user=usersService.getAllUsers();
//				
//				if(user!=null)
//				{
//					responseMessage.setResult(user);
//					responseMessage.setStatus(200);
//					responseMessage.setStatusText("SUCCESS");
//					responseMessage.setTotalElements(1);
//					return new ResponseEntity<ResponseMessage<List<Users>>>(responseMessage, HttpStatus.OK);
//				}
//			
//		}
//		catch(Exception e)
//		{
//			responseMessage.setStatusText(e.getMessage());
//			return new ResponseEntity<ResponseMessage<List<Users>>>(responseMessage, HttpStatus.SERVICE_UNAVAILABLE);
//		}
//		
//		return new ResponseEntity<ResponseMessage<List<Users>>>(responseMessage, HttpStatus.NOT_FOUND);
//	}	
//	
//	
//	@GetMapping("/view/admin")
//	public ResponseEntity<?> getAllAdmins()
//	{
//		ResponseMessage<List<Users>> responseMessage = new ResponseMessage<List<Users>>();
//		responseMessage.setStatus(404);
//		responseMessage.setStatusText("Course Not found");
//		
//		List<Users> user=null;
//		
//		try {
//			
//			
//				user=usersService.getAllAdmins();
//				
//				if(user!=null)
//				{
//					responseMessage.setResult(user);
//					responseMessage.setStatus(200);
//					responseMessage.setStatusText("SUCCESS");
//					responseMessage.setTotalElements(1);
//					return new ResponseEntity<ResponseMessage<List<Users>>>(responseMessage, HttpStatus.OK);
//				}
//			
//		}
//		catch(Exception e)
//		{
//			responseMessage.setStatusText(e.getMessage());
//			return new ResponseEntity<ResponseMessage<List<Users>>>(responseMessage, HttpStatus.SERVICE_UNAVAILABLE);
//		}
//		
//		return new ResponseEntity<ResponseMessage<List<Users>>>(responseMessage, HttpStatus.NOT_FOUND);
//	}
//	
//	@GetMapping("/view/principal")
//	public ResponseEntity<?> getAllPrincipal()
//	{
//		ResponseMessage<List<Users>> responseMessage = new ResponseMessage<List<Users>>();
//		responseMessage.setStatus(404);
//		responseMessage.setStatusText("Course Not found");
//		
//		List<Users> user=null;
//		
//		try {
//			
//			
//				user=usersService.getAllPrincipal();
//				
//				if(user!=null)
//				{
//					responseMessage.setResult(user);
//					responseMessage.setStatus(200);
//					responseMessage.setStatusText("SUCCESS");
//					responseMessage.setTotalElements(1);
//					return new ResponseEntity<ResponseMessage<List<Users>>>(responseMessage, HttpStatus.OK);
//				}
//			
//		}
//		catch(Exception e)
//		{
//			responseMessage.setStatusText(e.getMessage());
//			return new ResponseEntity<ResponseMessage<List<Users>>>(responseMessage, HttpStatus.SERVICE_UNAVAILABLE);
//		}
//		
//		return new ResponseEntity<ResponseMessage<List<Users>>>(responseMessage, HttpStatus.NOT_FOUND);
//	}
//	
//	@GetMapping("/view/faculty")
//	public ResponseEntity<?> getAllFaculty()
//	{
//		ResponseMessage<List<Users>> responseMessage = new ResponseMessage<List<Users>>();
//		responseMessage.setStatus(404);
//		responseMessage.setStatusText("Course Not found");
//		
//		List<Users> user=null;
//		
//		try {
//			
//			
//				user=usersService.getAllFaculty();
//				
//				if(user!=null)
//				{
//					responseMessage.setResult(user);
//					responseMessage.setStatus(200);
//					responseMessage.setStatusText("SUCCESS");
//					responseMessage.setTotalElements(1);
//					return new ResponseEntity<ResponseMessage<List<Users>>>(responseMessage, HttpStatus.OK);
//				}
//			
//		}
//		catch(Exception e)
//		{
//			responseMessage.setStatusText(e.getMessage());
//			return new ResponseEntity<ResponseMessage<List<Users>>>(responseMessage, HttpStatus.SERVICE_UNAVAILABLE);
//		}
//		
//		return new ResponseEntity<ResponseMessage<List<Users>>>(responseMessage, HttpStatus.NOT_FOUND);
//	}
	
	public boolean userIsPresent(Integer id)
	{
		List<Integer> sList=usersRepository.getAllUsersId();
		System.out.println(sList);
		if(!sList.contains(id))
		{
			return false;
		}	
		return true;
	}
}
