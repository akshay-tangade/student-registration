package com.student.registration.entiy;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Users {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable=false,name="first_name")
	private String firstName;
	
	@Column(nullable=false,name="second_name")
	private String secondName;
	
	@Column(nullable=false,unique=true)
	private String emailId;
	
	@Column(nullable=false,unique=true,name="mobile_number")
	private String mobileNumber;
	
	@Column(nullable=false)
	private String password;
	
	@Column(nullable=false)
	private String username;
	
	private String gender;
	
	private String dateOfBirth;
	
	@ManyToOne
	private Course course;
	
	
	@ManyToMany(targetEntity = Role.class,cascade = CascadeType.ALL )
	private Set<Role> roles;

	public Users() {
		super();
	}

	public Users(Integer id, String firstName, String secondName, String emailId, String mobileNumber, String password,
			String username, String gender, String dateOfBirth, Course course, Set<Role> roles) {
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

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", secondName=" + secondName + ", emailId=" + emailId
				+ ", mobileNumber=" + mobileNumber + ", password=" + password + ", username=" + username + ", gender="
				+ gender + ", dateOfBirth=" + dateOfBirth + ", course=" + course + ", roles=" + roles + "]";
	}
	
}

