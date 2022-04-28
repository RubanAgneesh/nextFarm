INSERT INTO public.payment_method(id, code, title, description, active)	VALUES ('1','CASH', 'CASH','CASH', '1');
INSERT INTO public.payment_method(id, code, title, description, active)	VALUES ('2','BANK', 'BANK','BANK', '1');
INSERT INTO public.payment_method(id, code, title, description, active)	VALUES ('3','CHEQUE', 'CHEQUE','CHEQUE', '1');
INSERT INTO public.payment_method(id, code, title, description, active)	VALUES ('4','CREDITCARD', 'CREDIT CARD','CREDIT CARD', '1');
INSERT INTO public.payment_method(id, code, title, description, active)	VALUES ('5','PAYPAL', 'PAYPAL','PAYPAL', '1');
INSERT INTO public.payment_method(id, code, title, description, active)	VALUES ('6','OTHER', 'OTHER','OTHER', '1');


INSERT INTO public.document_type (id,document_type, document_desc, status) VALUES ('1','BILL', 'BILL','1');
INSERT INTO public.document_type (id,document_type, document_desc, status)	VALUES ('2','CRN', 'CREDIT NOTE','1');
INSERT INTO public.document_type (id,document_type, document_desc, status) VALUES ('3','INV', 'INVOICE','1');
INSERT INTO public.document_type (id,document_type, document_desc, status)	VALUES ('4','DN', 'DEBIT NOTE','1');
INSERT INTO public.document_type (id,document_type, document_desc, status) VALUES ('5','BP', 'BILL PAYMENT','1');
INSERT INTO public.document_type (id,document_type, document_desc, status)	VALUES ('6','RP', 'RECORD PAYMENT','1');
INSERT INTO public.document_type (id,document_type, document_desc, status)	VALUES ('7','E', 'EXPENSE','1');
INSERT INTO public.document_type (id,document_type, document_desc, status)	VALUES ('8','I', 'INCOME','1');
INSERT INTO public.document_type (id,document_type, document_desc, status)	VALUES ('9','J', 'JOURNAL','1');
INSERT INTO public.document_type (id,document_type, document_desc, status)	VALUES ('10','R', 'REFUND','1');
INSERT INTO public.document_type (id,document_type, document_desc, status)	VALUES ('11','T', 'TRANSFER','1');
INSERT INTO public.document_type (id,document_type, document_desc, status)	VALUES ('12','VPVC', 'VENDOR PREPAY','1');
INSERT INTO public.document_type (id,document_type, document_desc, status)	VALUES ('13','CPCC', 'CUSTOMER PREPAY','1');
INSERT INTO public.document_type (id,document_type, document_desc, status)	VALUES ('14','DIS', 'DISCOUNT','1');
INSERT INTO public.document_type (id,document_type, document_desc, status)	VALUES ('15','FEE', 'FEES','1');
INSERT INTO public.document_type (id,document_type, document_desc, status)	VALUES ('16','TAXR', 'TAX REFUND','1');
INSERT INTO public.document_type (id,document_type, document_desc, status)	VALUES ('17','TAXP', 'TAX PAID','1');
INSERT INTO public.document_type (id,document_type, document_desc, status)	VALUES ('18','OBB', 'OPENING BALANCE FOR BILL','1');
INSERT INTO public.document_type (id,document_type, document_desc, status)	VALUES ('19','OBC', 'OPENING BALANCE FOR CREDITNOTE','1');
INSERT INTO public.document_type (id,document_type, document_desc, status)	VALUES ('20','ST', 'STATEMENT','1');





INSERT INTO CONFIG_PROPERTIES(config_property_id, config_description, config_name, config_value, is_active)
			VALUES(1, 'DEFAULT_DISTANCE', 'DEFAULT_DISTANCE', '100', '1');


INSERT INTO CONFIG_PROPERTIES(config_property_id, config_description, config_name, config_value, is_active)
			VALUES(2, 'REGISTRATION_TYPE', 'REGISTRATION_TYPE', 'SOLE PROPRIETOR', '1');
INSERT INTO CONFIG_PROPERTIES(config_property_id, config_description, config_name, config_value, is_active)
			VALUES(3, 'REGISTRATION_TYPE', 'REGISTRATION_TYPE', 'PARTNERSHIP OR LIMITED LIABILITY', '1');
INSERT INTO CONFIG_PROPERTIES(config_property_id, config_description, config_name, config_value, is_active)
			VALUES(4, 'REGISTRATION_TYPE', 'REGISTRATION_TYPE', 'PUBLIC LIMITED', '1');
INSERT INTO CONFIG_PROPERTIES(config_property_id, config_description, config_name, config_value, is_active)
			VALUES(5, 'REGISTRATION_TYPE', 'REGISTRATION_TYPE', 'NON PROFIT', '1');
