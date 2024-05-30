-- SET sql_mode=(SELECT REPLACE(@@sql_mode,'ONLY_FULL_GROUP_BY',''));

-- number 1
select  c.customer_name as 'Customer Name',
		concat(e.lastName, ', ', e.firstName) as 'Sales Rep'
from customers c JOIN employees e
on c.sales_rep_employee_id = e.id
order by c.customer_name asc;

-- number 2
select  p.product_name as 'Product Name', 
		sum(od.quantity_ordered) as 'Total #Ordered', 
        sum(od.quantity_ordered * od.price_each) as 'Total Sale'
from products p LEFT JOIN orderdetails od
			on p.id = od.product_id
group by p.product_name, p.buy_price
order by 3 desc;

-- number 3
select status as 'Order Status', 
		count(status) as 'Total Orders'
from orders
group by status
order by status;

-- number 4
select pl.product_line as 'Product Line',
		count(od.product_id) as 'total Sold'
from productlines pl join products p on pl.id=p.productline_id
	 join orderdetails od on p.id = od.product_id
group by pl.product_line
order by 2 desc;

-- number 5 !!!!!!!!!!!!
select  month(payment_date) AS Month,
		year(payment_date) AS Year,
		format(sum(amount), 2) AS 'Payments Received'
from payments
group by year(payment_date), month(payment_date)
order by payment_date;

-- number 6
SELECT  p.product_name 'Product Name', 
		l.product_line AS `Product Line`,
		p.product_scale AS `Scale`, 
        p.product_vendor AS `Vendor` 
FROM	productlines l NATURAL JOIN products p
WHERE l.product_line = "Classic Cars" 
		OR l.product_line = "Vintage Cars"
ORDER BY p.productline_id DESC, p.product_name ASC;
