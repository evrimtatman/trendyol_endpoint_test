package com.trendyol.endpoint.test.service.impl;

import com.trendyol.endpoint.test.model.Book;
import com.trendyol.endpoint.test.repository.BookRepository;
import com.trendyol.endpoint.test.service.BookService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getBookById(Integer id) {
        log.info("Method : getBookById , Parameters : [id] {}", id);
        return bookRepository.findById(id);
    }

    @Override
    public Book createBook(Book book) {
        log.info("Method : createBook , Parameters : [book] {}", book);
        return bookRepository.save(book);
    }

    @Override
    public boolean hasBookByAuthorAndTitle(String author, String title) {
        log.info("Method : hasBookByAuthorAndTitle , Parameters : [author, title] {}{}", author, title);
        Optional<Book> bookOptional = bookRepository.findByAuthorAndTitle(author, title);
        return bookOptional.isPresent();
    }
}
