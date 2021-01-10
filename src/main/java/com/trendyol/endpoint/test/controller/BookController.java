package com.trendyol.endpoint.test.controller;

import com.trendyol.endpoint.test.model.Book;
import com.trendyol.endpoint.test.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;


@RestController
@RequestMapping("/api/book")
@Validated
public class BookController {

    @Autowired
    private BookService bookService;

    @PutMapping
    public ResponseEntity createBook(@RequestBody @Valid Book book) {
        if (!Objects.isNull(book.getBookId()))
            return new ResponseEntity("Id must generate by system please remove id field",
                    HttpStatus.BAD_REQUEST);

        if (bookService.hasBookByAuthorAndTitle(book.getAuthor(), book.getTitle()))
            return new ResponseEntity("Book already registered with given author and title",
                    HttpStatus.BAD_REQUEST);

        return new ResponseEntity(bookService.createBook(book), HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity getAllBooks() {
        return new ResponseEntity(bookService.getBooks(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getBookById(@PathVariable int id) {
        Optional<Book> bookOptional = bookService.getBookById(id);

        if (!bookOptional.isPresent())
            return new ResponseEntity("Book not found", HttpStatus.NOT_FOUND);

        return new ResponseEntity(bookOptional.get(), HttpStatus.OK);

    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put("Error message", "Field"+" "+fieldName + " " + errorMessage);
        });
        return errors;
    }
}
