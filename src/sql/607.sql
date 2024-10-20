# Write your MySQL query statement below

-- select *
-- from orders o inner join company c on (o.com_id = c.com_id and c.name = 'RED')
-- right join salesperson on salesperson.sales_id = o.sales_id
-- where o.sales_id is null


SELECT name
FROM SalesPerson
WHERE name NOT IN (
    SELECT SalesPerson.name
    FROM SalesPerson
    LEFT JOIN Orders ON SalesPerson.sales_id = Orders.sales_id
    LEFT JOIN Company ON Orders.com_id = Company.com_id
    WHERE Company.name = 'RED'
);
