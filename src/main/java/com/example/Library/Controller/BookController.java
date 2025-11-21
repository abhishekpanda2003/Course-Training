package com.example.Library.Controller;

import com.example.Library.DTO.BookReqDTO;
import com.example.Library.DTO.BookUpdateDTO;
import com.example.Library.Entity.Genre;
import com.example.Library.Service.BookService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
@AllArgsConstructor
public class BookController {

    private BookService bookService;

    @PostMapping("/addBook")
    public ResponseEntity<?> addBook(@RequestBody @Valid BookReqDTO bookReqDTO){
        String msg = bookService.addNewBook(bookReqDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(msg);
    }

    @PatchMapping("/updateBook/{bookId}")
    public ResponseEntity<?> updateBook(@PathVariable Long bookId, @RequestBody BookUpdateDTO dto){
        String msg = bookService.updateBook(bookId, dto);
        return ResponseEntity.ok(msg);
    }

    @GetMapping("/getBooks/{genre}")
    public ResponseEntity<?> getBooks(@PathVariable Genre genre){
        return ResponseEntity.ok(bookService.getBookByGenre(genre));
    }
}
