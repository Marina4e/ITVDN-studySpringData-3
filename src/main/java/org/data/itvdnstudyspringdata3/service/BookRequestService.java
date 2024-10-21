package org.data.itvdnstudyspringdata3.service;

import org.data.itvdnstudyspringdata3.model.BookRequest;
import org.data.itvdnstudyspringdata3.repository.BookRequestRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookRequestService {

    private BookRequestRepository bookRequestRepository;

    public BookRequestService(BookRequestRepository bookRequestRepository) {
        this.bookRequestRepository = bookRequestRepository;
    }

    public ResponseEntity<?> createRequest(BookRequest bookRequest) {
        bookRequestRepository.save(bookRequest);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    public ResponseEntity<BookRequest> getRequest(Long id) {
        Optional<BookRequest> optionalBookRequest =
                bookRequestRepository.findById(id);
        return optionalBookRequest.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .build());
    }
}
