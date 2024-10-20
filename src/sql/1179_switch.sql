# Write your MySQL query statement below

SELECT
    id,
    SUM(CASE WHEN month = 'Jan' THEN revenue ELSE null END) AS Jan_Revenue,
    SUM(CASE WHEN month = 'Feb' THEN revenue ELSE null END) AS Feb_Revenue,
    SUM(CASE WHEN month = 'Mar' THEN revenue ELSE null END) AS Mar_Revenue,
    SUM(CASE WHEN month = 'Apr' THEN revenue ELSE null END) AS Apr_Revenue,
    SUM(CASE WHEN month = 'May' THEN revenue ELSE null END) AS May_Revenue,
    SUM(CASE WHEN month = 'Jun' THEN revenue ELSE null END) AS Jun_Revenue,
    SUM(CASE WHEN month = 'Jul' THEN revenue ELSE null END) AS Jul_Revenue,
    SUM(CASE WHEN month = 'Aug' THEN revenue ELSE null END) AS Aug_Revenue,
    SUM(CASE WHEN month = 'Sep' THEN revenue ELSE null END) AS Sep_Revenue,
    SUM(CASE WHEN month = 'Oct' THEN revenue ELSE null END) AS Oct_Revenue,
    SUM(CASE WHEN month = 'Nov' THEN revenue ELSE null END) AS Nov_Revenue,
    SUM(CASE WHEN month = 'Dec' THEN revenue ELSE null END) AS Dec_Revenue
FROM
    Department
GROUP BY
    id;


--Searched CASE: Evaluates complex conditions without needing a starting expression or column name.
--Simple CASE: Requires an initial expression (e.g., a column name) to compare against specified values.

SELECT
    sale_id,
    total_amount,
    CASE
        WHEN total_amount > 1000 THEN 'High Discount'
        WHEN total_amount BETWEEN 500 AND 1000 THEN 'Medium Discount'
        ELSE 'No Discount'
    END AS discount_level,
    CASE status
        WHEN 'completed' THEN 'Sale completed'
        WHEN 'pending' THEN 'Sale pending'
        WHEN 'cancelled' THEN 'Sale cancelled'
        ELSE 'Unknown status'
    END AS sale_status_message
FROM
    Sales;
