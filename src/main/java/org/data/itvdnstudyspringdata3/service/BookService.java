package org.data.itvdnstudyspringdata3.service;

import org.data.itvdnstudyspringdata3.model.Book;
import org.data.itvdnstudyspringdata3.repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public ResponseEntity<?> createBook(Book book) {
        bookRepository.save(book);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public ResponseEntity<Book> getBook(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            return ResponseEntity.ok(book.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    public ResponseEntity<Book> findByName(String name) {
        Optional<Book> book = bookRepository.findByName(name);
        if (book.isPresent()) {
            return ResponseEntity.ok(book.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    public ResponseEntity<?> updateBook(Book book) {
        Optional<Book> bookOptional = bookRepository.findById(book.getId());
        if (bookOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        bookRepository.save(book);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    public ResponseEntity<?> deleteBook(Long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        bookRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    public ResponseEntity<Boolean> existByName(String name) {
        return ResponseEntity.ok(bookRepository.existsByName(name));
    }

    public ResponseEntity<Integer> countByAuthor(String author) {
        return ResponseEntity.ok(bookRepository.countByAuthor(author));
    }

    public ResponseEntity<?> deleteByName(String name) {
        if (bookRepository.existsByName(name)) {
            bookRepository.deleteByName(name);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    public ResponseEntity<List<Book>> findFirst4ByAuthor(String author) {
        return ResponseEntity.ok(bookRepository.findFirst4ByAuthor(author));
    }

    public ResponseEntity<List<Book>> findDistinctByAuthor(String author) {
        return ResponseEntity.ok(bookRepository.findDistinctByAuthor(author));
    }

    public ResponseEntity<Boolean> existByAuthorAndGenre(String author,
                                                         String genre) {
        return ResponseEntity.ok(bookRepository.existsByAuthorAndGenre(author,
                genre));
    }

    public ResponseEntity<List<Book>> findByNameOrAuthor(String name,
                                                         String author) {
        return ResponseEntity.ok(bookRepository.findByNameOrAuthor(name, author));
    }

    public ResponseEntity<Integer> countByNameContaining(String line) {
        return ResponseEntity.ok(bookRepository.countByNameContaining(line));
    }

    public ResponseEntity<List<Book>> findAllJPQL() {
        return ResponseEntity.ok(bookRepository.findAllJPQL());
    }

    public ResponseEntity<List<Book>> findByAuthorName(String author) {
        return ResponseEntity.ok(bookRepository.findByAuthorName(author));
    }

    public ResponseEntity<String> findAuthorByNameAndGenre(String name, String genre) {
        Optional<String> author = bookRepository.findAuthorByNameAndGenre(name, genre);
        if (author.isPresent()) {
            return ResponseEntity.ok(author.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    public ResponseEntity<Page<Book>> findAllPageable
            (int pageNumber, int size) {
        Pageable pageable = PageRequest.of(pageNumber, size);
        return ResponseEntity.ok(bookRepository.findAll(pageable));
    }

    public ResponseEntity<List<Book>> findAllSorted(String property, String way) {
        Sort sort = Sort.by(Sort.Direction.fromString(way), property);
        return ResponseEntity.ok(bookRepository.findAll(sort));
    }

    public ResponseEntity<Page<Book>> findAllPageableAndSorted(int pageNumber, int size, String property, String way) {
        Sort sort = Sort.by(Sort.Direction.fromString(way), property);
        Pageable pageable = PageRequest.of(pageNumber, size, sort);
        return ResponseEntity.ok(bookRepository.findAll(pageable));
    }
}
