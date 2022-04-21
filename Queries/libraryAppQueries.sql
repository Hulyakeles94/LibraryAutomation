select * from book_borrow;

SELECT book_categories.name, COUNT(*) AS countofbookcategories
FROM book_borrow
         INNER JOIN books
                    ON book_borrow.book_id = books.id
         INNER JOIN book_categories
                    ON books.book_category_id = book_categories.id
GROUP BY book_categories.name
ORDER BY countofbookcategories DESC;

SELECT u.full_name, count(*) as countofreadbooks
from users u inner join book_borrow bb on u.id = bb.user_id
group by full_name
order by 2 DESC ;

select name,author,year from books
where name='Chordeiles minor';