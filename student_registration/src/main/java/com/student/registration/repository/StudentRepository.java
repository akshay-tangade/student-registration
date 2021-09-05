package com.student.registration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.student.registration.entity.Users;

public interface StudentRepository extends JpaRepository<Users, Integer> {
	
	@Query("SELECT u.id FROM Users u")
	public List<Integer> getAllStudentId();
}
