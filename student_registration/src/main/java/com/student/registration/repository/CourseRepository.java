package com.student.registration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.student.registration.entity.Course;


public interface CourseRepository extends JpaRepository<Course, Integer>{

	@Query("SELECT cr.courseNo from Course cr")
	public List<Integer> getAllCourseNo();
	
	
	@Query("SELECT cr.id from Course cr")
	public List<Integer> getAllCourseId();
	
}
