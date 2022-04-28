CREATE OR REPLACE FUNCTION add_customer
(
    c_id bigint
)  
RETURNS bigint
LANGUAGE plpgsql      
AS   
$$  
declare
v_c_id bigint;
begin
insert into customer (company_id, first_name, last_name, email, mobile_number, title, active)
values(c_id,'Brian','Lawrence','brian34@gmail.com','8956859685','MR','1');
insert into customer (company_id, first_name, last_name, email, mobile_number, title, active)
values(c_id,'Jake','Bejoy','jakesb@gmail.com','9865416445','MR','1');
insert into customer (company_id, first_name, last_name, email, mobile_number, title, active)
values(c_id,'Lara','Matthew','laramtw@gmail.com','5396746885','MRS','1');
insert into customer (company_id, first_name, last_name, email, mobile_number, title, active)
values(c_id,'Mona','Lisaa','mlisaa@gmail.com','64398459688','Ms','1');
return v_c_id;

end;
$$;