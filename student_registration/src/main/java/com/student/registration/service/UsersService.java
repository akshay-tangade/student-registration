package com.student.registration.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.student.registration.dto.RoleDto;
import com.student.registration.dto.UsersDto;
import com.student.registration.entity.Course;
import com.student.registration.entity.Role;
import com.student.registration.entity.Users;
import com.student.registration.repository.UsersRepository;

@Service
public class UsersService {

	@Autowired
	private UsersRepository usersRepository;

	public UsersRepository getUsersRepository() {
		return usersRepository;
	}

	public void setUsersRepository(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}
	
	public Users creatUsers(UsersDto user)
	{
		Users usr;
		usr=getUserDetails(user);
		
		return usersRepository.save(usr);
	}
	
	
	public Users getUserDetails(UsersDto user)
	{
		Users user1=new Users();
		
		user1.setFirstName(user.getFirstName());
		user1.setSecondName(user.getSecondName());
		user1.setGender(user.getGender());
		user1.setEmailId(user.getEmailId());
		user1.setDateOfBirth(user.getDateOfBirth());
		user1.setPassword(user.getPassword());
		user1.setMobileNumber(user.getMobileNumber());
		user1.setUsername(user.getUsername());
		
		Course course=new Course();
		
		course.setId(user.getCourse().getId());
		course.setCourseName(user.getCourse().getCourseName());
		course.setCourseNo(user.getCourse().getCourseNo());
		course.setCourseDuration(user.getCourse().getCourseDuration());
		course.setCourseFee(user.getCourse().getCourseFee());
		
		user1.setCourse(course);
		
		List<Role> role=new ArrayList<>();
		
		for(RoleDto ro: user.getRoles())
		{
			Role role1=new Role();
			
			role1.setId(ro.getId());
			role1.setRoleName(ro.getRoleName());

			role.add(role1);
		}
		
		user1.setRoles(role);

		return user1;
	}
	
	public Users updateUsersById(Integer id,UsersDto user)
	{
		Users usr;
		usr=getUserDetails(user);
		usr.setId(id);
		return usersRepository.save(usr);
	}
	
	public void removeUsersById(Integer id)
	{
		usersRepository.deleteById(id);
	}
	
	public List<Users> getAllUsers()
	{
		return usersRepository.findAll();
	}
	
	public List<Users> getAllAdmins()
	{
		return usersRepository.findAllAdmins();
	}
	
	public List<Users> getAllPrincipal()
	{
		return usersRepository.findAllPrincipals();
	}
	
	public List<Users> getAllFaculty()
	{
		return usersRepository.findAllFaculty();
	}
	
	public Users getUsersById(Integer id)
	{
		return usersRepository.findById(id).get();
	}
}
