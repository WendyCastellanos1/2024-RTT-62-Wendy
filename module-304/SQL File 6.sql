-- Homework 1 

-- Question 0.1
-- I want to see the count of the number of products in each product line
-- WC note: Each product belongs to 1 product line (1:1)

			select * from productlines;
			select count(*) from products where productline_id = 4;

			select pl.product_line, count(p.id)
			from productlines pl inner join products p on pl.id = p.productline_id
			group by pl.product_line;					-- pl.id;

-- *****Question 0.2**********************************************************************************************
-- I want to see a list of employees and all of the customers for that employee.   Employee name will be duplicated in the result set. 
-- 			I want to see the employee first and last name
-- 			and the customer contact first and last name, as well as the customer name

			select e.firstname as 'employee_first_name', e.lastname as 'employee_last_name', 
					c.customer_name, c.contact_firstname as 'customer_contact_first_name', c.contact_lastname as 'customer_contact_last_name' 
			from employees e inner join customers c on e.id = c.sales_rep_employee_id
			order by e.id;
			 -- alternatively, left join would help identify employees who have no customers yet or at the moment

-- *****question 0.3**********************************************************************************************
-- I want to see a list of employees in each office.   Show the office name and the employee name
-- (inner join to *only* show the matches, e.g. only employees assigned to an office, and only see appearance of offices if some employee is assigned there.)

			select count(*) from employees; -- 27
			select count(*) from employees where office_id is null; -- 0
			select o.city as 'office', e.firstname as 'employee_first_name', e.lastname as 'employee_last_name'
			from employees e inner join offices o on e.office_id = o.id
			order by o.city; --   27 employees returned

-- *****question 0.4***********************************************************************************************
-- I want to see the total number of each employee type based on job title.
-- 				result should the job title and the number of employees with that job title.

			select distinct job_title from employees; -- 10
			select * from employees where job_title = 'Sales Rep';  -- should be 17, is 17

			select e.job_title, count(e.id) as 'num_employees_with_job_title'
			from employees e
			where e.job_title is not null
			group by e.job_title;

-- *****question 0.5***************************************************************************************
-- I want to see a list of all payments each customer has made.  Order the list by customer name ascending, then by the payment amount descending

			select c.customer_name, p.amount
			from payments p inner join customers c on p.customer_id = c.id
			order by c.customer_name, p.amount desc;  -- every payment must be made by a customer or else there is money laundering (left join gets payments without customers!)

-- *****question 0.6***************************************************************************************
	-- I want to see a list of products that have never been sold.   use ... not in ( select product_id from order_details ) in your where clause

			select * from products where id not in ( select product_id from orderdetails ); 

-- *****question 0.7***************************************************************************************
	-- are there any customers that have never made an order

			select customer_name from customers where id not in ( select customer_id from orders );

