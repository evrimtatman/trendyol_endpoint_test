package com.trendyol.endpoint.test.def;

import com.trendyol.endpoint.test.model.Book;
import com.trendyol.endpoint.test.service.impl.RequestServiceImpl;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;

import java.util.List;


public class BookStepDefinitions extends RequestServiceImpl {

    static ResponseEntity response;

    static Book mockBook;

    @When("user calls all books \\/api\\/books")
    public void userCallsAllBooksApiBooks() {
        response = executeGet();
    }

    @Then("receives status code of {int}")
    public void receivesStatusCodeOf(int arg0) {
        Assert.assertEquals(arg0, response.getStatusCode().value());
    }

    @And("check empty book list")
    public void checkEmptyBookList() {
        List<Book> list = (List<Book>) response.getBody();
        Assert.assertTrue(CollectionUtils.isEmpty(list));
    }


    @Given("add mock book object title {string} author {string}")
    public void addMockBookObjectTitleAuthor(String title, String author) {
        mockBook = new Book();
        mockBook.setTitle(title);
        mockBook.setAuthor(author);
    }

    @When("user  calls put endpoint \\/api\\/books\\/")
    public void userCallsPutEndpointApiBooks() {
        response = executePut(mockBook);
    }

    @Then("the client receives status code of {int}")
    public void theClientReceivesStatusCodeOf(int code) {
        Assert.assertEquals(code, response.getStatusCode().value());
    }

    @And("created book return")
    public void createdBookReturn() {
        Book book = getModelMapper().map(response.getBody(), Book.class);
        Assert.assertNotNull(book);
        mockBook = book;
    }

    @Given("there are books added on store")
    public void thereAreBooksAddedOnStore() {
        response = executeGet();
        List list = getModelMapper().map(
                response.getBody(), List.class);
        Assert.assertTrue(!CollectionUtils.isEmpty(list));

    }


    @When("user  calls \\/api\\/books\\/id {int}")
    public void userCallsApiBooksId(int id) {
        response = executeGetById(id);
        mockBook = getModelMapper().map(response.getBody(), Book.class);
        Assert.assertNotNull(mockBook);
    }


    @And("check book  with related id {int}")
    public void checkBookWithRelatedId(int arg0) {
        Assert.assertEquals(arg0, mockBook.getBookId().intValue());
    }


    @When("user calls all books \\/api\\/books\\/id {int}")
    public void userCallsAllBooksApiBooksId(int id) {
        response = executeGetById(id);
        mockBook = getModelMapper().map(response.getBody(), Book.class);
    }

    @And("check book is exist")
    public void checkBookIsExist() {
        Assert.assertNotNull(mockBook);
    }

    @When("user can add new book same author and title")
    public void userCanAddNewBookSameAuthorAndTitle() {
        Book book = new Book();
        book.setAuthor(mockBook.getAuthor());
        book.setTitle(mockBook.getTitle());
        response = executePut(book);
    }

    @Given("create book with given {int}")
    public void createBookWithGiven(int arg0) {
        Book book = new Book();
        book.setBookId(arg0);
        book.setAuthor(mockBook.getAuthor());
        book.setTitle(mockBook.getTitle());
        mockBook = book;
    }

    @Then("user  calls put book endpoint")
    public void userCallsPutBookEndpoint() {
        response = executePut(mockBook);
    }
}
