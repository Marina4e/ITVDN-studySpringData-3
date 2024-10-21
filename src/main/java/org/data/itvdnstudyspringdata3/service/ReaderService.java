package org.data.itvdnstudyspringdata3.service;

import org.data.itvdnstudyspringdata3.model.Reader;
import org.data.itvdnstudyspringdata3.repository.ReaderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReaderService {

    private ReaderRepository readerRepository;

    public ReaderService(ReaderRepository readerRepository) {
        this.readerRepository = readerRepository;
    }

    public ResponseEntity<?> createReader(Reader reader) {
        readerRepository.save(reader);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    public ResponseEntity<Reader> getReader(Long id) {
        Optional<Reader> optionalReader = readerRepository.findById(id);
        return optionalReader.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
