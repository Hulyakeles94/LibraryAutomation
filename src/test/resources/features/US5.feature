Feature: As a data consumer, I want UI and DB book information are match.
  Scenario: Verify book information with DB
    Given I login as a librarian
    And I navigate to "Books" page
    When I open book "Chordeiles minor"
    Then book information must match the Database

  #select name, author,year from books where name='Chordeiles minor';