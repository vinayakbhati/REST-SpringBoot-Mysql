package com.rest.courses.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.courses.dao.CourseDao;
import com.rest.courses.entities.Course;
@Service
public class CourseServiceImpl implements CourseService {

//	List<Course> list;
	@Autowired
	private CourseDao courseDao;
	
	public CourseServiceImpl() {
//		list= new ArrayList<>();
//		list.add( new Course(12,"Core Java", "basic learning of Java"));
//		list.add( new Course(13,"Core Angular", "basic learning of Angular"));
	}
	
	@Override
	public List<Course> getCourses() {
		
		return courseDao.findAll();
	}

	@SuppressWarnings("deprecation")
	@Override
	public Course getCourse(Long courseId) {
//	return	list.stream().filter(element -> courseId.equals(element.getId())).findAny().orElse(null);	
	return courseDao.getOne(courseId);
	
	}

	@Override
	public Course addCourse(Course course) {
	//	list.add(course);
	//	return course;
		return courseDao.save(course);
	}

	@Override
	public Course updateCourse(Course course) {
//		list.stream().forEach(element -> {
//			if(element.getId() == course.getId()) {
//				element.setDescription(course.getDescription());
//				element.setTitle(course.getTitle());
//			}
//		});
		return courseDao.save(course);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void deleteCourse(long id) {
	//list= this.list.stream().filter(element -> element.getId() != id).collect(Collectors.toList());
	Course entity= courseDao.getOne(id);
	courseDao.delete(entity);
		
	}

}
