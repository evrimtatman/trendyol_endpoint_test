package com.trendyol.endpoint.test.def;

import com.trendyol.endpoint.test.configuration.CommonHttpMethods;
import com.trendyol.endpoint.test.constants.EndPointTestConstants;
import com.trendyol.endpoint.test.model.Book;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;


public class BookStepDefinitions extends CommonHttpMethods {


    static ResponseEntity response;

    static Book bookMock;


    @When("user calls \\/api\\/books")
    public void userCallsApiBooks() {
        response = executeGet(EndPointTestConstants.URL);
    }

    @Then("receives status code of {int}")
    public void receivesStatusCodeOf(int arg0) {
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());

    }

    @And("empty book list")
    public void emptyBookList() {
        List<Book> books = (List<Book>) response.getBody();
        Assert.assertEquals(0, books.size());
    }

    @When("user  calls \\/api\\/books with author and title")
    public void userCallsApiBooksWithAuthorAndTitle() {
    }

    @Then("the client receives status code of {int}")
    public void theClientReceivesStatusCodeOf(int arg0) {
    }

    @Given("there are books added on store")
    public void thereAreBooksAddedOnStore() {
    }

    @When("user  calls \\/api\\/books\\/id")
    public void userCallsApiBooksId() {
    }

    @And("book list with related id")
    public void bookListWithRelatedId() {
    }


    @Given("add mock book object")
    public void add_mock_book_object() {
        bookMock = new Book();
        bookMock.setAuthor("Evrimcik2");
        bookMock.setTitle("Minicik Ayaklar");
    }

    @When("user send put request to \\/api\\/books\\/")
    public void user_send_put_request_to_api_books() {
        response = executePut(EndPointTestConstants.URL, bookMock);
    }

    @Then("the client receives status code of 201")
    public void created_book_return() {
        Assert.assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @And("^created book return$")
    public void createdBookReturn() {
        Book registeredBook = (Book) response.getBody();
        Assert.assertEquals(bookMock.getAuthor(), registeredBook.getAuthor());
        Assert.assertEquals(bookMock.getTitle(), registeredBook.getTitle());
    }


}
