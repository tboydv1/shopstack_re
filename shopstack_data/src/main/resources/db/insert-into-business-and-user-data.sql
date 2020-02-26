use shopstack;

SET FOREIGN_KEY_CHECKS = 0; 
TRUNCATE table ss_user; 
truncate table user_roles;
TRUNCATE table business_category;
TRUNCATE table business_services;
TRUNCATE table ss_business;
TRUNCATE table ss_business_outlet;
SET FOREIGN_KEY_CHECKS = 1;


INSERT INTO `shopstack`.`ss_user`(`ss_user_id`,`ss_first_name`, `ss_last_name`, `ss_email`, `ss_phone_number`, `ss_password`, `ss_enabled`, `ss_status`, `ss_token`)
VALUES
(1,'John', 'Ray', 'ray@mail.com', 070674673684,'{noop}test@123', 1, 'ACTIVE', 'testtoken1'),
(2,'Tolani', 'Dada', 'tolani@mail.com', 070674673684,'{noop}test@123', 1, 'ACTIVE', 'testtoken2'),
(3,'Lemon', 'Brown', 'lemon@mail.com', 070674673684,'{noop}test@123', 1,'ACTIVE', 'testtoken3'),
(4,'Tobi', 'Tosho', 'tosho@mail.com', 070674673684,'{noop}test@123', 1,'ACTIVE', 'testtoken4'),
(5,'Bisi', 'Tokunbo', 'bisi@mail.com', 070674673684,'{noop}test@123', 1,'ACTIVE', 'testtoken5'),
(6,'Carl', 'Grey', 'carl@mail.com', 070674673684,'{noop}test@123', 1,'ACTIVE' ,'testtoken6'),
(7,'Kayode', 'Tope', 'kay@mail.com', 070674673684,'{noop}test@123', 1, 'ACTIVE', 'testtoken7');

INSERT INTO `shopstack`.`user_roles`(`role_id`,`role_name`,`ss_user_email`)
VALUES
(1,'ROLE_USER' , 'ray@mail.com'),
(2,'ROLE_USER' , 'tolani@mail.com'),
(3,'ROLE_USER' ,  'lemon@mail.com'),
(4,'ROLE_USER' ,  'tosho@mail.com'),
(5,'ROLE_USER' , 'bisi@mail.com'),
(6,'ROLE_USER' , 'carl@mail.com'),
(7,'ROLE_USER' , 'kay@mail.com');


INSERT INTO `shopstack`.`business_category`(`biz_category_id`,`biz_category_name`)
VALUES
(1,'Patnership'),
(2,'Private limited company'),
(3,'Charity or association'),
(4,'Company'),
(5,'Sole Trader');


INSERT INTO `shopstack`.`business_services`(`biz_service_id`,`biz_service_name`)
VALUES
(5,'Accomodation and Food Services'),
(6,'Administrative and Support Services'),
(7,'Arts and Recreation Services'),
(8,'Constructor/Builder'),
(9,'Education and Training'),
(10,'Financial services & insurance'),
(11,'Manufacturing'),
(12,'Medical/ Health Care / Community services'),
(13,'Personal, Beauty, Wellbeing and other services'),
(14,'Professional Services(e.g, Legal Accounting, Marketing, Consulting'),
(15,'Property Operators and Real Estate services'),
(16,'Legal, Accounting, Marketing, Consulting'),
(17,'Rental & Hiring services'),
(18,'Repair and Maintenance'),
(19,'Retail Trade {Food and Beverage}'),
(20,'Retail Trade @ Ecommerce{Non Food}'),
(21,'Wholesale Trade'),
(22,'Technology/Telecommunication services'),
(23,'Transport, Logistics, Postal, Warehousing'),
(24,'Trade work(eg. Plumber, Carpenter, Electician)');

INSERT INTO `shopstack`.`ss_business`(`biz_id`,`biz_name`,`biz_email`, `biz_category_id`, `biz_service_id`, `biz_creator`)

VALUES
(1,'Backery Hub','bakers@mail.com', 4,19, 6),
(3,'Dry Cleaners Hub', 'cleaners@mail.com',4, 24, 7),
(4,'Fashion Design Hub', 'designers@mail.com',4,13, 7),
(5,'Mini Marketers', 'mini-market@mail.com',4, 20, 7);



INSERT INTO `shopstack`.`ss_business_outlet`(`ss_business_outlet_id`, `ss_outlet_display_name`, 
`location`, `ss_business_biz_id`)
VALUES
(7, 'shopify_yaba', '312 semicolon yaba', 1),
(5, 'shopify_yaba', '312 semicolon yaba', 3),
(8, 'shopify_yaba', '312 semicolon yaba', 3),
(9, 'shopify_yaba', '312 semicolon yaba', 4),
(10, 'shopify_yaba', '312 semicolon yaba', 4);



