package com.student.registration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.registration.dto.CourseDto;
import com.student.registration.entity.Course;
import com.student.registration.repository.CourseRepository;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	public Course createCourse(CourseDto course) throws Exception
	{
		Course cour;
		cour=getCourseDetails(course);
		return courseRepository.save(cour);
	}
	
	public Course getCourseDetails(CourseDto course)
	{
		Course cour1=new Course();
		cour1.setCourseNo(course.getCourseNo());
		cour1.setCourseName(course.getCourseName());
		cour1.setCourseDuration(course.getCourseDuration());
		cour1.setCourseFee(course.getCourseFee());
		return cour1;
	}
	
	
	public List<Course> getAllCourses()
	{
		return courseRepository.findAll();
	}
	
	public Course getCourseById(Integer id)
	{
		return courseRepository.findById(id).get();
	}
	
	public void removeCourseById(Integer id)
	{
		courseRepository.deleteById(id);
	}
	
	
}
