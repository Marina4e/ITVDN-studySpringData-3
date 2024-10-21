package org.data.itvdnstudyspringdata3.service;

import org.data.itvdnstudyspringdata3.model.Course;
import org.data.itvdnstudyspringdata3.repository.CourseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseService {

    private CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public ResponseEntity<?> createCourse(Course course) {
        courseRepository.save(course);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    public ResponseEntity<Course> getCourse(Long id) {
        Optional<Course> optionalCourse = courseRepository.findById(id);
        return optionalCourse.map(ResponseEntity::ok).
                orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
