Feature: As a librarian, I want to know who is the most popular user
  Scenario: verify who is the most popular user who reads the most
    Given Establish the database connection
    When I execute a query to find the most popular user
    Then verify "Test Student [number]” is the user who reads the most

  # select full_name,count(*) from users u inner join book_borrow bb
  # on u.id = bb.user_id
  # group by full_name
  # order by 2 desc ;