-- *****Question 1*****************************************************************************************
	-- How many customers are handled by each office?  I want to see the office name and the count of the number of customers in that office.
	--       (this one extends the query "offices and their employees" bc office has employees, employees assigned to customers via employee/sales rep_id)

			select count(*) as 'count' from offices;    -- 7 offices now
			select off.city as 'office', count(distinct c.id) as customer_qty
			from offices off inner join employees e on off.id = e.office_id
				inner join customers c on e.id = c.sales_rep_employee_id
			group by off.city
			order by off.city;

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

		-- second, see only customer WITH orders
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
            
		-- third, gets all customers with their states and profit margins     (TODO next:  top 5 per state)
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
        
        -- next, try putting result set in a temp table and query it for the desired output
			
				
	CREATE TEMPORARY TABLE IF NOT EXISTS t1 AS 
		SELECT * FROM (
        
				SELECT c.customer_name, c.state,
						SUM(p.msrp - p.buy_price) AS profit_margin
				FROM customers c
					INNER JOIN orders o ON c.id = o.customer_id
					INNER JOIN orderdetails od ON o.id = od.order_id
					INNER JOIN products p ON p.id = od.product_id
				WHERE c.state IS NOT NULL
					AND c.country = 'USA'
				GROUP BY c.id , c.state
				ORDER BY c.state , profit_margin DESC ) ;
                
		-- use the temp table
		select customer_name, state, profit_margin 
        from (
        
			select customer_name, state, profit_margin, 
					@last, if(@last=state, @top:=top+1, @top:=0) as the_top, 
                    @last:= state update_last
			from t1
       
        ) t2 where the_top < 5;
				
		-- TRUNCATE t1; 	-- clean out for re-use
        
        -- try without the temp table   DOESN'T WORK      !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
      
		select customer_name, state, profit_margin, 
					@last, if(@last=state, @top:=@top+1, @top:=0) as the_top, 
                    @last:= state update_last
		from (	SELECT c.customer_name, c.state,
						SUM(p.msrp - p.buy_price) AS profit_margin
				FROM customers c
					INNER JOIN orders o ON c.id = o.customer_id
					INNER JOIN orderdetails od ON o.id = od.order_id
					INNER JOIN products p ON p.id = od.product_id
				WHERE c.state IS NOT NULL
					AND c.country = 'USA'
				GROUP BY c.id , c.state
				ORDER BY c.state , profit_margin DESC ) as  t2
		where t2.the_top < 5;  
        
        -- answer: use  e.g:  row_number over (partition by id order by rate desc)
		SELECT customer_name, state, profit_margin
        FROM (	SELECT  c.customer_name, c.state,
						SUM(p.msrp - p.buy_price) AS profit_margin,
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

		--  answer		-- TODO combine the rows for each salesperson, combining their total_sales
			select e.firstname as 'first_name', e.lastname as 'last_name', 
					sum(od.quantity_ordered * od.price_each) as total_sales
			from employees e 
				inner join customers c on e.id = c.sales_rep_employee_id
				inner join orders o on c.id = o.customer_id
				inner join orderdetails od on o.id = od.order_id
			where e.job_title = 'Sales Rep'
			group by e.firstname, e.lastname, o.id
			order by total_sales desc
			limit 5;

-- *****Question 4***********************************************************************************************
	-- I want to see the top 5 salesmen based on overall profit (margin)

-- *****Question 5 **********************************************************************************************
	-- I want to see all of the orders that happened in 2004. You can use a function called year(order_date) = 2004
    
			select * from orders where year(order_date) ='2004';

-- *****Question 6***********************************************************************************************
	-- I want to see the total amount of all orders grouped by the year

			select year(o.order_date) as 'year', sum(od.quantity_ordered * od.price_each) as order_total
			from orders o inner join orderdetails od on o.id = od.order_id
			group by o.id, year
			order by year(o.order_date) desc;

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
			select p.product_name, sum(od.quantity_ordered) as 'total ordered'
			from products p inner join orderdetails od on p.id = od.product_id
							inner join orders o on od.order_id = o.id
			group by p.product_name
			order by sum(od.quantity_ordered) desc
			limit 5;

-- *****question 7.5*********************************************************************************************
	-- how many times has each product appeared in an order regardless of how many were purchased.
    
			select p.id, p.product_name, count(od.product_id) as 'product_appearances'
			from products p inner join orderdetails od on p.id = od.product_id
			group by p.product_name, p.id;

-- *****question 7.6*********************************************************************************************
	-- how many products would be out of stock based on the amount sold acrosss time.  -- not sure if the data will support this .. basically 
	-- looking for any product where the sum of the quantity sold is greater than the quantity in stock
    
		-- first, check quantity ordered on *only* one product
            select quantity_ordered  
            from orderdetails where product_id = 7;
    
		-- answer: see out-of-stock products and quantity on back-order (enhancement)
			select p.id, p.product_name, p.quantity_in_stock, sum(od.quantity_ordered) as 'quantity_ordered', (p.quantity_in_stock - sum(od.quantity_ordered)) as 'back-ordered'
            from products p inner join orderdetails od on p.id = od.product_id
            group by p.id, product_name
            having sum(od.quantity_ordered) >= p.quantity_in_stock;

-- *****question 7.9********************************************************************************************
	-- I want to see the distinct order status ordered alphabetically
    
			select distinct status 
			from orders 
			order by status;

-- ***** Question 8**********************************************************************************************
	-- I want to see the office name and the distinct product lines that have been sold in that office.  This will require joining almost all of the tables.  

			select distinct f.city as 'office_name', pl.product_line as 'product_line'
            from offices f  inner join employees e on f.id = e.office_id
							inner join customers c on e.id = c.sales_rep_employee_id
                            inner join orders o on c.id = o.customer_id
                            inner join orderdetails od on o.id = od.order_id
                            inner join products p on p.id = od.product_id
                            inner join productlines pl on p.productline_id = pl.id
			order by f.city;