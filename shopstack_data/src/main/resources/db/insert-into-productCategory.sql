use shopstack;
SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE table `category`;
SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO `shopstack`.`category`( `category_id`,`category_name`)
VALUES
(1,'Automotive & Powersports'),
(2,'Baby Products (Excluding Apparel)'),
(3,'Beauty'),
(4,'Books'),
(5,'Business Products (B2B)'),
(6,'Cell Phones'),
(7,'Clothing & Accessories'),
(8,'Electronics (Accessories)'),
(9,'Office Products'),
(10,'Shoes, Handbags & Sunglasses'),
(11,'Tools & Home Improvement'),
(12,'Video Games & Video Game Consoles');