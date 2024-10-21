package org.data.itvdnstudyspringdata3.repository;

import org.data.itvdnstudyspringdata3.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByName(String name);

    boolean existsByName(String name);

    Integer countByAuthor(String author);

    void deleteByName(String name);

    List<Book> findFirst4ByAuthor(String author);

    List<Book> findDistinctByAuthor(String author);

    boolean existsByAuthorAndGenre(String author, String genre);

    List<Book> findByNameOrAuthor(String name, String author);

    Integer countByNameContaining(String line);

    @Query("SELECT book FROM Book book")
    List<Book> findAllJPQL();

    List<Book> findByAuthorName(String author);

    @Query(value = "SELECT book.author FROM book WHERE book.name = :name AND book.genre = :genre", nativeQuery = true)
    Optional<String> findAuthorByNameAndGenre
            (@Param("name") String name, @Param("genre") String genre);
}
