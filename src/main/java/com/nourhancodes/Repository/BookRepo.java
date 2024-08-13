package com.nourhancodes.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nourhancodes.Model.Book;

public interface BookRepo extends MongoRepository<Book,String> {
  Optional<Book> findByTitle(String title);
}
