@US2 @db @ui
Feature:
  As a librarian, I want to know the amount of borrowed books
  Scenario: verify the amount of borrowed books
    Given I am in the homepage of the library app
    When I take borrowed books number
    Then borrowed books number information must match with DB

  #Query :
  #select * from book_borrow;
  #select count(*) from book_borrow where is_returned=0;