use shopstack;

SET FOREIGN_KEY_CHECKS = 0; 
TRUNCATE table ss_user; 
truncate table user_roles;
SET FOREIGN_KEY_CHECKS = 1;
use shopstack;

SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE table ss_user;
truncate table user_roles;
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