INSERT INTO CONFIG_PROPERTIES(config_property_id, config_description, config_name, config_value, is_active)
			VALUES(6, 'REGISTRATION_TYPE', 'REGISTRATION_TYPE', 'NOT SURE', '1');

INSERT INTO CONFIG_PROPERTIES(config_property_id, config_description, config_name, config_value, is_active)
			VALUES(7, 'BUSINESS_TYPE', 'BUSINESS_TYPE', 'RETAIL', '1');
INSERT INTO CONFIG_PROPERTIES(config_property_id, config_description, config_name, config_value, is_active)
			VALUES(8, 'BUSINESS_TYPE', 'BUSINESS_TYPE', 'WHOLESALE', '1');
INSERT INTO CONFIG_PROPERTIES(config_property_id, config_description, config_name, config_value, is_active)
			VALUES(9, 'BUSINESS_TYPE', 'BUSINESS_TYPE', 'HOSPITALITY', '1');
INSERT INTO CONFIG_PROPERTIES(config_property_id, config_description, config_name, config_value, is_active)
			VALUES(35, 'BUSINESS_TYPE', 'BUSINESS_TYPE', 'OTHER SERVICES', '1');

INSERT INTO CONFIG_PROPERTIES(config_property_id, config_description, config_name, config_value, is_active)
			VALUES(10, 'INDUSTRY', 'INDUSTRY', 'RETAIL TRADE (FOOD)', '1');
INSERT INTO CONFIG_PROPERTIES(config_property_id, config_description, config_name, config_value, is_active)
			VALUES(11, 'INDUSTRY', 'INDUSTRY', 'RETAIL TRADE (NON-FOOD)', '1');

INSERT INTO CONFIG_PROPERTIES(config_property_id, config_description, config_name, config_value, is_active)
			VALUES(12, 'INDUSTRY', 'INDUSTRY', 'BUILDING / CONSTRUCTION', '1');
INSERT INTO CONFIG_PROPERTIES(config_property_id, config_description, config_name, config_value, is_active)
			VALUES(13, 'INDUSTRY', 'INDUSTRY', 'TECHNOLOGY', '1');
INSERT INTO CONFIG_PROPERTIES(config_property_id, config_description, config_name, config_value, is_active)
			VALUES(14, 'INDUSTRY', 'INDUSTRY', 'TRADES WORK', '1');
INSERT INTO CONFIG_PROPERTIES(config_property_id, config_description, config_name, config_value, is_active)
			VALUES(15, 'INDUSTRY', 'INDUSTRY', 'EDUCATION', '1');
INSERT INTO CONFIG_PROPERTIES(config_property_id, config_description, config_name, config_value, is_active)
			VALUES(16, 'INDUSTRY', 'INDUSTRY', 'FARMING', '1');
INSERT INTO CONFIG_PROPERTIES(config_property_id, config_description, config_name, config_value, is_active)
			VALUES(17, 'INDUSTRY', 'INDUSTRY', 'FINANCE', '1');
INSERT INTO CONFIG_PROPERTIES(config_property_id, config_description, config_name, config_value, is_active)
			VALUES(18, 'INDUSTRY', 'INDUSTRY', 'MANUFACTURING', '1');
INSERT INTO CONFIG_PROPERTIES(config_property_id, config_description, config_name, config_value, is_active)
			VALUES(19, 'INDUSTRY', 'INDUSTRY', 'MEDICAL', '1');
INSERT INTO CONFIG_PROPERTIES(config_property_id, config_description, config_name, config_value, is_active)
			VALUES(20, 'INDUSTRY', 'INDUSTRY', 'HEALTH AND BEAUTY', '1');
INSERT INTO CONFIG_PROPERTIES(config_property_id, config_description, config_name, config_value, is_active)
			VALUES(21, 'INDUSTRY', 'INDUSTRY', 'ADMINSTRATIVE SERVICES', '1');
INSERT INTO CONFIG_PROPERTIES(config_property_id, config_description, config_name, config_value, is_active)
			VALUES(22, 'INDUSTRY', 'INDUSTRY', 'ARTS', '1');
INSERT INTO CONFIG_PROPERTIES(config_property_id, config_description, config_name, config_value, is_active)
			VALUES(23, 'INDUSTRY', 'INDUSTRY', 'ACCOMMODATION', '1');
INSERT INTO CONFIG_PROPERTIES(config_property_id, config_description, config_name, config_value, is_active)
			VALUES(24, 'INDUSTRY', 'INDUSTRY', 'PROFESSIONAL SERVICES', '1');
