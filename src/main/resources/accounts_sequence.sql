CREATE OR REPLACE FUNCTION accounts_sequence
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
insert into accounts_sequence (account_type_id, company_id, start_range, end_range)
values('1',c_id,'10100','19999');
insert into accounts_sequence (account_type_id, company_id, start_range, end_range)
values('2',c_id,'22000','29999');
insert into accounts_sequence (account_type_id, company_id, start_range, end_range)
values('3',c_id,'30100','39999');
insert into accounts_sequence (account_type_id, company_id, start_range, end_range)
values('4',c_id,'40100','49999');
insert into accounts_sequence (account_type_id, company_id, start_range, end_range)
values('5',c_id,'52000','99999');
return v_c_id;

end;
$$;