package org.data.itvdnstudyspringdata3.controller;

import org.data.itvdnstudyspringdata3.model.BookRequest;
import org.data.itvdnstudyspringdata3.service.BookRequestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("book-request")
public class BookRequestController {

    private BookRequestService bookRequestService;

    public BookRequestController(BookRequestService bookRequestService) {
        this.bookRequestService = bookRequestService;
    }

    @PostMapping
    public ResponseEntity<?> createBookRequest
            (@RequestBody BookRequest bookRequest) {
        return bookRequestService.createRequest(bookRequest);
    }

    @GetMapping("{id}")
    public ResponseEntity<BookRequest> getBookRequest(@PathVariable Long id) {
        return bookRequestService.getRequest(id);
    }
}
