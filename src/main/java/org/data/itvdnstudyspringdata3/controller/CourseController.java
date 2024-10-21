package org.data.itvdnstudyspringdata3.controller;

import org.data.itvdnstudyspringdata3.model.Course;
import org.data.itvdnstudyspringdata3.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("course")
public class CourseController {

    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity<?> createCourse(@RequestBody Course course) {
        return courseService.createCourse(course);
    }

    @GetMapping("{id}")
    public ResponseEntity<Course> getCourse(@PathVariable Long id) {
        return courseService.getCourse(id);
    }
}
