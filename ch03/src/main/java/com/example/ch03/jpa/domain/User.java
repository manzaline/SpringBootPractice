package com.example.ch03.jpa.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "practice_users")
@Data
public class User {

  @Id
  @Column(name = "ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "NAME")
  private String name;

  @Column(name = "PASSWORD")
  private String password;

  @Column(name = "AGE")
  private int age;
  public User() {}

  public User(String name, String password, int age) {
    this.name = name;
    this.password = password;
    this.age = age;
  }
}
