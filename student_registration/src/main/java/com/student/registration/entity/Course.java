package com.student.registration.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Course {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable=false,name="course_no",unique=true)
	private Integer courseNo;
	
	@Column(nullable=false,name="course_name")
	private String courseName;
	
	@Column(nullable=false,name="course_duration")
	private Integer courseDuration;
	
	@Column(nullable=false,name="course_fee")
	private double courseFee;

	public Course() {
		super();
	}

	public Course(Integer id, Integer courseNo, String courseName, Integer courseDuration, double courseFee) {
		super();
		this.id = id;
		this.courseNo = courseNo;
		this.courseName = courseName;
		this.courseDuration = courseDuration;
		this.courseFee = courseFee;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCourseNo() {
		return courseNo;
	}

	public void setCourseNo(Integer courseNo) {
		this.courseNo = courseNo;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Integer getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(Integer courseDuration) {
		this.courseDuration = courseDuration;
	}

	public double getCourseFee() {
		return courseFee;
	}

	public void setCourseFee(double courseFee) {
		this.courseFee = courseFee;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", courseNo=" + courseNo + ", courseName=" + courseName + ", courseDuration="
				+ courseDuration + ", courseFee=" + courseFee + "]";
	}

}
