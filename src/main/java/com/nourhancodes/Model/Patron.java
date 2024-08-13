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

public class Patron {
  @Id
  private String id;

  @NonNull
  private String name;
  @NonNull
  private String email;

  public Patron(String name, String email)
  {
    this.name=name;
    this.email=email;
  }

}
