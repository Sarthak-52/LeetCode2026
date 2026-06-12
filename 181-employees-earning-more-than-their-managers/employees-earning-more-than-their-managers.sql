# Write your MySQL query statement below
SELECT e1.name as Employee
From Employee AS e1
JOIN  Employee e2
ON e1.managerID = e2.id
Where e1.salary > e2.salary;