INSERT INTO CONFIG_PROPERTIES(config_property_id, config_description, config_name, config_value, is_active)
			VALUES(25, 'INDUSTRY', 'INDUSTRY', 'REPAIR AND MAINTENANCE', '1');
INSERT INTO CONFIG_PROPERTIES(config_property_id, config_description, config_name, config_value, is_active)
			VALUES(26, 'INDUSTRY', 'INDUSTRY', 'TRANSPORT AND LOGISTICS', '1');

INSERT INTO CONFIG_PROPERTIES(config_property_id, config_description, config_name, config_value, is_active)
			VALUES(27, 'EMAIL_USERNAME', 'EMAIL_USERNAME', 'docs@dockket.com', '1');
INSERT INTO CONFIG_PROPERTIES(config_property_id, config_description, config_name, config_value, is_active)
			VALUES(28, 'EMAIL_PASSWORD', 'EMAIL_PASSWORD', 'dockket123', '1');
			
INSERT INTO CONFIG_PROPERTIES(config_property_id, config_description, config_name, config_value, is_active)
			VALUES(29, 'UPLOADSIZE', 'UPLOADSIZE', '3', '1');
			
INSERT INTO CONFIG_PROPERTIES(config_property_id, config_description, config_name, config_value, is_active)
			VALUES(30, 'ANDROID_VERSION', 'ANDROID_VERSION', '1.0.1-9', '1');
			
INSERT INTO CONFIG_PROPERTIES(config_property_id, config_description, config_name, config_value, is_active)
			VALUES(31, 'IOS_VERSION', 'IOS_VERSION', '1.0.5-1', '1');
			
INSERT INTO CONFIG_PROPERTIES(config_property_id, config_description, config_name, config_value, is_active)
			VALUES(32, 'ANNOUNCEMENT', 'ANNOUNCEMENT', '', '0');
			
INSERT INTO CONFIG_PROPERTIES(config_property_id, config_description, config_name, config_value, is_active)
			VALUES(33, 'SCROLLER', 'SCROLLER', '', '0');

INSERT INTO CONFIG_PROPERTIES(config_property_id, config_description, config_name, config_value, is_active)
			VALUES(34, 'LOCKED_DATE', 'LOCKED_DATE', '31-12-2019', '1');
			
INSERT INTO CONFIG_PROPERTIES(config_property_id, config_description, config_name, config_value, is_active)
			VALUES(36, 'DOCKKET_EMAIL_PREFIX', 'DOCKKET_EMAIL_PREFIX', 'docs+', '1');
			
INSERT INTO CONFIG_PROPERTIES(config_property_id, config_description, config_name, config_value, is_active)
			VALUES(37, 'DOCKKET_EMAIL_SUFIX', 'DOCKKET_EMAIL_SUFIX', '@dockket.com', '1');
			
INSERT INTO CONFIG_PROPERTIES(config_property_id, config_description, config_name, config_value, is_active)
			VALUES(38, 'ALL ACCOUNTS', 'All Accounts', 'INCOME', '1');
			
INSERT INTO CONFIG_PROPERTIES(config_property_id, config_description, config_name, config_value, is_active)
			VALUES(39, 'CREATED FROM TRANSFER', 'Transfer from Bank, Credit Card or Loan', 'INCOME', '1');
			
INSERT INTO CONFIG_PROPERTIES(config_property_id, config_description, config_name, config_value, is_active)
			VALUES(40, 'PAYMENT RECEIVED FOR A CUSTOMER INVOICE', 'Payment Received For a Customer Invoice', 'INCOME', '1');
			
INSERT INTO CONFIG_PROPERTIES(config_property_id, config_description, config_name, config_value, is_active)
			VALUES(41, 'REFUND RECEIVED FOR A SUPPLIER BILL', 'Refund Received For a Supplier Bill', 'INCOME', '1');
			
INSERT INTO CONFIG_PROPERTIES(config_property_id, config_description, config_name, config_value, is_active)
			VALUES(42, 'REFUND FOR EXPENSE', 'Refund For Expense', 'INCOME', '1');
			
INSERT INTO CONFIG_PROPERTIES(config_property_id, config_description, config_name, config_value, is_active)
			VALUES(43, 'SALES TAX REFUND', 'Sales Tax Refund', 'INCOME', '1');
			
INSERT INTO CONFIG_PROPERTIES(config_property_id, config_description, config_name, config_value, is_active)
			VALUES(44, 'DEPOSIT FROM PERSONAL', 'Deposit From Personal', 'INCOME', '1');
			
INSERT INTO CONFIG_PROPERTIES(config_property_id, config_description, config_name, config_value, is_active)
			VALUES(45, 'ALL ACCOUNTS', 'All Accounts', 'EXPENSE', '1');
			
