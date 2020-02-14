use shopstack;

SET FOREIGN_KEY_CHECKS = 0; 
TRUNCATE table business_services; 
truncate table business_category;
SET FOREIGN_KEY_CHECKS = 1;




INSERT INTO `shopstack`.`business_category`(`biz_category_name`)
VALUES
('Patnership'),
('Private limited company'),
('Charity or association'),
('Company'),
('Sole Trader');


INSERT INTO `shopstack`.`business_services`(`biz_service_name`)
VALUES
('Accomodation and Food Services'),
('Administrative and Support Services'),
('Arts and Recreation Services'),
('Constructor/Builder'),
('Education and Training'),
('Financial services & insurance'),
('Manufacturing'),
('Medical/ Health Care / Community services'),
('Personal, Beauty, Wellbeing and other services'),
('Professional Services(e.g, Legal Accounting, Marketing, Consulting'),
('Property Operators and Real Estate services'),
('Legal, Accounting, Marketing, Consulting'),
('Rental & Hiring services'),
('Repair and Maintenance'),
('Retail Trade {Food and Beverage}'),
('Retail Trade @ Ecommerce{Non Food}'),
('Wholesale Trade'),
('Technology/Telecommunication services'),
('Transport, Logistics, Postal, Warehousing'),
('Trade work(eg. Plumber, Carpenter, Electician)');
