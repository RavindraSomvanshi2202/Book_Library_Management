package com.BookLibraryManagement.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
    private String title;
    private String author;
    private boolean borrowed;

    @ManyToOne
    @JoinColumn(name="userId")
    private User borrowedBy;
}
