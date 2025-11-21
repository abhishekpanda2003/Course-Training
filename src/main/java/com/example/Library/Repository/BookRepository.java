package com.example.Library.Repository;

import com.example.Library.Entity.Book;
import com.example.Library.Entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    boolean existsByTitle(String title);

    boolean existsByGenre(Genre genre);

    List<Book> findByGenre(Genre genre);
}
