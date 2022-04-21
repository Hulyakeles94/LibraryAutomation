@Us5 @ui @db
Feature: As a data consumer, I want UI and DB book categories match.
  Scenario: verify book categories with DB
    Given I login as a librarian
    When I navigate to "Books" page
    And I take all book categories in UI
    And I execute a query to get book categories
    Then verify book categories must match the book_categories table from DB.

  #select name from book_categories;