INSERT INTO CONFIG_PROPERTIES(config_property_id, config_description, config_name, config_value, is_active)
			VALUES(46, 'CREATED BY TRANSFER', 'Transfer to Bank, Credit Card or Loan', 'EXPENSE', '1');
			
INSERT INTO CONFIG_PROPERTIES(config_property_id, config_description, config_name, config_value, is_active)
			VALUES(47, 'PAYMENT SENT FOR A SUPPLIER BILL', 'Payment Sent For a Supplier Bill', 'EXPENSE', '1');
			
INSERT INTO CONFIG_PROPERTIES(config_property_id, config_description, config_name, config_value, is_active)
			VALUES(48, 'REFUND SENT FOR A CUSTOMER INVOICE', 'Refund Sent For a Customer Invoice', 'EXPENSE', '1');
			
INSERT INTO CONFIG_PROPERTIES(config_property_id, config_description, config_name, config_value, is_active)
			VALUES(49, 'REFUND FOR INCOME', 'Refund For Income', 'EXPENSE', '1');
			
INSERT INTO CONFIG_PROPERTIES(config_property_id, config_description, config_name, config_value, is_active)
			VALUES(50, 'SALES TAX PAYMENT', 'Sales Tax Payment', 'EXPENSE', '1');
			
INSERT INTO CONFIG_PROPERTIES(config_property_id, config_description, config_name, config_value, is_active)
			VALUES(51, 'WITHDRAWAL TO PERSONAL', 'Withdrawal To Personal', 'EXPENSE', '1');
			
INSERT INTO USERS (email,is_active,is_registered,password,username,otp_count) VALUES 
('admin@dockkets.com','true','true','$2a$10$WQJJppf24Ni0TbtIdtJ1B.keWgba19MzzuIWVrRlYtmNRp4lwMnMm','admin@dockkets.com',0);


INSERT INTO public.role_master (id,description, role_name, active, hidden,user_id) VALUES ('1','STAFF', 'STAFF','1','0','1');
INSERT INTO public.role_master (id,description, role_name, active,hidden,user_id)  VALUES ('2','OWNER', 'OWNER','1','1','1');
INSERT INTO public.role_master (id,description, role_name, active,hidden,user_id)  VALUES ('3','ACCOUNTANT', 'ACCOUNTANT','1','1','1');
INSERT INTO public.role_master (id,description, role_name, active,hidden,user_id)  VALUES ('4','CO-OWNER', 'CO-OWNER','0','0','1');
INSERT INTO public.role_master(id,description, role_name, active,hidden,user_id)   VALUES ('5','SUPERADMIN', 'SUPERADMIN','0','1','1');
INSERT INTO public.role_master(id,description, role_name, active,hidden,user_id)   VALUES ('6','USER', 'USER','0','1','1');
INSERT INTO public.role_master (id,description, role_name, active,hidden,user_id)  VALUES ('7','CASHIER', 'CASHIER','1','0','1');
INSERT INTO public.role_master (id,description, role_name, active,hidden,user_id)  VALUES ('8','MANAGER', 'MANAGER','1','0','1');

INSERT INTO STORE_USER_ROLE (role_id,user_id,detached) VALUES (5,1,'false');
insert into currency (id,currency_active,currency_code,currency_description,currency_symbol) values ('1','true', 'EUR', 'Euro',e'\u20AC');
insert into currency (id,currency_active,currency_code,currency_description,currency_symbol) values ('3','true','USD', 'US Dollar',e'\u0024');
insert into currency (id,currency_active,currency_code,currency_description,currency_symbol) values ('2','true', 'INR', 'Indian Rupee',e'\u20B9');
insert into currency (id,currency_active,currency_code,currency_description,currency_symbol) values ('4','true', 'GBP', 'Pound',e'\u00A3');


insert into country (id, country_name, status, currency_id) values ('1', 'IRELAND', 'true','1');
insert into country (id, country_name, status, currency_id) values ('3', 'USA', 'true','3');
insert into country (id, country_name, status, currency_id) values ('2', 'INDIA', 'true','2');
insert into country (id, country_name, status, currency_id) values ('4', 'UNITED KINGDOM', 'true','4');



INSERT INTO country_info ( mobile_prefix, status, time_zone, country_id, tax_applicable, id)
VALUES ( '+91', 'true', 'Asia/Kolkata', '2', 'GST', '102');

INSERT INTO country_info ( mobile_prefix, status, time_zone, country_id, tax_applicable, id)
VALUES ( '+353', 'true', 'Europe/Dublin', '1', 'VAT', '101');

