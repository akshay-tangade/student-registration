package com.student.registration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.student.registration.entity.Users;

public interface StudentRepository extends JpaRepository<Users, Integer> {
	
	@Query("SELECT u.id FROM Users u")
	public List<Integer> getAllStudentId();
	
	@Query(value="select u.* from users u join users_roles ur on u.id=ur.users_id join role r on r.id=ur.roles_id where r.id=4",nativeQuery = true)
	public List<Users> findAllStudent();
}
