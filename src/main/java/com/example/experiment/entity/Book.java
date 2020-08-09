package com.example.experiment.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.leangen.graphql.annotations.GraphQLId;
import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.Data;

@Entity
@Data
@Table(name = "book")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GraphQLId
	@GraphQLQuery(name = "id", description = "Unique identifier for the book entity")
	private Integer id;

	@GraphQLQuery(name = "title", description = "Name of the book")
	private String title;

	@GraphQLQuery(name = "totalPages", description = "Total number of pages in the book")
	private Integer totalPages;

	@GraphQLQuery(name = "isbn", description = "International standard book number")
	private String isbn;
}
