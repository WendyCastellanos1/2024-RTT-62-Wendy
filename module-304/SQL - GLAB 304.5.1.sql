
-- MOD() function
SELECT 	order_id, 
		SUM(quantity_ordered) as qty,
IF(MOD(SUM(quantity_ordered),2),'Odd', 'Even') as oddOrEven
FROM orderdetails
GROUP BY order_id
ORDER BY order_id;

-- TRUNCATE() function
SELECT TRUNCATE(1.555,1);

SELECT  od.product_id, 
		AVG(od.quantity_ordered * od.price_each) as avg_order_value
FROM orderdetails od JOIN products p on od.product_id = p.id
GROUP BY od.product_id;

SELECT product_id,
		ROUND(AVG(quantity_ordered * price_each)) as avg_order_item_value
FROM orderdetails
GROUP BY product_id;

-- TRUNCATE() function vs ROUND function
SELECT TRUNCATE(1.999,1), ROUND(1.999,1);

-- REPLACE() function
UPDATE products
SET product_description = REPLACE(product_description,'abuot','about');

-- DATEDIFF() function
SELECT id, 
		DATEDIFF(required_date, shipped_date) as days_left
FROM orders
ORDER BY days_left DESC; 

-- DATEDIFF() function
SELECT DATEDIFF('2011-08-17','2011-08-17');
#Result : 0 day
SELECT DATEDIFF('2011-08-17','2011-08-08');
#Result: 9 days
SELECT DATEDIFF('2011-08-08','2011-08-17');

-- calc. days left
SELECT id, DATEDIFF(required_date, shipped_date) as days_left
FROM orders
ORDER BY daysLeft DESC;
#Result: -9 days

-- get all orders whos status is "In Process" and calc. num days remaining
SELECT id, DATEDIFF(required_date, order_date) as remaining_days
FROM orders
WHERE status = 'In Process'
ORDER BY remaining_days;

-- calculate an interval in a week or a month
SELECT
	id,
	ROUND(DATEDIFF(required_date, order_date) / 7, 2),
	ROUND(DATEDIFF(required_date, order_date) / 30,2)
FROM orders
WHERE status = 'In Process';

-- DATE_FORMAT()   date formatting functions

SELECT
	id,
	DATE_FORMAT(order_date, '%Y-%m-%d') order_date,
	DATE_FORMAT(required_date, '%a %D %b %Y') required_date,
	DATE_FORMAT(shipped_date, '%W %D %M %Y') shipped_date
FROM orders;

SELECT id,
DATE_FORMAT(shipped_date, '%W %D %M %Y') as 'Shipped date'
FROM orders
ORDER BY shipped_date;

-- LPAD(str, len, padstr)  left-pads a string with another string to a certain length ,  returns a string

SELECT LPAD('hi',4,'??'); #Result -> '??hi'
SELECT LPAD('hi',1,'??'); # Result -> 'h'

SELECT firstName, 
	LPAD(firstName,10,'kk'),  -- adds onto the left side to make total of 10 characters
    LPAD(firstName,5,'kk'),  -- if adding the two characters 'kk' would make LEN too long, then NOT added at all! e.g. yoon stays the same
	LPAD(firstName,4,'kk')   -- if too many characters already, just removes characters from the RIGHT side to make LEN
FROM employees;

-- TRIM() function
SELECT TRIM(' SQL TRIM Function ');

-- LTRIM() function
SELECT LTRIM(' SQL LTRIM function');

-- RTRIM function
SELECT RTRIM('SQL RTRIM function ');

-- YEAR function
SELECT YEAR('2002-01-01');

-- YEAR() function 		get number of orders shipped per year
SELECT YEAR(shipped_date) as year, 
			COUNT(id) as order_quantity -- count the delivered orders
FROM orders
GROUP BY YEAR(shipped_date)
ORDER BY YEAR(shipped_date);

-- DAY function
SELECT DAY('2022-01-15');

-- return the number of orders per day in 2004
SELECT DAY(order_date) as dayofmonth, 
		COUNT(*)
FROM orders 
WHERE YEAR(order_date) = 2004
GROUP BY dayofmonth
ORDER BY dayofmonth;


