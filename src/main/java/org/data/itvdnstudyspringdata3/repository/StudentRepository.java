package org.data.itvdnstudyspringdata3.repository;

import org.data.itvdnstudyspringdata3.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
