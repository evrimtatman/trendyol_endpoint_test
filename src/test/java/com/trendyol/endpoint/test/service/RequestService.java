package com.trendyol.endpoint.test.service;

import com.trendyol.endpoint.test.model.Book;
import org.springframework.http.ResponseEntity;

/**
 * Created by Bulut Cakan (179997) on
 * Hour :14:23
 * Day: Monday
 * Month:January
 * Year:2021
 */
public interface RequestService {

    ResponseEntity executeGet();

    ResponseEntity executeGet(String url);

    ResponseEntity executeGetById(int id);

    ResponseEntity executePut(Book book);
}
