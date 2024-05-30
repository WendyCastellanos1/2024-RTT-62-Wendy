-- Homework 1 

-- Question 0.1
-- I want to see the count of the number of products in each product line
-- WC note: Each product belongs to only 1 product line (1:1)

		-- first, see all product lines, and check out some data
			select * from productlines;
			select count(*) from products where productline_id = 4;
            
		-- answer
			SELECT pl.product_line, COUNT(p.id)
			FROM   productlines pl
				INNER JOIN products p ON pl.id = p.productline_id
			GROUP BY pl.product_line;					

-- *****Question 0.2**********************************************************************************************
-- I want to see a list of employees and all of the customers for that employee.   Employee name will be duplicated in the result set. 
-- 			I want to see the employee first and last name
-- 			and the customer contact first and last name, as well as the customer name

			SELECT 	e.firstname AS 'employee_first_name',
					e.lastname AS 'employee_last_name',
					c.customer_name,
					c.contact_firstname AS 'customer_contact_first_name',
					c.contact_lastname AS 'customer_contact_last_name'
			FROM 	employees e INNER JOIN customers c ON e.id = c.sales_rep_employee_id
			ORDER BY e.id;
			 -- alternatively, left join would help identify employees who have no customers yet or at the moment

-- *****question 0.3**********************************************************************************************
-- I want to see a list of employees in each office.   Show the office name and the employee name
		-- (inner join to *only* show only employees assigned to an office, and only see appearance of offices if some employee is assigned there.)

		-- first, look at the data
			SELECT  COUNT(*) FROM employees;	-- 27
		
        -- answer
			SELECT  COUNT(*) FROM employees
			WHERE	office_id IS NULL;	-- 0
						
			SELECT o.city AS 'office',
					e.firstname AS 'employee_first_name',
					e.lastname AS 'employee_last_name'
			FROM employees e
					INNER JOIN offices o ON e.office_id = o.id
			ORDER BY o.city; --   27 employees returned

-- *****question 0.4***********************************************************************************************
-- I want to see the total number of each employee type based on job title.
-- 				result should the job title and the number of employees with that job title.

		-- first, look at the data
            select distinct job_title from employees; -- 10
			select * from employees where job_title = 'Sales Rep';  -- should be 17, is 17
            
		-- answer
			SELECT e.job_title, COUNT(e.id) AS 'num_employees_with_job_title'
			FROM employees e
			WHERE e.job_title IS NOT NULL
			GROUP BY e.job_title
            ORDER BY e.job_title;

-- *****question 0.5***************************************************************************************
-- I want to see a list of all payments each customer has made.  Order the list by customer name ascending, then by the payment amount descending

			SELECT c.customer_name, p.amount
			FROM   payments p
			INNER JOIN customers c ON p.customer_id = c.id
			ORDER BY c.customer_name , p.amount DESC;  
			-- lol, every payment must be made by a customer or else there is money laundering (left join would get all payments, even those without customers!)
            
-- *****question 0.6***************************************************************************************
	-- I want to see a list of products that have never been sold.   use ... not in ( select product_id from order_details ) in your where clause

			SELECT * FROM	products
			WHERE id NOT IN (SELECT product_id FROM orderdetails); 

-- *****question 0.7***************************************************************************************
	-- are there any customers that have never made an order

			SELECT customer_name FROM customers
			WHERE id NOT IN (SELECT customer_id FROM orders);

-- *****Question 1*****************************************************************************************
	-- How many customers are handled by each office?  I want to see the office name and the count of the number of customers in that office.
	--       (this one extends the query "offices and their employees" bc office has employees, employees assigned to customers via employee/sales rep_id)

		-- first, see how many offices exist
            SELECT COUNT(*) AS 'count' FROM  offices WHERE city IS NOT NULL;-- 7 offices now
            
		-- answer
			SELECT  off.city AS 'office', COUNT(*) AS customer_qty   -- had COUNT (c.id) and worked same, was easier for me to understand
			FROM   offices off
				INNER JOIN employees e ON off.id = e.office_id
				INNER JOIN customers c ON e.id = c.sales_rep_employee_id
			GROUP BY off.city
			ORDER BY off.city;

-- *****Question 2******************************************************************************************
	-- I want to see the products with the most margin at the top of the table.  
	-- 			Include the product name, buy price, msrp, and margin in the results.  
	-- 			Margin is calculated (MSPR - buy_price) 

			select product_name, buy_price, msrp, (msrp - buy_price) as margin
			from products
			order by margin desc;

