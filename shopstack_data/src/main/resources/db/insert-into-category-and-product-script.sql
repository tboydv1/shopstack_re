use shopstack;
SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE table `category`;
SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO `shopstack`.`category`( `category_id`,`category_name`)
VALUES
(17, 'foodrrtd'),
(18,'foodsrwd');


SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE table `ss_product`;
SET FOREIGN_KEY_CHECKS = 1;
INSERT INTO `shopstack`.`ss_product`(`product_code`,`product_name`,`purchase_date`, `category_id`,`price`, `decription`)

VALUES
(9,'beans','2020-12-27', 17, 200, 'food for sale'),
(10,'rice','2020-12-27', 18, 400, 'food for sale');