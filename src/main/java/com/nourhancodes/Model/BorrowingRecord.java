package com.nourhancodes.Model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Document
@Data
@NoArgsConstructor
@AllArgsConstructor

public class BorrowingRecord {
    @Id
    private String id;
    @NonNull
    @DBRef
    private Book book;
    
    @NonNull
    @DBRef
    private Patron patron;

    private LocalDate borrowDate;
    private LocalDate returnDate;

}
