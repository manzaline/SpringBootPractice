package com.example.ch03.jpa;

import com.example.ch03.jpa.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PagingRepository extends PagingAndSortingRepository<User, Long> {
}
