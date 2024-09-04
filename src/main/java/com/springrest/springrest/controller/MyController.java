package com.springrest.springrest.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.CourseService;

@RestController
public class MyController {

    private final CourseService courseService;

    // Constructor-based Dependency Injection
    public MyController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/home")
    public String home() {
        return "Welcome to my page";
    }

    // Get all courses
    @GetMapping("/courses")
    public List<Course> getCourses() {
        return this.courseService.getCourses();
    }

    // Get a single course by ID
    @GetMapping("/courses/{courseID}")
    public Course getCourse(@PathVariable String courseID) {
        return this.courseService.getCourse(Long.parseLong(courseID));
    }
    
    //Add course
    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course) {
    	return this.courseService.addCourse(course);
    }
    
    //Delete any course
    @DeleteMapping("/courses/{courseID}")
    public void deleteCourse(@PathVariable String courseID) {
        this.courseService.deleteCourse(Long.parseLong(courseID));
    }
}
