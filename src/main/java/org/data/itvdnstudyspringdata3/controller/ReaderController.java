package org.data.itvdnstudyspringdata3.controller;

import org.data.itvdnstudyspringdata3.model.Reader;
import org.data.itvdnstudyspringdata3.service.ReaderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("reader")
public class ReaderController {

    private ReaderService readerService;

    public ReaderController(ReaderService readerService) {
        this.readerService = readerService;
    }

    @PostMapping
    public ResponseEntity<?> createReader(@RequestBody Reader reader) {
        return readerService.createReader(reader);
    }

    @GetMapping("{id}")
    public ResponseEntity<Reader> getReader(@PathVariable Long id) {
        return readerService.getReader(id);
    }
}