INSERT INTO country_info ( mobile_prefix, status, time_zone, country_id, tax_applicable, id)
VALUES ( '+1', 'true', 'America/New_York', '3', 'SALES TAX', '103');

INSERT INTO country_info ( mobile_prefix, status, time_zone, country_id, tax_applicable, id)
VALUES ( '+1', 'true', 'America/Anchorage', '3', 'SALES TAX', '104');

INSERT INTO country_info ( mobile_prefix, status, time_zone, country_id, tax_applicable, id)
VALUES ( '+1', 'true', 'America/Honolulu', '3', 'SALES TAX', '105');

INSERT INTO country_info ( mobile_prefix, status, time_zone, country_id, tax_applicable, id)
VALUES ( '+1', 'true', 'America/Los_Angeles', '3', 'SALES TAX', '106');

INSERT INTO country_info ( mobile_prefix, status, time_zone, country_id, tax_applicable, id)
VALUES ( '+1', 'true', 'America/Salt_Lake_City', '3', 'SALES TAX', '107');

INSERT INTO country_info ( mobile_prefix, status, time_zone, country_id, tax_applicable, id)
VALUES ( '+1', 'true', 'America/Chicago', '3', 'SALES TAX', '108');

INSERT INTO country_info ( mobile_prefix, status, time_zone, country_id, tax_applicable, id)
VALUES ( '+44', 'true', 'Europe/London', '4', 'VAT', '109');





INSERT INTO account_type (id, account_type, balance_type, account_number_begin, active) values ('1', 'ASSET', 'DEBIT', '1', 'Y');
INSERT INTO account_type (id, account_type, balance_type, account_number_begin, active ) values ('2', 'LIABILITY', 'CREDIT', '2','Y');
INSERT INTO account_type (id, account_type, balance_type, account_number_begin, active ) values ('3', 'EQUITY', 'CREDIT', '3', 'Y');
INSERT INTO account_type (id, account_type, balance_type, account_number_begin, active ) values ('4', 'INCOME', 'CREDIT', '4', 'Y');
INSERT INTO account_type (id, account_type, balance_type, account_number_begin, active ) values ('5', 'EXPENSE', 'DEBIT', '5', 'Y');
INSERT INTO account_type (id, account_type, balance_type, account_number_begin, active ) values ('6', 'HIDDEN','','6', 'N');

INSERT INTO public.account_group (id, account_type_id, account_group_code ,title, system,allow_new_accounts,checking,at_group,sort_order,active, balance_type,payment_acc, account_list, sub_accounts)
values (1, '1','CASH', 'Cash Only',  '1','1','1', '1','1','Y', 'DEBIT','1','1', '1');
INSERT INTO public.account_group (id, account_type_id, account_group_code ,title, system,allow_new_accounts,checking,at_group,sort_order,active, balance_type,payment_acc, account_list)
values (2, '1','BANK', 'Bank',  '1','1','1', '1','2','Y','DEBIT','1','1');
INSERT INTO public.account_group (id, account_type_id, account_group_code ,title, system,allow_new_accounts,checking,at_group,sort_order,active, balance_type,payment_acc, account_list)
values (3, '1','MIT', 'Money In Transit',  '1','1','1', '1','3','Y','DEBIT','1','1');
INSERT INTO public.account_group (id, account_type_id, account_group_code ,title, system,allow_new_accounts,at_group,sort_order,active, balance_type,expense_txn,income_txn)
values (4, '1','EPC', 'Expected Payments from Customers',  '1','1', '1','4','Y','DEBIT','Y','Y');
INSERT INTO public.account_group (id, account_type_id, account_group_code ,title, system,allow_new_accounts,checking,at_group,sort_order,active, expense_cat, balance_type,payment_acc, account_list,expense_txn,income_txn)
values (5, '1','INV', 'Inventory',  '1','1','1', '1','5','Y','Y','DEBIT','1','1','Y','Y');
INSERT INTO public.account_group (id, account_type_id, account_group_code ,title, system,allow_new_accounts,checking,at_group,sort_order,active, expense_cat, balance_type,payment_acc, account_list,expense_txn,income_txn)
values (6, '1','PPE', 'Property,Plant,Equipment',  '1','1','1', '1','6','Y','Y','DEBIT','1','1','Y','Y');
INSERT INTO public.account_group (id, account_type_id, account_group_code ,title, system,allow_new_accounts,sort_order,active, balance_type,expense_txn,income_txn)
values (7, '1','DEPA', 'Depreciation and Amortization',  '1','1','7','Y','DEBIT','Y','Y');
INSERT INTO public.account_group (id, account_type_id, account_group_code ,title, system,allow_new_accounts,checking,at_group,sort_order,active, expense_cat, balance_type,payment_acc, account_list,expense_txn,income_txn)
values (8, '1','VPVC', 'Supplier Prepayments and Credits',  '1','1','1', '1','8','Y','Y','DEBIT','1','1','Y','Y');
INSERT INTO public.account_group (id, account_type_id, account_group_code ,title, system,allow_new_accounts,checking,at_group,sort_order,active, expense_cat, balance_type,payment_acc, account_list,expense_txn,income_txn, sub_accounts)
values (9, '1','OSTA', 'Other Short-Term Asset',  '1','1','1', '1','9','Y','Y','DEBIT','1','1','Y','Y', '1');
INSERT INTO public.account_group (id, account_type_id, account_group_code ,title, system,allow_new_accounts,checking,at_group,sort_order,active, expense_cat, balance_type,payment_acc, account_list,expense_txn,income_txn, sub_accounts)
values (10, '1','OLTA', 'Other Long-Term Asset',  '1','1','1', '1','10','Y','Y','DEBIT','1','1','Y','Y', '1');

