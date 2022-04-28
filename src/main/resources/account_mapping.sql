CREATE OR REPLACE FUNCTION def_account_mapping
(
    c_id bigint
)  
RETURNS bigint
LANGUAGE plpgsql      
AS   
$$  
declare
begin
INSERT INTO account_mapping(account_group_id,accounts_id,company_id)
SELECT ACCOUNT_GROUP.ID as account_group_id,ACCOUNTS.ID as accounts_id,ACCOUNT_GROUP.COMPANY_ID as company_id
FROM ACCOUNTS,ACCOUNT_GROUP_MAPPING
WHERE ACCOUNTS.ACCOUNT_GROUP_ID=ACCOUNT_GROUP_MAPPING.ACCOUNT_GROUP_ID
and accounts.id <= 40
AND company_id=c_id;
return c_id;
end;
$$;