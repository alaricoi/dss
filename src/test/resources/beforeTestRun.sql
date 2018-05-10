/*
-- Query: SELECT * FROM pelis.app_user
LIMIT 0, 1000

-- Date: 2018-05-07 22:32
*/
INSERT INTO `app_user` (`id`,`sso_id`,`password`,`first_name`,`last_name`,`email`,`state`) VALUES (1,'bill','abc123','Bill','Watcher','bill@xyz.com','Active');
INSERT INTO `app_user` (`id`,`sso_id`,`password`,`first_name`,`last_name`,`email`,`state`) VALUES (2,'danny','abc124','Danny','Theys','danny@xyz.com','Active');
INSERT INTO `app_user` (`id`,`sso_id`,`password`,`first_name`,`last_name`,`email`,`state`) VALUES (3,'sam','abc125','Sam','Smith','samy@xyz.com','Active');
INSERT INTO `app_user` (`id`,`sso_id`,`password`,`first_name`,`last_name`,`email`,`state`) VALUES (4,'nicole','abc126','Nicole','warner','nicloe@xyz.com','Active');
INSERT INTO `app_user` (`id`,`sso_id`,`password`,`first_name`,`last_name`,`email`,`state`) VALUES (5,'kenny','abc127','Kenny','Roger','kenny@xyz.com','Active');
INSERT INTO `app_user` (`id`,`sso_id`,`password`,`first_name`,`last_name`,`email`,`state`) VALUES (6,'isma','isma','isma','calvo','kenny@xyz.com','Active');
/*
-- Query: SELECT * FROM pelis.user_profile
LIMIT 0, 1000

-- Date: 2018-05-07 22:33
*/
INSERT INTO `user_profile` (`id`,`type`) VALUES (2,'ADMIN');
INSERT INTO `user_profile` (`id`,`type`) VALUES (1,'USER');
/*
-- Query: SELECT * FROM pelis.app_user_user_profile
LIMIT 0, 1000

-- Date: 2018-05-07 22:33
*/
INSERT INTO `app_user_user_profile` (`user_id`,`user_profile_id`) VALUES (1,1);
INSERT INTO `app_user_user_profile` (`user_id`,`user_profile_id`) VALUES (2,1);
INSERT INTO `app_user_user_profile` (`user_id`,`user_profile_id`) VALUES (5,1);
INSERT INTO `app_user_user_profile` (`user_id`,`user_profile_id`) VALUES (6,1);
INSERT INTO `app_user_user_profile` (`user_id`,`user_profile_id`) VALUES (3,2);
INSERT INTO `app_user_user_profile` (`user_id`,`user_profile_id`) VALUES (4,2);
INSERT INTO `app_user_user_profile` (`user_id`,`user_profile_id`) VALUES (5,2);
INSERT INTO `app_user_user_profile` (`user_id`,`user_profile_id`) VALUES (6,2);

INSERT INTO `generos` (`ID_GENERO`, `DS_GENERO`) VALUES
(345, 'Comedia'),
(347, 'Misterio'),
(350, 'Fantasía'),
(351, 'SI-FI'),
(353, 'Romatica'),
(354, 'Historica'),
(355, 'Policiaca'),
(407, 'Drama');

INSERT INTO `titulos` (`ID_TITULO`, `DS_TITULO`, `ID_GENERO`, `TL_REPARTO`, `TL_SINOPSIS`, `DS_DIRECTOR`, `NM_ANYO`) VALUES
(111, 'Prueba1', 350, 'Prueba de reparto', 'Prueba de sinopsis', 'director', 2017),
(112, 'Prueba1', 351, 'Prueba de reparto', 'Prueba de sinopsis', 'director', 2017),
(114, 'Prueba1', 353, NULL, NULL, 'director', NULL),
(115, 'Otra prueba', 354, NULL, NULL, 'director', NULL),
(116, 'Prueba1', 355, NULL, NULL, 'director', NULL),
(280, 'ffff', 355, 'ffffffff', 'fffffffffffffffffff', 'director', 2018),
(290, 'ffff', 355, NULL, NULL, 'director', NULL),
(291, 'fff', 355, NULL, NULL, 'director', NULL),
(292, 'fff', 355, NULL, NULL, 'director', NULL),
(293, 'fff', 355, NULL, NULL, 'director', NULL),
(294, 'ffff', 355, NULL, NULL, 'director', NULL),
(295, 'fff', 355, NULL, NULL, 'director', NULL),
(296, 'ffffffffff', 355, NULL, NULL, 'director', NULL),
(297, 'fffffffffffff', 355, NULL, NULL, 'director', NULL),
(298, 'fffff', 355, NULL, NULL, 'director', NULL);



INSERT INTO `opiniones` (`ID_OPINION`, `ID_TITULO`, `app_user_id`, `TL_OPINION`, `NM_OPINION`, `FC_ALTA`) VALUES
(4, 111, 1, 'Prueba de opnion', 1, sysdate),
(5, 112, 1, 'Prueba de opnion', 1, sysdate),
(6, 111, 1, 'Prueba de opnion', 1, sysdate);