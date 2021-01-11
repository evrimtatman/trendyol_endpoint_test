package com.trendyol.endpoint.test.service;

import com.trendyol.endpoint.test.model.Book;
import org.springframework.http.ResponseEntity;


public interface RequestService {

    ResponseEntity executeGet();

    ResponseEntity executeGet(String url);

    ResponseEntity executeGetById(int id);

    ResponseEntity executePut(Book book);
}