-- *****Question 2.5**************************************************************************************
	-- I want to see the top 5 customers in each state based on margin 

		-- first, re-visit products ordered by margin
			select product_name, buy_price, msrp, (msrp - buy_price) as margin
			from products
			order by margin desc;

		-- second, see only customers WITH orders
			select c.state as 'customer_state', 
					c.customer_name, count(o.id) as 'order_count', 
                    o.id as 'order_id', o.order_date, 
					od.id as 'order_detail_id',
                    od.product_id, od.quantity_ordered, 
                    od.price_each, 
                    (od.quantity_ordered * od.price_each) as 'total_sales'
			from orderdetails od
				inner join orders o on od.order_id = o.id
				inner join customers c on o.customer_id = c.id
			group by c.state, c.customer_name, o.id, o.order_date, order_detail_id, od.product_id, od.quantity_ordered, od.price_each, 'total_sales'	
			order by order_count desc;																				
            
		-- third, gets all customers (with orders) with their corresponding states and profit margins     (TODO next:  top 5 per state)
			SELECT c.customer_name, c.state,
					SUM(p.msrp - p.buy_price) AS profit_margin
			FROM customers c
				INNER JOIN orders o ON c.id = o.customer_id
				INNER JOIN orderdetails od ON o.id = od.order_id
				INNER JOIN products p ON p.id = od.product_id
			WHERE c.state IS NOT NULL
				AND c.country = 'USA'
			GROUP BY c.id , c.state
			ORDER BY c.state , profit_margin DESC;
			
        -- answer: use ROW_NUMBER() over PARTITION(partition by ___     order by ___ desc) as row_num   e.g:  row_number over (partition by id order by rate desc) as row_num    --not an alias
		SELECT customer_name, state, profit_margin
        FROM (	SELECT  c.customer_name, c.state,
						SUM(od.quantity_ordered * (p.msrp - p.buy_price)) AS profit_margin,
                        (ROW_NUMBER() over (partition by state order by SUM(p.msrp - p.buy_price) DESC)) AS row_num 				
				FROM customers c
					INNER JOIN orders o ON c.id = o.customer_id
					INNER JOIN orderdetails od ON o.id = od.order_id
					INNER JOIN products p ON p.id = od.product_id
				WHERE c.state IS NOT NULL
					AND c.country = 'USA'
				GROUP BY c.id , c.state
				ORDER BY c.state , profit_margin DESC ) as  subquery
		WHERE row_num <= 5;
				

-- *****Question 3*******************************************************************************************************************
	--  I want to see the top 5 salesmen in the company based on the total amount sold

		-- first, see the salespeople
			select * from employees e where job_title = 'Sales Rep';  
            
			select e.firstname as 'first_name', e.lastname as 'last_name'	
			from employees e where e.job_title = 'Sales Rep' order by e.lastname;

		--  answer
			SELECT first_name, last_name, SUM(total_sales) as 'grand_total'
            FROM (
					SELECT  e.id,
							e.firstname AS 'first_name',
							e.lastname AS 'last_name',
							SUM(od.quantity_ordered * od.price_each) AS 'total_sales'
					FROM    employees e
							INNER JOIN customers c ON e.id = c.sales_rep_employee_id
							INNER JOIN orders o ON c.id = o.customer_id
							INNER JOIN orderdetails od ON o.id = od.order_id
					WHERE	 e.job_title = 'Sales Rep'
					GROUP BY e.id, e.firstname, e.lastname, o.id 
					ORDER BY total_sales DESC ) as subquery
            GROUP BY first_name, last_name
            ORDER BY grand_total DESC
            LIMIT 5;
					

-- *****Question 4***********************************************************************************************
	-- I want to see the top 5 salesmen based on overall profit (margin)
    
			SELECT first_name, last_name, SUM(total_profit_margin) as 'profit_margin_grand_total'
            FROM (
					SELECT  e.id,
							e.firstname AS 'first_name',
							e.lastname AS 'last_name',
							SUM(p.msrp - p.buy_price) AS 'total_profit_margin'
					FROM    employees e
							INNER JOIN customers c ON e.id = c.sales_rep_employee_id
							INNER JOIN orders o ON c.id = o.customer_id
							INNER JOIN orderdetails od ON o.id = od.order_id
                            INNER JOIN products p on od.product_id = p.id
					WHERE	 e.job_title = 'Sales Rep'
					GROUP BY e.id, e.firstname, e.lastname, o.id 
					ORDER BY total_profit_margin DESC ) as subquery
            GROUP BY first_name, last_name
            ORDER BY profit_margin_grand_total DESC
            LIMIT 5;
    

-- *****Question 5 **********************************************************************************************
	-- I want to see all of the orders that happened in 2004. You can use a function called year(order_date) = 2004
    
			SELECT * 
            FROM  orders
			WHERE  YEAR(order_date) = '2004';

