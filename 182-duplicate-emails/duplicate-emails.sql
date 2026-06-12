# Write your MySQL query statement below
SELECT email AS Email
FROM Person Group By email
HAVING COunt(email) > 1;