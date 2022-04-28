CREATE OR REPLACE FUNCTION tax_sequence
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
insert into tax_sequence (company_id,sequence, end_sequence)
values(c_id,'21005','21999');
return v_c_id;

end;
$$;