package com.springrest.springrest.services;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Service;

import com.springrest.springrest.entities.Course;

@Service

public class CourseServiceImpl implements CourseService {

    private List<Course> list;

    public CourseServiceImpl() {
        list = new CopyOnWriteArrayList<>();
        list.add(new Course(11, "Java Core Course", "This course is related to Java By Sanjeev Kumar."));
        list.add(new Course(12, "Spring Boot Course", "Creating Rest API using Spring Boot."));
        list.add(new Course(13, "Java Script Course", "This is Java Script course."));
        list.add(new Course(14, "React JS Course", "This is React JS course."));
        list.add(new Course(15, "Node JS Course", "This is Node JS course."));
        list.add(new Course(16, "Express JS Course", "This is Express JS course."));
        list.add(new Course(17, "Python Course", "This is PythonJS course."));
        list.add(new Course(18, "JAVA Course", "This is JAVA course."));
        list.add(new Course(19, "C++ Course", "This is C++ course."));
        list.add(new Course(20, "Angular JS Course", "This is Angular JS course."));
    }

    @Override
    public List<Course> getCourses() {
        return list;
    }

    @Override
    public Course getCourse(long courseID) {
    	Course c = null;
    	for(Course course : list) {
    		if (course.getId()==courseID) {
    			c = course;
    			break;
    		}
    	}
        return c;
    }

	@Override
	public Course addCourse(Course course) {
		list.add(course);
		return course;
	}

	@Override
    public Course deleteCourse(long courseID) {
        Course courseToDelete = getCourse(courseID);
        if (courseToDelete != null) {
            list.remove(courseToDelete);
            return courseToDelete;
        }
        return null;
    }

}

