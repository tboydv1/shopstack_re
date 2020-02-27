use shopstack;
SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE table `ss_product`;
SET FOREIGN_KEY_CHECKS = 1;
INSERT INTO `shopstack`.`ss_product`(`product_code`,`product_name`,`purchase_date`, `category_id`,`price`, `decription`)

VALUES
(1,'ps3 gaming console','2020-12-27', 12, 200, 'for playing games'),
(2,'samsung s10','2020-12-27', 6, 53000, 'mobile device for daily use');