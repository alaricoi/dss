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