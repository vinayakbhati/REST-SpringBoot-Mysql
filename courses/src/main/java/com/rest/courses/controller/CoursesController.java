package com.rest.courses.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.courses.entities.Course;
import com.rest.courses.service.CourseService;
@RestController
public class CoursesController {
	
	@Autowired
	private CourseService CourseService;
	
	@GetMapping("/home")
	public String home() {
		return "home page";
	}

	@GetMapping("/courses")
	public List<Course> getCourses(){
		return this.CourseService.getCourses();
	}
	
	@GetMapping("/course/{courseId}")
	public Course getCourse(@PathVariable String courseId ) {
		return this.CourseService.getCourse(Long.parseLong(courseId));
	}
	
	@PostMapping("/course")
	public Course addCourse(@RequestBody Course course) {
		return this.CourseService.addCourse(course);
	}
	
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course) {
		
		return this.CourseService.updateCourse(course);
	
	}
	
	@DeleteMapping("/course/{courseId}")
	public ResponseEntity<HttpStatus> deleteId(@PathVariable String courseId){
		try {
			this.CourseService.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}
}
