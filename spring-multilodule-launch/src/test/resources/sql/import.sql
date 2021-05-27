/******
Load Initial Data Manually for testing
**********/


INSERT INTO `phaseminus_example`.`appointment` (`id`, `timel`) VALUES ('1', '1212');
INSERT INTO `phaseminus_example`.`appointment` (`id`, `timel`) VALUES ('2', '1111');
INSERT INTO `phaseminus_example`.`patient` (`id`, `address`, `name`, `phone`) VALUES ('1', 'Dhaka', 'Golam', '12345');



roles table

INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');
