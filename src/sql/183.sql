SELECT name AS Customers FROM Customers WHERE id NOT IN (SELECT customerId AS id FROM Orders);


--SELECT A.Name from Customers A
--LEFT JOIN Orders B on  a.Id = B.CustomerId
--WHERE b.CustomerId is NULL;