Feature: BookStore API tests

  Scenario: User can call book list
    When user calls /api/books
    Then receives status code of 200
    And empty book list

  Scenario: User can add a book
    When user  calls /api/books with author and title
    Then the client receives status code of 201

  Scenario: User can call added book
    Given there are books added on store
    When user  calls /api/books/id
    Then the client receives status code of 200
    And book list with related id

  Scenario: User can  add new book
    Given add mock book object
    When user send put request to /api/books/
    Then the client receives status code of 201
    And created book return

