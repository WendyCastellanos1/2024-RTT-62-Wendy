select * from customers;

-- I want all employees that work in an office in the USA
--  e.id, o.id    vs. ambiguous   id   (KBA)
select e.* 
from employees e, offices o
where e.office_id = o.id
	and o.country = 'USA';
    
