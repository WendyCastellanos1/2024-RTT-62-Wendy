SELECT 
	id, 
    order_line_number, 
    quantity_ordered * price_each
FROM orderdetails
ORDER BY subtotal DESC;

SELECT 
	id, 
    order_line_number, 
    quantity_ordered * price_each as subtotal
FROM orderdetails
ORDER BY subtotal DESC;


SELECT firstname, lastname, reports_to
FROM employees
ORDER BY reports_to;

SELECT firstname, lastname, reports_to
FROM employees
ORDER BY reports_to DESC;  -- puts NULLs at bottom of result set
