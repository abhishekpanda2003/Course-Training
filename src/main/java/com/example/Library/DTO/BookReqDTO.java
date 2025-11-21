package com.example.Library.DTO;

import com.example.Library.Entity.Genre;
import com.example.Library.Entity.Member;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class BookReqDTO {

    @NotBlank
    private String title;

    @NotBlank
    private String author;

    @NotNull
    private Genre genre;

    @NotNull
    private LocalDate publicationDate;

    @NotNull
    private double price;

    @NotNull
    private Boolean availability;


    private Member member;

}
