package com.student.registration.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.student.registration.dto.CourseDto;
import com.student.registration.entity.Course;
import com.student.registration.repository.CourseRepository;
import com.student.registration.service.CourseService;
import com.student.registration.util.ResponseMessage;

@RestController
@RequestMapping("/course")
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@Autowired
	private CourseRepository courseRepository;

	public CourseService getCourseService() {
		return courseService;
	}

	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> createCourse(@Valid @RequestBody CourseDto course)
	{
		ResponseMessage<Course> responseMessage = new ResponseMessage<Course>();
		responseMessage.setStatus(404);
		responseMessage.setStatusText("Unable to add course");
		Course course1=null;
		
		try {
			
			if(ifNotDupliacte(course,responseMessage))
				course1=courseService.createCourse(course);

			if(course1!=null)
			{
				responseMessage.setResult(course1);
				responseMessage.setStatus(200);
				responseMessage.setStatusText("SUCCESS");
				return new ResponseEntity<ResponseMessage<Course>>(responseMessage, HttpStatus.CREATED);
			}
		}
		catch(Exception e)
		{
			responseMessage.setStatusText(e.getMessage());
			return new ResponseEntity<ResponseMessage<Course>>(responseMessage, HttpStatus.SERVICE_UNAVAILABLE);
		}
		
		
		return new ResponseEntity<ResponseMessage<Course>>(responseMessage, HttpStatus.SERVICE_UNAVAILABLE);
	}
	
	@GetMapping("/view/{id}")
	public ResponseEntity<?> getCourseById(@PathVariable Integer id)
	{
		ResponseMessage<Course> responseMessage = new ResponseMessage<Course>();
		responseMessage.setStatus(404);
		responseMessage.setStatusText("Course Not found");
		
		Course course=null;
		
		try {
			
			course=courseService.getCourseById(id);
			
			if(course!=null)
			{
				responseMessage.setResult(course);
				responseMessage.setStatus(200);
				responseMessage.setStatusText("SUCCESS");
				responseMessage.setTotalElements(1);
				return new ResponseEntity<ResponseMessage<Course>>(responseMessage, HttpStatus.OK);
			}
		}
		catch(Exception e)
		{
			responseMessage.setStatusText(e.getMessage());
			return new ResponseEntity<ResponseMessage<Course>>(responseMessage, HttpStatus.SERVICE_UNAVAILABLE);
		}
		
		return new ResponseEntity<ResponseMessage<Course>>(responseMessage, HttpStatus.NOT_FOUND);
	}
	
	
	@GetMapping("/view")
	public ResponseEntity<?> getAllCourses()
	{
		ResponseMessage<List<Course>> responseMessage = new ResponseMessage<List<Course>>();
		responseMessage.setStatus(404);
		responseMessage.setStatusText("Course Not found");
		
		List<Course> course=new ArrayList<>();
		
		try {
			
			course=courseService.getAllCourses();
			
			if(course.size()>0)
			{
				responseMessage.setResult(course);
				responseMessage.setStatus(200);
				responseMessage.setStatusText("SUCCESS");
				responseMessage.setTotalElements(course.size());
				return new ResponseEntity<ResponseMessage<List<Course>>>(responseMessage, HttpStatus.OK);
			}
		}
		catch(Exception e)
		{
			responseMessage.setStatusText(e.getMessage());
			return new ResponseEntity<ResponseMessage<List<Course>>>(responseMessage, HttpStatus.SERVICE_UNAVAILABLE);
		}
		
		return new ResponseEntity<ResponseMessage<List<Course>>>(responseMessage, HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Integer id)
	{
		ResponseMessage<Course> responseMessage = new ResponseMessage<Course>();
		responseMessage.setStatus(404);
		responseMessage.setStatusText("Course Not found");
		
		try {
			
			if(courseIsPresent(id))
			{
				courseService.removeCourseById(id);
			
				responseMessage.setResult(null);
				responseMessage.setStatus(200);
				responseMessage.setStatusText("SUCCESS");
				return new ResponseEntity<ResponseMessage<Course>>(responseMessage, HttpStatus.OK);
			}
		}
		catch(Exception e)
		{
			responseMessage.setStatusText(e.getMessage());
			return new ResponseEntity<ResponseMessage<Course>>(responseMessage, HttpStatus.SERVICE_UNAVAILABLE);
		}
		
		return new ResponseEntity<ResponseMessage<Course>>(responseMessage, HttpStatus.NOT_FOUND);
	} 
	
	
	@PutMapping("/update")
	public ResponseEntity<?> updateCourse(@RequestParam Integer id,@Valid @RequestBody CourseDto course)
	{
		ResponseMessage<Course> responseMessage = new ResponseMessage<Course>();
		responseMessage.setStatus(404);
		responseMessage.setStatusText("Course Not found, invalid ID");
		Course course1=null;
		
		try {
			
			if(courseIsPresent(id))
			{
				course1=courseService.updateCourseById(id, course);
			
				if(course1!=null)
				{
					responseMessage.setResult(course1);
					responseMessage.setStatus(200);
					responseMessage.setStatusText("SUCCESS");
					return new ResponseEntity<ResponseMessage<Course>>(responseMessage, HttpStatus.OK);
				}
			}
		}
		catch(Exception e)
		{
			responseMessage.setStatusText(e.getMessage());
			return new ResponseEntity<ResponseMessage<Course>>(responseMessage, HttpStatus.SERVICE_UNAVAILABLE);
		}
		
		
		return new ResponseEntity<ResponseMessage<Course>>(responseMessage, HttpStatus.SERVICE_UNAVAILABLE);
	}
	
	
	
	
	public boolean ifNotDupliacte(CourseDto course,ResponseMessage<Course> responseMessage)
	{
		List<Integer> olist=courseRepository.getAllCourseNo();
		
		Integer orderNo=course.getCourseNo();
		
		if(olist.contains(orderNo))
		{
			responseMessage.setStatus(503);
			responseMessage.setStatusText("Course Number already exist");
			return false;
		}
		
		return true;
	}
	
	
	public boolean courseIsPresent(Integer id)
	{
		List<Integer> clist=courseRepository.getAllCourseId();
		
		if(!clist.contains(id))
		{
			return false;
		}
		
		return true;
	}
}
