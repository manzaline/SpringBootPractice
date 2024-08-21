package com.example.ch03.jpa;

import com.example.ch03.jpa.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.stream.Stream;

public interface UserRepository extends CrudRepository<User, Long> {

  Iterable<User> findAllByName(String name);
  Iterable<User> findAllByNameOrderByAge(String name);
  boolean existsByName(String name);
  long countByName(String name);
  Iterable<User> findByNameOrAge(String name, int age);
  Iterable<User> findByNameStartsWith(String name);
  Stream<User> streamAllByAge(String age);
}
