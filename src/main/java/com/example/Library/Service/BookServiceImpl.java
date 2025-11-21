package com.example.Library.Service;

import com.example.Library.DTO.BookReqDTO;
import com.example.Library.DTO.BookUpdateDTO;
import com.example.Library.Entity.Book;
import com.example.Library.Entity.Genre;
import com.example.Library.Exception.ResourceAlreadyExists;
import com.example.Library.Exception.ResourceNotFound;
import com.example.Library.Repository.BookRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class BookServiceImpl implements BookService{

    private BookRepository bookRepository;
    private ModelMapper modelMapper;

    @Override
    public String addNewBook(BookReqDTO bookReqDTO) {
        if (!bookRepository.existsByTitle(bookReqDTO.getTitle())){
            Book transientE = modelMapper.map(bookReqDTO,Book.class);
            Book persistentE = bookRepository.save(transientE);
            return "Book Added || Book Id :: " + persistentE.getBookId();
        }
        else throw new ResourceAlreadyExists("Book of that title already exists");
    }

    /*
     @NotNull
    private LocalDate publicationDate;

    @NotNull
    private double price;

    @NotNull
    private Boolean availability;
     */
    @Override
    public String updateBook(Long bookId, BookUpdateDTO dto) {
        Book existingBook = bookRepository.findById(bookId).orElseThrow(()->new ResourceNotFound("Book not found with the given id"));


        existingBook.setPublicationDate(dto.getPublicationDate());
        existingBook.setPrice(dto.getPrice());
        existingBook.setAvailability(dto.getAvailability());



        return "Successfully updated book details";
    }

    @Override
    public List<Book> getBookByGenre(Genre genre) {
        if (bookRepository.existsByGenre(genre)){
            return bookRepository.findByGenre(genre);
        }
        else throw new ResourceNotFound("No Available Data !!!w");
    }
}
