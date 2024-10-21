package org.data.itvdnstudyspringdata3.repository;

import org.data.itvdnstudyspringdata3.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
