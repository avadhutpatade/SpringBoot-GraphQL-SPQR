package com.example.experiment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.experiment.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
