# Write your MySQL query statement below

-- select *
-- from orders o inner join company c on (o.com_id = c.com_id and c.name = 'RED')
-- right join salesperson on salesperson.sales_id = o.sales_id
-- where o.sales_id is null


select name from SalesPerson  where name not in
(select SalesPerson.name from SalesPerson
left join Orders on SalesPerson.sales_id = Orders.sales_id
left join Company on Orders.com_id = Company.com_id where Company.name = "RED")