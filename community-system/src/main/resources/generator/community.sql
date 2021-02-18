/*
 Navicat Premium Data Transfer

 Source Server         : localMysql
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : localhost:3306
 Source Schema         : community

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 18/02/2021 17:59:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `role` int(11) NULL DEFAULT NULL,
  `tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `creatTime` datetime(0) NULL DEFAULT NULL,
  `certificate_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '', 'zxl', '1998zhang', 2, '17371531640', '1710643798@qq.com', '2021-02-08 16:02:57', '421281199811052330');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `id` int(11) NOT NULL,
  `uid` int(11) NULL DEFAULT NULL,
  `role` int(11) NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `position` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `joinTime` datetime(0) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Procedure structure for insert_emp
-- ----------------------------
DROP PROCEDURE IF EXISTS `insert_emp`;
delimiter ;;
CREATE PROCEDURE `insert_emp`(in start int(10),in max_num int(10))
begin
 declare i int default 0;
 /*把autocommit设置成0*/
 set autocommit= 0;
 repeat
 set i=i+1;
 insert into resident(name,age,gender,address,phonenumber)
 values(rand_string(6),(START+i),'男',rand_string(6),rand_num());
 until i=max_num end repeat;
commit;
end
;;
delimiter ;

-- ----------------------------
-- Function structure for rand_num
-- ----------------------------
DROP FUNCTION IF EXISTS `rand_num`;
delimiter ;;
CREATE FUNCTION `rand_num`()
 RETURNS int(5)
begin
   declare i int default 0;
   set i=floor(100+rand()*10);
 return i;
 end
;;
delimiter ;

-- ----------------------------
-- Function structure for rand_string
-- ----------------------------
DROP FUNCTION IF EXISTS `rand_string`;
delimiter ;;
CREATE FUNCTION `rand_string`(n int)
 RETURNS varchar(255) CHARSET utf8
begin
   declare chars_str varchar(100) default 'qwertyuiopasdfghjklzxcvbnm';
   declare return_str varchar(255) default '';
   declare i int default 0;
   while i<n do
   set return_str=concat(return_str,substring(chars_str,floor(1+rand()*52),1));
   set i=i+1;
   end while;
   return return_str;
 end
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
