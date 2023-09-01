package com.rest.courses.service;
import java.util.List;

import com.rest.courses.entities.Course;

public interface CourseService {
	
	public List<Course> getCourses();
	public Course getCourse(Long courseId);
	public Course addCourse(Course course);
	public Course updateCourse(Course course);
	public void deleteCourse(long id);

}