INSERT INTO public.account_group (id, account_type_id, account_group_code ,title, system,allow_new_accounts,checking,at_group,sort_order,active, balance_type,payment_acc, account_list)
values (11, '2','CC', 'Credit Card',  '1','1','1', '1','11','Y','CREDIT','1','1');
INSERT INTO public.account_group (id, account_type_id, account_group_code ,title, system,allow_new_accounts,checking,at_group,sort_order,active, balance_type,payment_acc, account_list)
values (12, '2','LOC', 'Loan and Line of Credit',  '1','1','1', '1','12','Y','CREDIT','1','1');
INSERT INTO public.account_group (id, account_type_id, account_group_code ,title, system,allow_new_accounts,at_group,sort_order,active, expense_cat, balance_type, account_list,expense_txn,income_txn)
values (13, '2','EPS', 'Expected Payments to Suppliers',  '1','1', '1','13','Y','Y','CREDIT','1','Y','Y');
INSERT INTO public.account_group (id, account_type_id, account_group_code ,title, system,sort_order,active, balance_type)
values (14, '2','T', 'Taxes',  '1','14','Y','CREDIT');
INSERT INTO public.account_group (id, account_type_id, account_group_code ,title, system,allow_new_accounts,sort_order,active, expense_cat, balance_type,expense_txn,income_txn)
values (15, '2','DPAY', 'Due for Payroll', '1','1','15','Y','Y','CREDIT','Y','Y');
INSERT INTO public.account_group (id, account_type_id, account_group_code ,title, system,allow_new_accounts,checking,at_group,sort_order,active, expense_cat, balance_type,payment_acc, account_list,expense_txn,income_txn)
values (16, '2','DUE', 'Due to You and Other Business Owners',  '1','1','1', '1','16','Y','Y','CREDIT','1','1','Y','Y');
INSERT INTO public.account_group (id, account_type_id, account_group_code ,title, system,allow_new_accounts,at_group,sort_order,active, balance_type, account_list,expense_txn,income_txn)
values (17, '2','CPCC', 'Customer Prepayments and Customer Credits',  '1','1', '1','17','Y','CREDIT','1','Y','Y');
INSERT INTO public.account_group (id, account_type_id, account_group_code ,title, system,allow_new_accounts,checking,at_group,sort_order,active, expense_cat, balance_type,payment_acc, account_list,expense_txn,income_txn, sub_accounts)
values (18, '2','OSTL', 'Other Short-Term Liability ',  '1','1','1', '1','18','Y','Y','CREDIT','1','1','Y','Y', '1');
INSERT INTO public.account_group (id, account_type_id, account_group_code ,title, system,allow_new_accounts,checking,at_group,sort_order,active, expense_cat, balance_type,payment_acc, account_list,expense_txn,income_txn)
values (19, '2','OLTL', 'Other Long-Term Liability',  '1','1','1', '1','19','Y','Y','CREDIT','1','1','Y','Y');


INSERT INTO public.account_group (id, account_type_id, account_group_code ,title, system,allow_new_accounts,checking,at_group,sort_order,active, expense_cat, balance_type,payment_acc, account_list, sub_accounts)
values (20, '3','BOC', 'Business Owner''s Contribution & Drawing',  '1','1','1', '1','20','Y','Y','CREDIT','1','1', '1');
INSERT INTO public.account_group (id, account_type_id, account_group_code ,title, system,allow_new_accounts,checking,sort_order,active, balance_type,expense_txn,income_txn, sub_accounts)
values (21, '3','RE', 'Retained Earnings: Profit',  '1','1','1','21','Y','CREDIT','Y','Y', '1');


