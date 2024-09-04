package com.springrest.springrest.services;

import java.util.List;

import com.springrest.springrest.entities.Course;

public interface CourseService {

		public List<Course> getCourses();
		
		public Course getCourse(long courseID);
		
		public Course addCourse(Course course);
		
		public Course deleteCourse(long courseID);

		
}
