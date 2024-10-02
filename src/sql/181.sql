

--https://leetcode.com/problems/employees-earning-more-than-their-managers/

SELECT e2.name AS Employee
FROM Employee e1
INNER JOIN Employee e2 ON e1.id = e2.managerId
WHERE e2.salary > e1.salary;

-- Self Join

--SELECT E1.Name
--FROM Employee AS E1, Employee AS E2
--WHERE E1.ManagerId = E2.Id AND E1.Salary > E2.Salary;


--This will not work if inner query return multiple rows

--SELECT Name AS Employee
--FROM Employee e
--WHERE Salary > (
--    SELECT Salary
--    FROM Employee m
--    WHERE m.Id = e.ManagerId
--);




