Feature: BookStore API tests

  Scenario: At the beging book list must be empty
    When user calls all books /api/books
    Then receives status code of 200
    And check empty book list

  Scenario: User can  add new book
    Given add mock book object title "title" author "author"
    When user  calls put endpoint /api/books/
    Then the client receives status code of 201
    And created book return

  Scenario: User can call added book
    Given there are books added on store
    When user  calls /api/books/id 1
    Then the client receives status code of 200
    And check book  with related id 1


  Scenario: User can not add same title and author book
    When user calls all books /api/books/id 1
    Then receives status code of 200
    And check book is exist
    When user can add new book same author and title
    Then receives status code of 400

  Scenario: User can not send  id parameter in object
    Given create book with given 10
    Then user  calls put book endpoint
    And receives status code of 400






