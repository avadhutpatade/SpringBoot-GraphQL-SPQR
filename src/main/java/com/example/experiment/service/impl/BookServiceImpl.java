package com.example.experiment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.experiment.entity.Book;
import com.example.experiment.repository.BookRepository;
import com.example.experiment.service.BookService;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;

@Service
@GraphQLApi
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	@GraphQLQuery(name = "books")
	public List<Book> getAll() {
		return bookRepository.findAll();
	}

	@Override
	@GraphQLQuery(name = "book")
	public Book getById(@GraphQLArgument(name = "id") Integer id) {
		return bookRepository.findById(id).orElse(null);
	}

	@Override
	@GraphQLMutation(name = "saveBook")
	public Book save(@GraphQLArgument(name = "book") Book book) {
		return bookRepository.save(book);
	}

	@Override
	@GraphQLMutation(name = "deleteBook")
	public String delete(@GraphQLArgument(name = "id") Integer id) {
		bookRepository.deleteById(id);
		return new String("Book with id " + id + " deleted successfully.");
	}
}
