package com.student.registration.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.UniqueElements;


public class CourseDto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull(message = "{course.number.nonempty}")
	private Integer courseNo;
	
	@NotBlank(message = "{course.name.nonempty}")
	private String courseName;
	
	@NotNull(message = "{course.duration.nonempty}")
	private Integer courseDuration;
	
	@NotNull(message = "{course.fee.nonempty}")
	private double courseFee;

	public CourseDto() {
		super();
	}

	public CourseDto(Integer id, Integer courseNo, String courseName, Integer courseDuration, double courseFee) {
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
