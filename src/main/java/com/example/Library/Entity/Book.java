package com.example.Library.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Genre genre;

    @Column(nullable = false)
    private LocalDate publicationDate;

    @Column(nullable = false)
    @Min(value=0)
    private double price;

    @Column(nullable = false)
    private Boolean availability;

    @ManyToOne
    @JoinColumn(name = "borrowedBy")
    private Member member;

}