INSERT INTO public.account_group (id, account_type_id, account_group_code ,title, system,allow_new_accounts,checking,sort_order,active, balance_type,income_txn, sub_accounts)
values (22, '4','I', 'Income',  '1','1','1','22','Y','CREDIT','Y', '1');
INSERT INTO public.account_group (id, account_type_id, account_group_code ,title, system,allow_new_accounts,checking,sort_order,active, balance_type,income_txn, sub_accounts)
values (23, '4','D', 'Discounts',  '1','1','1','23','Y','CREDIT','Y', '1');
INSERT INTO public.account_group (id, account_type_id, account_group_code ,title, system,allow_new_accounts,checking,sort_order,active, balance_type,income_txn, sub_accounts)
values (24, '4','OI', 'Other Income','1','1','1','24','Y','CREDIT','Y', '1');
INSERT INTO public.account_group (id, account_type_id, account_group_code ,title, system,allow_new_accounts,sort_order,active, balance_type,income_txn)
values (25, '4','UI', 'Uncategorized Income',  '1','1','25','Y','CREDIT','Y');
INSERT INTO public.account_group (id, account_type_id, account_group_code ,title, system,allow_new_accounts,sort_order,active, balance_type)
values (26, '4','GFX', 'Gain On Foreign Exchange',  '1','1','26','Y','CREDIT');


INSERT INTO public.account_group (id, account_type_id, account_group_code ,title, system,allow_new_accounts,checking,sort_order,active, expense_cat, balance_type,expense_txn, sub_accounts)
values (27, '5','OPE', 'Operating Expenses', '1','1','1','27','Y','Y','DEBIT','Y', '1');
INSERT INTO public.account_group (id, account_type_id, account_group_code ,title, system,allow_new_accounts,checking,sort_order,active, expense_cat, balance_type,expense_txn, sub_accounts)
values (28, '5','COGS', 'Cost of Goods Sold',  '1','1','1','28','Y','Y','DEBIT','Y', '1');
INSERT INTO public.account_group (id, account_type_id, account_group_code ,title, system,allow_new_accounts,checking,sort_order,active, expense_cat, balance_type,expense_txn, sub_accounts)
values (29, '5','PF', 'Fees Paid',  '1','1','1','29','Y','Y','DEBIT','Y', '1');
INSERT INTO public.account_group (id, account_type_id, account_group_code ,title, system,allow_new_accounts,checking,sort_order,active, expense_cat, balance_type,expense_txn, sub_accounts)
values (30, '5','PAYE', 'Payroll Expenses', '1','1','1','30','Y','Y','DEBIT','Y', '1');
INSERT INTO public.account_group (id, account_type_id, account_group_code ,title, system,allow_new_accounts,sort_order,active, balance_type,expense_txn)
values (31, '5','UE', 'Uncategorized Expense',  '1','1','31','Y','DEBIT','Y');
INSERT INTO public.account_group (id, account_type_id, account_group_code ,title, system,allow_new_accounts,sort_order,active, balance_type)
values (32, '5','LFX', 'Loss On Foreign Exchange',  '1','1','32','Y','DEBIT');



