package com.trendyol.endpoint.test.service;

import com.trendyol.endpoint.test.model.Book;

import java.util.List;
import java.util.Optional;



public interface BookService {

    List<Book> getBooks();

    Optional<Book> getBookById(Integer id);

    Book createBook(Book book);

    boolean hasBookByAuthorAndTitle(String author, String title);

}
