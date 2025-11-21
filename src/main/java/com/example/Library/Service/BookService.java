package com.example.Library.Service;

import com.example.Library.DTO.BookReqDTO;
import com.example.Library.DTO.BookUpdateDTO;
import com.example.Library.Entity.Book;
import com.example.Library.Entity.Genre;
import jakarta.validation.Valid;

import java.util.List;

public interface BookService {
    String addNewBook(@Valid BookReqDTO bookReqDTO);

    String updateBook(Long bookId, BookUpdateDTO bookReqDTO);

    List<Book> getBookByGenre(Genre genre);
}