INSERT INTO accounts  (id,account_group_id, account_name,balance_type,account_number,system,active, currency_id)
values (1,'1','Cash On Hand','DEBIT','10001','1','Y','1');
INSERT INTO accounts  (id,account_group_id, account_name,balance_type,account_number,system,active,   currency_id)
values (2,'3','Cash In Transit','DEBIT','10010','1','Y','1');
INSERT INTO accounts  (id,account_group_id, account_name,balance_type,account_number,system,active,   currency_id)
values (3,'3','Deposit In Transit','DEBIT','10011','1','Y','1');
INSERT INTO accounts  (id,account_group_id, account_name,balance_type,account_number,system,active, currency_id)
values (4,'3','Payroll Clearing','DEBIT','10012','1','Y','1');
INSERT INTO accounts  (id,account_group_id, account_name,balance_type,account_number,system,active,   currency_id)
values (5,'4','Accounts Receivable','DEBIT','10002','1','Y','1');
INSERT INTO accounts  (id,account_group_id, account_name,balance_type,account_number,system,active, currency_id)
values (6,'8','Supplier Prepayments and Credits','DEBIT','10003','1','Y','1');
INSERT INTO accounts  (id,account_group_id, account_name,balance_type,account_number,system,active,  currency_id)
values (7,'13','Accounts Payable','CREDIT','20001','1','Y','1');
INSERT INTO accounts  (id,account_group_id, account_name,balance_type,account_number,system,active, currency_id)
values (8,'15','Payroll Liabilities','CREDIT','21011','1','Y','1');
INSERT INTO accounts  (id,account_group_id, account_name,balance_type,account_number,system,active, currency_id)
values (9,'17','Customer Prepayments and Credits','CREDIT','21012','1','Y','1');
INSERT INTO accounts  (id,account_group_id, account_name,balance_type,account_number,system,active,   currency_id)
values (10,'20','Owner Investment/Drawings','CREDIT','30001','1','Y','1');
INSERT INTO accounts  (id,account_group_id, account_name,balance_type,account_number,system,active,   currency_id)
values (11,'20','Opening Balance Adjustments','CREDIT','30002','1','Y','1');
INSERT INTO accounts  (id,account_group_id, account_name,balance_type,account_number,system,active,   currency_id)
values (12,'21','Owner''s Equity','CREDIT','30003','1','Y','1');
INSERT INTO accounts  (id,account_group_id, account_name,balance_type,account_number,system,active,   currency_id)
values (13,'22','Sales','CREDIT','40001','1','Y','1');
INSERT INTO accounts  (id,account_group_id, account_name,balance_type,account_number,system,active,   currency_id)
values (14,'22','POS Sales','CREDIT','40002','1','Y','1');
INSERT INTO accounts  (id,account_group_id, account_name,balance_type,account_number,system,active,  currency_id)
values (15,'23','Sales Discount','CREDIT','40011','1','Y','1');
INSERT INTO accounts  (id,account_group_id, account_name,balance_type,account_number,system,active, currency_id)
values (16,'23','Purchase Discount','CREDIT','40012','1','Y','1');
INSERT INTO accounts  (id,account_group_id, account_name,balance_type,account_number,system,active, currency_id)
values (17,'25','Uncategorized Income','CREDIT','40021','1','Y','1');
INSERT INTO accounts  (id,account_group_id, account_name,balance_type,account_number,system,active,   currency_id)
values (18,'26','Gain On Foreign Exchange ','CREDIT','40022','1','Y','1');
INSERT INTO accounts  (id,account_group_id, account_name,balance_type,account_number,system,active,  currency_id)
values (19,'28','Cost of Goods','DEBIT','50001','1','Y','1');
INSERT INTO accounts  (id,account_group_id, account_name,balance_type,account_number,system,active,   currency_id)
values (20,'29','Merchant Account Fees','DEBIT','50011','1','Y','1');
INSERT INTO accounts  (id,account_group_id, account_name,balance_type,account_number,system,active,   currency_id)
values (21,'30','Payroll Employer Taxes','DEBIT','50111','1','Y','1');
INSERT INTO accounts  (id,account_group_id, account_name,balance_type,account_number,system,active,   currency_id)
values (22,'30','Payroll Gross Pay','DEBIT','50112','1','Y','1');
INSERT INTO accounts  (id,account_group_id, account_name,balance_type,account_number,system,active, currency_id)
values (23,'30','Payroll-Employee Benefits','DEBIT','50113','1','Y','1');
INSERT INTO accounts  (id,account_group_id, account_name,balance_type,account_number,system,active, currency_id)
values (24,'30','Payroll - Employer''s Share of Benefits','DEBIT','50114','1','Y','1');
INSERT INTO accounts  (id,account_group_id, account_name,balance_type,account_number,system,active, currency_id)
values (25,'30','Payroll - Salary & Wages','DEBIT','50115','1','Y','1');
INSERT INTO accounts  (id,account_group_id, account_name,balance_type,account_number,system,active, currency_id)
values (26,'31','Uncategorized Expense','DEBIT','51001','1','Y','1');
INSERT INTO accounts  (id,account_group_id, account_name,balance_type,account_number,system,active, currency_id)
values (27,'32','Loss On Foreign Exchange','DEBIT','50022','1','Y','1');





SELECT setval(pg_get_serial_sequence('accounts', 'id'), coalesce(max(id)+1, 1), false) FROM accounts;


insert into payment_terms (id, payment_term, status, description) values ('1', 'Due on Receipt', 'Y', '');
insert into payment_terms (id, payment_term, status, description) values ('2', 'Central Billing', 'Y', '');
insert into payment_terms (id, payment_term, status, description) values ('3', 'Net 7', 'Y', '');
insert into payment_terms (id, payment_term, status, description) values ('4', 'Net 14', 'Y', '');
insert into payment_terms (id, payment_term, status, description) values ('5', 'Net 30', 'Y', '');
insert into payment_terms (id, payment_term, status, description) values ('6', 'Due end of this month', 'Y', '');
insert into payment_terms (id, payment_term, status, description) values ('7', 'Due 7th of next month', 'Y', '');
insert into payment_terms (id, payment_term, status, description) values ('8', 'Due 14th of next month', 'Y', '');
insert into payment_terms (id, payment_term, status, description) values ('9', 'Due end of next month', 'Y', '');


 