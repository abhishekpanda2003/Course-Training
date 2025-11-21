package com.example.Library.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class BookUpdateDTO {

    @NotNull
    private LocalDate publicationDate;

    @NotNull
    private double price;

    @NotNull
    private Boolean availability;

}
