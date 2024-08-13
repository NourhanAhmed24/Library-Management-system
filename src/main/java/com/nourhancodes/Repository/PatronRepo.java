package com.nourhancodes.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nourhancodes.Model.Patron;

public interface PatronRepo extends MongoRepository<Patron,String> {
  Optional<Patron> findByName(String name);

}
