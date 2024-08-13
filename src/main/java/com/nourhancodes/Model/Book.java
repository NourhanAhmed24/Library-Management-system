package com.nourhancodes.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Document
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Book {

  @Id
  private String id;

  @NonNull
  private String title;
  @NonNull
  private String author;
  @NonNull
  private int publicationYear;
  @NonNull
  private String isbn;

  public Book(String title, String author, int pubYear, String isbn)
  {
    this.title=title;
    this.author=author;
    this.publicationYear=pubYear;
    this.isbn=isbn;
  }


}