-- *****Question 6***********************************************************************************************
	-- I want to see the total amount of all orders grouped by the year
    
		-- first, see which years are in the orders table
        select distinct year(order_date) from orders;
        
        -- second, spot check one year's order totals
        select year(o.order_date) as 'year', SUM(od.quantity_ordered * od.price_each) AS 'order_total'
        from orderdetails od inner join orders o on od.order_id = o.id
        where year(o.order_date) = '2004'
        group by o.order_date;
    
		-- third, sum up the "one year's" order totals for a grand total, expect one record back  TODO: double check the total: 4515905.51
        select year, sum(order_total) as grand_total
        from (
				select year(o.order_date) as 'year',
					   SUM(od.quantity_ordered * od.price_each) as 'order_total'
				from orderdetails od inner join orders o on od.order_id = o.id
				-- where year(o.order_date) = '2004'
				group by year  ) as subquery
		group by year, order_total;
        
    -- answer    (removed the where clause to get all the years)
		 SELECT year, SUM(order_total) AS grand_total
		 FROM (SELECT YEAR(o.order_date) AS 'year',
					  SUM(od.quantity_ordered * od.price_each) AS 'order_total'
			   FROM orderdetails od
			   INNER JOIN orders o ON od.order_id = o.id
			   GROUP BY year) AS subquery
		GROUP BY year , order_total;

-- *****Question 7***********************************************************************************************
	-- I want to see the top 5 products based on quantity sold across all orders
	
		-- first, see all products
			select * from products;

		-- second, see the product ids and product names linked to any and all orders
			select p.id as 'product_id', p.product_name
			from products p inner join orderdetails od on p.id = od.product_id
							inner join orders o on od.order_id = o.id;
                
		-- third, see product mention and corresponding order id, with qty ordered of the product in that order              
			select p.id as 'product_id', p.product_name, o.id as 'order id', od.quantity_ordered as 'quantity_ordered'
			from products p inner join orderdetails od on p.id = od.product_id
							inner join orders o on od.order_id = o.id
			order by p.id;
            
		-- answer:  see top 5 products in terms of all sales across all time
			SELECT p.product_name, SUM(od.quantity_ordered) AS total_ordered
			FROM   products p
				INNER JOIN orderdetails od ON p.id = od.product_id
				INNER JOIN orders o ON od.order_id = o.id
			WHERE od.order_id NOT IN ( SELECT o.id FROM orders WHERE o.status = 'Cancelled')  -- additional requirement, Elaine
			GROUP BY p.id										-- p.product_name  works too, but int faster of course
			ORDER BY total_ordered DESC
			LIMIT 5;

-- *****question 7.5*********************************************************************************************
	-- how many times has each product appeared in an order regardless of how many were purchased.
    
			SELECT p.product_name, COUNT(od.product_id) AS product_appearances
			FROM   products p
			INNER JOIN orderdetails od ON p.id = od.product_id
			GROUP BY p.id
            ORDER BY product_appearances;
            
		-- validate
        select * from orderdetails where product_id = 1;

-- *****question 7.6*********************************************************************************************
	-- how many products would be out of stock based on the amount sold acrosss time.  -- not sure if the data will support this .. basically 
	-- looking for any product where the sum of the quantity sold is greater than the quantity in stock
    
		-- first, check quantity ordered on *only* one product
            select quantity_ordered  
            from orderdetails where product_id = 7;
    
		-- answer: see out-of-stock products and quantity on back-order (enhancement)
			SELECT p.id, p.product_name, p.quantity_in_stock,
					SUM(od.quantity_ordered) AS 'quantity_ordered',
					ABS(p.quantity_in_stock - SUM(od.quantity_ordered)) AS 'back-ordered'
			FROM    products p
					INNER JOIN orderdetails od ON p.id = od.product_id
			GROUP BY p.id , product_name
			HAVING SUM(od.quantity_ordered) >= p.quantity_in_stock;

-- *****question 7.9********************************************************************************************
	-- I want to see the distinct order status, ordered alphabetically
    
			SELECT DISTINCT status  FROM orders
			ORDER BY status;

-- ***** Question 8**********************************************************************************************
	-- I want to see the office name and the distinct product lines that have been sold in that office.  This will require joining almost all of the tables.  

			SELECT DISTINCT off.city AS 'office_name', pl.product_line AS 'product_line'
			FROM   offices off
				INNER JOIN employees e ON off.id = e.office_id
				INNER JOIN customers c ON e.id = c.sales_rep_employee_id
				INNER JOIN orders o ON c.id = o.customer_id
				INNER JOIN orderdetails od ON o.id = od.order_id
				INNER JOIN products p ON p.id = od.product_id
				INNER JOIN productlines pl ON p.productline_id = pl.id
			ORDER BY off.city;