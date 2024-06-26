SELECT DATABASE();
USE EXAMPLES;

select * from lots;
select * from lots where id = 1;
select count(*) from lots;   -- 4

select * from offers;
select * from offers where lot_id = 1;
select * from offers where lot_id = 4;
select count(*) from offers;  -- 20

-- note: change to left join if the inner join is not the right  interpretation of the instructions
-- show lots WITH offers
-- using the round fcn only, name instead of 'name'
select l.name as name, round(min(o.amount), 2) as min_offer, round(avg(o.amount), 2) as avg_offer, round(max(o.amount), 2) as max_offer, count(o.amount) as offers
from lots l join offers o on l.id = o.lot_id
group by o.lot_id
order by offers DESC;

-- show lots WITH offers
-- using the format fcn only
select l.name as 'name', format(min(o.amount), 2) as min_offer, format(avg(o.amount), 2) as avg_offer, format(max(o.amount), 2) as max_offer, count(o.amount) as offers
from lots l join offers o on l.id = o.lot_id
group by o.lot_id
order by offers DESC;

-- show lots WITH offers
-- using both format and round functions
select l.name as 'name', format(round(min(o.amount), 2), 2) as min_offer, format(round(avg(o.amount), 2), 2) as avg_offer, format(round(max(o.amount), 2), 2) as max_offer, count(o.amount) as offers
from lots l join offers o on l.id = o.lot_id
group by o.lot_id
order by offers DESC;




-- original examples SQL  (not SBA)

select * from customers;

-- I want all employees that work in an office in the USA
--  e.id, o.id    vs. ambiguous   id   (KBA)
select e.* 
from employees e, offices o
where e.office_id = o.id
	and o.country = 'USA';
    
select * from orders;

select od.*, (quantity_ordered * price_each) as total_price
from orderdetails od
where order_id = 10103
order by order_line_number;

--  now add the proudcct name to these query results
select od.*, (quantity_ordered * price_each) as total_price, p.product_name
from orderdetails od, products p
where order_id = 10103
	and p.id = od.product_id
order by order_line_number;

-- now lets add the date of the order
select od.*, (quantity_ordered * price_each) as total_price, p.product_name, o.order_date
from orderdetails od, products p, orders o
where order_id = 10103
	and p.id = od.product_id
    and o.id = od.order_id
order by order_line_number;

-- let's add customer first and last name to this
select od.*, (quantity_ordered * price_each) as total_price, p.product_name, o.order_dateotal_price, p.product_name, o.order_date, c.customer_name
from orderdetails od, products p, orders o, customers c
where order_id = 10103
	and p.id = od.product_id
    and o.id = od.order_id
    and o.customer_id = c.id
order by order_line_number;

-- get sum of the total cost for all line items, max..., min...., avg....
select sum(quantity_ordered * price_each) as total_cost_price,
	max(quantity_ordered) as max_quantity_ordered, 
    min(quantity_ordered) as min_quantity_ordered,
    avg(quantity_ordered * price_each) as average_line_item_cost
from orderdetails od
where order_id = 10103;

-- visual the data so the group by is easier to desgin
select * from orderdetails;
-- I want to see the total order cost OF EACH ORDER for all orders    group by   does not have to be in the   select
select  sum(total_order_cost)
from
	(select order_id, sum(quantity_ordered * price_each) as total_order_cost,   -- can't put  order_line_number bc group by collapses the line items for aggregate fcn
	min(quantity_ordered) as min_qty_ordered,
    count(*) as number_of_products) 
	orderdetails
	where order_id in (10103, 10104)
	group by order_id; );
    
select order_id, sum(quantity_ordered * price_each) as total_order_cost,
	min(quantity_ordered) as min_quantity_ordered,
	count(*) as number_of_products
from orderdetails od
group by order_id;

-- now I want to see the total amount each customer has spent
-- setp 1 was to join the customer table and the order table
-- we also limited our columns in the result set so the data was a bit more soncsumable by a human brain
-- put an order by   on this  so we could see oall of the cusotomer order together
select c.customer_name, o.id as order_id
from customers c, orders o
where c.id = o.customer_id
order by customer_name;

-- step 2 we need to conitinue joining over to the order details
-- we added a second column to the order by so we could see the products in each order by the order_id
select c.customer_name, o.id as order_id, od.product_id
from customers c, orders o, orderdetails od
where c.id = o.customer_id
	and o.id = od.order_id
order by customer_name, order_id;

-- step 3  join to the orderdetails table and we added the line item cost calculation
--  at this step now that we can sicualize the data in the database and begin to think about how we can do a group by
select c.customer_name, o.id as order_id, od.product_id, quantity_orded, price_each, (quantity_ordered * price_each) as line_item_cost
from customers c, orders o, orderdetails od
where c.id = o.customer_id
	and o.id = od.order_id
order by customer_name, order_id;

-- step 4 group by 
-- we removed the extra columns that were not in group by from the select
-- we also removed teh extra columns from the order by
-- because we are grouping but the customer_id we can also get the customer name bc the customer record is singular and grouped by
select c.id, c.customer_name, sum(quantity_ordered * price_each) as total_customer_spent
from customers c, orders o, orderdetails od
where c.id = o.customer_id
	and o.id = od.order_id
group by c.id
order by total_customer_spent desc;

-- to expand the original question to see the sum of each order for each cutomer
-- we have now added an order by for the order id so we can see the total cost for each order for all customers
-- we can now include the order id in the select columns bc it is in the group by
select c.id, c.customer_name, o.id, sum(quantity_ordered * price_each) as total_order_cost
from customers c, orders o, orderdetails od
where c.id = o.customer_id
	and o.id = od.order_id
group by c.id, o.id
order by c.customer_name;

-- add one step more complex. i only want to see the orders that over 50K
-- by adding having it allows us to filter the aggregate results and we cannot do this in the where clause because the
-- aggregate result has not yet been calculated at the time the database is considering the where clause
-- above: aggregate queries
select c.id, c.customer_name, o.id, sum(quantity_ordered * price_each) as total_order_cost
from customers c, orders o, orderdetails od
where c.id = o.customer_id
	and o.id = od.order_id
group by c.id, o.id
having total_order_cost > 50000  -- only operates on the aggregate values
order by c.customer_name;
-- limit would be last possibility


-- Below: load data into sba lots db

insert into lots
    values (1, 'Merremia qunquefolia (L.) Hallier f.' );

insert into lots
    values (3, 'Hobenbergia antilana Mez');
    
insert into lots
    values (4, 'Penstemom eriantherus Pursh var. argillosus M.E. Jones');
    
insert into offers
	values (1, 510);
    insert into offers
	values (2, 703.80);
    insert into offers
	values (2, 181.80);
    insert into offers
	values (1, 38.06);
    insert into offers
	values (2, 368.78);
    insert into offers
	values (3, 91.40);
    insert into offers
	values (2, 413.80);
    insert into offers
	values (3, 157.99);
    insert into offers
	values (3, 885.82);
    insert into offers
	values (2, 863.99);
    insert into offers
	values (1, 307.61);
    insert into offers
	values (2, 120.39);
    insert into offers
	values (1, 771.96);
    insert into offers
	values (2, 801.42);
    insert into offers
	values (3, 871.59);
    insert into offers
	values (1, 541.61);
    insert into offers
	values (3, 477.62);
    insert into offers
	values (2, 303.29);
    insert into offers
	values (2, 612.83);
    insert into offers
	values (3, 464.98);
    

