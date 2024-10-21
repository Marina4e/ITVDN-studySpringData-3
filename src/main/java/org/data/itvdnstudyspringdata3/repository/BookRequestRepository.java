package org.data.itvdnstudyspringdata3.repository;

import org.data.itvdnstudyspringdata3.model.BookRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRequestRepository extends JpaRepository<BookRequest, Long> {
}
