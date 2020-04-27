/*
 Navicat Premium Data Transfer

 Source Server         : Mysql8_Local_root
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : 127.0.0.1:3306
 Source Schema         : ebank-card

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 29/12/2019 06:34:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_amount
-- ----------------------------
DROP TABLE IF EXISTS `t_amount`;
CREATE TABLE `t_amount` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `card_id` int(11) DEFAULT NULL,
  `currency_id` int(11) DEFAULT NULL,
  `amount_value` double(20,6) DEFAULT NULL,
  `amount_type_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `card_id` (`card_id`),
  KEY `amount_type_fk` (`amount_type_id`),
  KEY `currency_fk` (`currency_id`),
  CONSTRAINT `amount_type_fk` FOREIGN KEY (`amount_type_id`) REFERENCES `t_amount_type` (`id`),
  CONSTRAINT `currency_fk` FOREIGN KEY (`currency_id`) REFERENCES `t_currency` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_amount
-- ----------------------------
BEGIN;
INSERT INTO `t_amount` VALUES (1, 1, 1, 675210.234500, 1, '2019-12-28 22:24:02', '2019-12-28 22:24:02');
INSERT INTO `t_amount` VALUES (2, 1, 2, 23267540.234500, 2, '2019-12-28 22:24:02', '2019-12-28 22:24:02');
INSERT INTO `t_amount` VALUES (3, 2, 1, 232232.000000, 1, '2019-12-28 22:24:02', '2019-12-28 22:24:02');
INSERT INTO `t_amount` VALUES (4, 2, 2, 67540.234500, 2, '2019-12-28 22:24:02', '2019-12-28 22:24:02');
INSERT INTO `t_amount` VALUES (5, 3, 1, 343242.000000, 1, '2019-12-28 22:53:03', '2019-12-28 22:53:03');
INSERT INTO `t_amount` VALUES (6, 4, 1, 67125210.234500, 1, '2019-12-28 22:24:02', '2019-12-28 22:24:02');
INSERT INTO `t_amount` VALUES (7, 5, 1, 995210.234500, 1, '2019-12-28 22:24:02', '2019-12-28 22:24:02');
INSERT INTO `t_amount` VALUES (11, 6, 1, 123143424245.345600, 1, '2019-12-29 06:24:30', '2019-12-29 06:24:30');
COMMIT;

-- ----------------------------
-- Table structure for t_amount_type
-- ----------------------------
DROP TABLE IF EXISTS `t_amount_type`;
CREATE TABLE `t_amount_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `amount_type_name` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_amount_type
-- ----------------------------
BEGIN;
INSERT INTO `t_amount_type` VALUES (1, '余额', '2019-12-28 22:24:02', '2019-12-28 22:24:02');
INSERT INTO `t_amount_type` VALUES (2, '透支', '2019-12-28 22:34:47', '2019-12-28 22:34:47');
INSERT INTO `t_amount_type` VALUES (3, '冻结', '2019-12-28 22:36:06', '2019-12-28 22:36:06');
COMMIT;

-- ----------------------------
-- Table structure for t_card
-- ----------------------------
DROP TABLE IF EXISTS `t_card`;
CREATE TABLE `t_card` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `card_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_id` int(11) NOT NULL,
  `card_type_code` int(11) NOT NULL,
  `product_code` int(11) NOT NULL,
  `pin_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `cvv2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT 'Y' COMMENT '''Y''-激活，''N''-未激活，''D''-已删除',
  `exprie_time` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `card_tpye_fk` (`card_type_code`),
  KEY `product_type_fk` (`product_code`),
  CONSTRAINT `amount_fk` FOREIGN KEY (`id`) REFERENCES `t_amount` (`card_id`),
  CONSTRAINT `card_tpye_fk` FOREIGN KEY (`card_type_code`) REFERENCES `t_card_type` (`id`),
  CONSTRAINT `product_type_fk` FOREIGN KEY (`product_code`) REFERENCES `t_product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_card
-- ----------------------------
BEGIN;
INSERT INTO `t_card` VALUES (1, '8888888888888888', 1, 1, 1, '1234', '123', 'Y', '2050-12-28 21:44:51', '2019-12-28 21:24:30', '2019-12-28 21:24:30');
INSERT INTO `t_card` VALUES (2, '8888888888886666', 1, 2, 2, '1234', '123', 'Y', '2050-12-28 21:44:51', '2019-12-28 21:24:30', '2019-12-28 21:24:30');
INSERT INTO `t_card` VALUES (3, '9999999999999999', 1, 3, 3, '1234', '123', 'Y', '2050-12-28 21:44:51', '2019-12-28 21:50:50', '2019-12-28 21:50:50');
INSERT INTO `t_card` VALUES (4, '8888888888888812', 1, 4, 2, '1234', '123', 'Y', '2050-12-28 21:44:51', '2019-12-28 21:24:30', '2019-12-28 21:24:30');
INSERT INTO `t_card` VALUES (5, '9999999999990143', 1, 3, 3, '1234', '123', 'Y', '2050-12-28 21:44:51', '2019-12-28 21:50:50', '2019-12-28 21:50:50');
INSERT INTO `t_card` VALUES (6, '1234567895678436', 2, 1, 1, '1234', '123', 'Y', '2050-12-28 21:44:51', '2019-12-29 06:25:16', '2019-12-29 06:25:16');
COMMIT;

-- ----------------------------
-- Table structure for t_card_type
-- ----------------------------
DROP TABLE IF EXISTS `t_card_type`;
CREATE TABLE `t_card_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `card_type_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_card_type
-- ----------------------------
BEGIN;
INSERT INTO `t_card_type` VALUES (1, '储蓄卡', '2019-12-28 21:27:40', '2019-12-28 21:27:40');
INSERT INTO `t_card_type` VALUES (2, '信用卡', '2019-12-28 21:29:45', '2019-12-28 21:29:45');
INSERT INTO `t_card_type` VALUES (3, '贷款', '2019-12-28 21:42:08', '2019-12-28 21:42:08');
INSERT INTO `t_card_type` VALUES (4, '保险', '2019-12-28 21:49:15', '2019-12-28 21:49:15');
COMMIT;

-- ----------------------------
-- Table structure for t_currency
-- ----------------------------
DROP TABLE IF EXISTS `t_currency`;
CREATE TABLE `t_currency` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `currency_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_currency
-- ----------------------------
BEGIN;
INSERT INTO `t_currency` VALUES (1, 'CNY', '2019-12-28 22:24:02', '2019-12-28 22:24:02');
INSERT INTO `t_currency` VALUES (2, 'TWD', '2019-12-28 22:34:47', '2019-12-28 22:34:47');
INSERT INTO `t_currency` VALUES (3, 'USD', '2019-12-28 22:36:06', '2019-12-28 22:36:06');
COMMIT;

-- ----------------------------
-- Table structure for t_product
-- ----------------------------
DROP TABLE IF EXISTS `t_product`;
CREATE TABLE `t_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_type_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_product
-- ----------------------------
BEGIN;
INSERT INTO `t_product` VALUES (1, '智慧理财卡', '2019-12-28 21:27:40', '2019-12-28 21:27:40');
INSERT INTO `t_product` VALUES (2, '王者荣耀卡', '2019-12-28 21:29:45', '2019-12-28 21:29:45');
INSERT INTO `t_product` VALUES (3, '健康绿色卡', '2019-12-28 21:42:08', '2019-12-28 21:42:08');
INSERT INTO `t_product` VALUES (4, '人寿理财卡', '2019-12-28 21:51:32', '2019-12-28 21:51:32');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
