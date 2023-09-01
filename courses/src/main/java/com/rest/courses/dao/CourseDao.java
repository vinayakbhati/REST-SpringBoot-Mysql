package com.rest.courses.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.courses.entities.Course;

public interface CourseDao extends JpaRepository<Course, Long> {

}
