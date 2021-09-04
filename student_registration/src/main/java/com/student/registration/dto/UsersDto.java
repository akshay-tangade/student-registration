package com.student.registration.dto;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.student.registration.entity.Course;
import com.student.registration.entity.Role;

public class UsersDto {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "{first.name.nonempty}")
	private String firstName;
	
	@NotBlank(message = "{second.name.nonempty}")
	private String secondName;
	
	@Email(message = "{email.valid}")
	@NotBlank(message = "{email.nonempty}")
	private String emailId;
	
	@NotBlank(message = "{mobile.number.nonempty}")
	private String mobileNumber;
	
	private String password;
	
	@NotBlank(message = "{username.nonempty}")
	private String username;
	
	@NotBlank(message = "{gender.nonempty}")
	private String gender;
	
	private String dateOfBirth;
	
	@ManyToOne
	private CourseDto course;
	
	
	@ManyToMany(targetEntity = Role.class,cascade = CascadeType.ALL )
	private Set<RoleDto> roles;

	public UsersDto() {
		super();
	}

	public UsersDto(Integer id, String firstName, String secondName, String emailId, String mobileNumber, String password,
			String username, String gender, String dateOfBirth, CourseDto course, Set<RoleDto> roles) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.secondName = secondName;
		this.emailId = emailId;
		this.mobileNumber = mobileNumber;
		this.password = password;
		this.username = username;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.course = course;
		this.roles = roles;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public CourseDto getCourse() {
		return course;
	}

	public void setCourse(CourseDto course) {
		this.course = course;
	}

	public Set<RoleDto> getRoles() {
		return roles;
	}

	public void setRoles(Set<RoleDto> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", secondName=" + secondName + ", emailId=" + emailId
				+ ", mobileNumber=" + mobileNumber + ", password=" + password + ", username=" + username + ", gender="
				+ gender + ", dateOfBirth=" + dateOfBirth + ", course=" + course + ", roles=" + roles + "]";
	}
}
