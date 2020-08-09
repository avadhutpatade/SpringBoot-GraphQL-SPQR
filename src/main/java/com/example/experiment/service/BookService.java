package com.example.experiment.service;

import java.util.List;

import com.example.experiment.entity.Book;

public interface BookService {

	public List<Book> getAll();

	public Book getById(Integer id);

	public Book save(Book book);

	public String delete(Integer id);
}
