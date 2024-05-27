
-- OR operator

SELECT customer_name, country
FROM customers
WHERE country = 'USA' OR country = 'France';

-- AND operator

SELECT customer_name, country, credit_limit
FROM customers
WHERE (country = 'USA' OR country = 'France') AND
credit_limit > 100000;

-- without (), ... return the customers who are located in the USA or the customers who are located in France with a credit limit greater than 10000.
SELECT customer_name, 
		country, 
        credit_limit FROM customers
WHERE country = 'USA' OR country = 'France' AND credit_limit > 100000; -- left to right

-- BETWEEN and NOT BETWEEN   -- is inclusive, Begin and End values are INCLUDED
SELECT id, product_name, buy_price
FROM products
WHERE buy_price BETWEEN 90 AND 100;
-- same effect as...
SELECT id, product_name, buy_price
FROM products
WHERE buy_price >= 90 AND buy_price <= 100;

SELECT id, product_name, buy_price FROM products
WHERE buy_price NOT BETWEEN 20 AND 100;
-- same as...
SELECT id, product_name, buy_price FROM products
WHERE buy_price < 20 OR buy_price > 100;

-- IS NULL operator		find customers who do NOT have a sales rep
SELECT customer_name, country, sales_rep_employee_id
FROM customers
WHERE sales_rep_employee_id IS NULL
ORDER BY customer_name;
-- opposite 			find customers who HAVE a sales rep
SELECT customer_name, country, sales_rep_employee_id
FROM customers
WHERE sales_rep_employee_id IS NOT NULL
ORDER BY customer_name;

-- LEFT JOIN predicate wtih the IS NULL operator 	to find customers who have NO orders
SELECT c.id, c.customer_name, o.id, o.STATUS
FROM customers c
LEFT JOIN orders o
ON c.id = o.customer_id
WHERE o.id IS NULL;






