/*
 Navicat Premium Data Transfer

 Source Server         : Mysql8_Local_root
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : 127.0.0.1:3306
 Source Schema         : ebank-user

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 29/12/2019 06:35:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `birthday` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `mobile_phone` varchar(255) NOT NULL,
  `tel_phone` varchar(255) DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `sex` char(1) DEFAULT 'S' COMMENT '''F''-女，''M''-男，''S''-保密',
  `status` char(1) DEFAULT 'Y' COMMENT '''Y''-激活，''N''-未激活，''D''-已删除',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
BEGIN;
INSERT INTO `t_user` VALUES (1, 'admin', '123456', 'admin', '1994-02-16', '安徽省滁州市', '18755065854', '8621-28960335', '2212925883@qq.com', 'M', 'Y', '2019-12-20 14:40:36', '2019-12-20 14:40:36');
INSERT INTO `t_user` VALUES (2, 'hexu', '123456', 'hexu', '1994-02-16', '安徽省滁州市', '18755065854', '8621-28960335', '2212925883@qq.com', 'M', 'Y', '2019-12-20 14:40:36', '2019-12-20 14:40:36');
INSERT INTO `t_user` VALUES (3, 'test', '123456', 'test', '1994-02-16', '安徽省滁州市', '18755065854', '8621-28960335', '2212925883@qq.com', 'F', 'Y', '2019-12-20 14:40:36', '2019-12-20 14:40:36');
COMMIT;

-- ----------------------------
-- Table structure for t_user_log
-- ----------------------------
DROP TABLE IF EXISTS `t_user_log`;
CREATE TABLE `t_user_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `opt_time` datetime DEFAULT NULL COMMENT '操作时间',
  `session_id` varchar(255) DEFAULT NULL COMMENT '用户sessionId',
  `ip` varchar(255) DEFAULT NULL,
  `action` varchar(255) DEFAULT NULL COMMENT '操作',
  `method` varchar(255) DEFAULT NULL COMMENT '访问的方法',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '数据库创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=391 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_log
-- ----------------------------
BEGIN;
INSERT INTO `t_user_log` VALUES (355, 'a2d55dab-c862-498c-b723-b86ca2a17a1a', '2019-12-28 04:17:24', 'EB6C548C72DAE9338BB22643975C81D7', '0:0:0:0:0:0:0:1', 'class com.hexu.ebank.user.controller.TUserController', 'selectByUsername', '2019-12-28 04:17:24');
INSERT INTO `t_user_log` VALUES (356, '91932469-5897-4f12-b08c-f2b7f36475bc', '2019-12-28 04:20:48', '9B9097B1DF0FF60B8BFD4C6B1C06B6C1', '0:0:0:0:0:0:0:1', 'class com.hexu.ebank.user.controller.TUserController', 'selectByUsername', '2019-12-28 04:20:48');
INSERT INTO `t_user_log` VALUES (357, 'a8642e1e-a137-4667-9727-7c738f26f16b', '2019-12-28 04:41:32', '38442EE93CB75721082B389EFDD84CFE', '192.168.1.5', 'class com.hexu.ebank.user.controller.TUserController', 'selectByPrimaryKey', '2019-12-28 04:41:33');
INSERT INTO `t_user_log` VALUES (358, '18a26deb-06d7-465e-ba6e-033b66e3536d', '2019-12-28 04:54:34', 'A1956CACA4500CF4053A4564C55C6421', '0:0:0:0:0:0:0:1', 'class com.hexu.ebank.user.controller.TUserController', 'selectAll', '2019-12-28 04:54:34');
INSERT INTO `t_user_log` VALUES (359, 'fd493d1e-139a-4f57-b663-1fd8e85612d3', '2019-12-28 05:10:20', '8C6E5AE5025DC3E1AF506DF30A939280', '192.168.1.5', 'class com.hexu.ebank.user.controller.TUserController', 'selectAll', '2019-12-28 05:10:20');
INSERT INTO `t_user_log` VALUES (360, 'b068db9c-8021-4330-b284-9730a51396d2', '2019-12-28 05:28:18', 'A86C6EA6728414B434CB25E9BE5E76A2', '0:0:0:0:0:0:0:1', 'class com.hexu.ebank.user.controller.TUserController', 'selectAll', '2019-12-28 05:28:18');
INSERT INTO `t_user_log` VALUES (361, 'c20148b9-e200-4ae7-9896-068ae2c8bbae', '2019-12-28 10:38:33', 'FA6548E92756C894DE39739553ECC9DB', '192.168.1.5', 'class com.hexu.ebank.user.controller.InstanceStatusController', 'defaultPage', '2019-12-28 10:38:33');
INSERT INTO `t_user_log` VALUES (362, '213891ce-d7e8-46f4-ba07-f5d1e7edfbf3', '2019-12-28 10:39:18', 'FA6548E92756C894DE39739553ECC9DB', '192.168.1.5', 'class com.hexu.ebank.user.controller.InstanceStatusController', 'defaultPage', '2019-12-28 10:39:18');
INSERT INTO `t_user_log` VALUES (363, '06dd88f2-e795-40da-b9fc-a82f887abc7f', '2019-12-28 10:44:01', '11388CF53358296256C17CDBCE8F26B4', '192.168.1.5', 'class com.hexu.ebank.user.controller.InstanceStatusController', 'defaultPage', '2019-12-28 10:44:01');
INSERT INTO `t_user_log` VALUES (364, '51a81ede-1ef0-45c1-92e3-64a95fdc5444', '2019-12-28 10:45:38', '11388CF53358296256C17CDBCE8F26B4', '192.168.1.5', 'class com.hexu.ebank.user.controller.InstanceStatusController', 'defaultPage', '2019-12-28 10:45:38');
INSERT INTO `t_user_log` VALUES (365, '2c82d232-5b39-4e7c-b9a0-fd2aff7e40ba', '2019-12-28 11:27:41', '564C5E1E2886446536B884EAC0314A90', '192.168.1.5', 'class com.hexu.ebank.user.controller.InstanceStatusController', 'defaultPage', '2019-12-28 11:27:41');
INSERT INTO `t_user_log` VALUES (366, 'f1a4df14-07b2-4b6c-a096-21f3531113c4', '2019-12-28 11:28:15', '564C5E1E2886446536B884EAC0314A90', '192.168.1.5', 'class com.hexu.ebank.user.controller.InstanceStatusController', 'defaultPage', '2019-12-28 11:28:15');
INSERT INTO `t_user_log` VALUES (367, '4e61aeb4-fe26-468c-b580-0a75ae07f06c', '2019-12-28 11:48:51', 'F2B0A30F7A0AEF378B2BE30FC5304969', '192.168.1.5', 'class com.hexu.ebank.user.controller.InstanceStatusController', 'defaultPage', '2019-12-28 11:48:51');
INSERT INTO `t_user_log` VALUES (368, 'b9982753-415f-4fc4-b9d5-b8d0485f74ab', '2019-12-28 11:53:35', 'F2B0A30F7A0AEF378B2BE30FC5304969', '192.168.1.5', 'class com.hexu.ebank.user.controller.InstanceStatusController', 'defaultPage', '2019-12-28 11:53:35');
INSERT INTO `t_user_log` VALUES (369, '1aaca508-386a-408b-b3ac-8b0b7ecafdf6', '2019-12-28 11:53:35', 'F2B0A30F7A0AEF378B2BE30FC5304969', '192.168.1.5', 'class com.hexu.ebank.user.controller.InstanceStatusController', 'defaultPage', '2019-12-28 11:53:35');
INSERT INTO `t_user_log` VALUES (370, 'ceb88b34-bdf3-4554-9567-6d4cc50963e4', '2019-12-28 11:53:58', 'F2B0A30F7A0AEF378B2BE30FC5304969', '192.168.1.5', 'class com.hexu.ebank.user.controller.InstanceStatusController', 'defaultPage', '2019-12-28 11:53:58');
INSERT INTO `t_user_log` VALUES (371, '2a238be0-f334-48e1-94d0-376d4062b852', '2019-12-28 12:14:04', 'C7C9CBC686377F273A4314653EE4BC57', '192.168.1.5', 'class com.hexu.ebank.user.controller.InstanceStatusController', 'defaultPage', '2019-12-28 12:14:04');
INSERT INTO `t_user_log` VALUES (372, '94f3bc47-aade-4673-bbab-6902882a14d3', '2019-12-28 12:15:38', '8C9AB3DAD872F91DA346C7BDCBBF7C3C', '0:0:0:0:0:0:0:1', 'class com.hexu.ebank.user.controller.TUserBaseController', 'selectAll', '2019-12-28 12:15:38');
INSERT INTO `t_user_log` VALUES (373, 'd2b19c98-4cd5-4349-8c1e-cd93223040d2', '2019-12-28 12:32:58', 'FD18F97ED1BAF4C16954B198041ED33F', '0:0:0:0:0:0:0:1', 'class com.hexu.ebank.user.controller.TUserBaseController', 'selectByPrimaryKey', '2019-12-28 12:32:58');
INSERT INTO `t_user_log` VALUES (374, '6df0330c-98f0-4e0e-9b24-7338e8c6214f', '2019-12-28 13:00:54', '694873A9D81A7FF7D88B307D6D46DA21', '0:0:0:0:0:0:0:1', 'class com.hexu.ebank.user.controller.TUserBaseController', 'selectAll', '2019-12-28 13:00:54');
INSERT INTO `t_user_log` VALUES (375, '5a74898d-b9c8-4333-88a8-4aaba6c19717', '2019-12-28 13:29:54', 'BF185C5BF5FDEC7FEFB272F7EFA4D5C6', '0:0:0:0:0:0:0:1', 'class com.hexu.ebank.user.controller.TUserBaseController', 'selectAll', '2019-12-28 13:29:54');
INSERT INTO `t_user_log` VALUES (376, 'cef4b48f-9650-41d6-8da1-906a2122a752', '2019-12-28 13:33:59', '6272DFD2E8E7B64DE0404065775B6C7D', '192.168.1.5', 'class com.hexu.ebank.user.controller.InstanceStatusController', 'defaultPage', '2019-12-28 13:33:59');
INSERT INTO `t_user_log` VALUES (377, 'ab2f8885-4d36-417d-b9da-9befc31ee65c', '2019-12-28 13:37:23', '3E65A7B6B07A1311D4329C10AEE3DD18', '192.168.1.5', 'class com.hexu.ebank.user.controller.InstanceStatusController', 'defaultPage', '2019-12-28 13:37:23');
INSERT INTO `t_user_log` VALUES (378, 'd0bcfbb6-a1f0-4930-b5dd-3624099da51a', '2019-12-28 13:37:25', '3E65A7B6B07A1311D4329C10AEE3DD18', '192.168.1.5', 'class com.hexu.ebank.user.controller.InstanceStatusController', 'defaultPage', '2019-12-28 13:37:25');
INSERT INTO `t_user_log` VALUES (379, '5af74703-5b45-4c4f-95c4-09c87666df44', '2019-12-28 13:44:05', '5BF2CE9890C44E9A080B20B6E3B965E0', '0:0:0:0:0:0:0:1', 'class com.hexu.ebank.user.controller.TUserController', 'login1', '2019-12-28 13:44:05');
INSERT INTO `t_user_log` VALUES (380, '1c65a171-dd5c-4c4c-ae95-7316eaec28f8', '2019-12-28 13:44:20', 'B6611DD2A42B7F6D79EDE5F21FE44844', '192.168.1.5', 'class com.hexu.ebank.user.controller.InstanceStatusController', 'defaultPage', '2019-12-28 13:44:20');
INSERT INTO `t_user_log` VALUES (381, '2c25946b-1655-44ca-af45-6460017be74b', '2019-12-28 13:44:36', 'D06386AD77FD22AF779AA523662C5B68', '0:0:0:0:0:0:0:1', 'class com.hexu.ebank.user.controller.TUserController', 'login1', '2019-12-28 13:44:36');
INSERT INTO `t_user_log` VALUES (382, 'dc94a13c-1504-4af7-9e82-b724221eadac', '2019-12-28 13:45:19', 'D06386AD77FD22AF779AA523662C5B68', '0:0:0:0:0:0:0:1', 'class com.hexu.ebank.user.controller.TUserController', 'login', '2019-12-28 13:45:19');
INSERT INTO `t_user_log` VALUES (383, 'd43d28f0-46b1-48f4-917c-3912e745d552', '2019-12-28 13:47:04', 'B09A5AD26E8B6823D3035A3DD9AA4FAA', '0:0:0:0:0:0:0:1', 'class com.hexu.ebank.user.controller.TUserController', 'login', '2019-12-28 13:47:04');
INSERT INTO `t_user_log` VALUES (384, '4ee57d7f-0494-42bf-82de-765c52c52c02', '2019-12-28 13:49:16', 'D61B327A02C075628E72693BC4FBBF4D', '0:0:0:0:0:0:0:1', 'class com.hexu.ebank.user.controller.TUserController', 'login', '2019-12-28 13:49:16');
INSERT INTO `t_user_log` VALUES (385, '698c02e2-32dd-4f44-bb6d-10559f68ecf6', '2019-12-28 13:49:18', '3EA1B71A38DACAEB237734C213992444', '0:0:0:0:0:0:0:1', 'class com.hexu.ebank.user.controller.TUserController', 'login', '2019-12-28 13:49:18');
INSERT INTO `t_user_log` VALUES (386, '8fc70217-3e46-48df-88e6-432812fac2dd', '2019-12-28 13:49:19', '92A764868F2212910209AF5FB7F7B6A2', '0:0:0:0:0:0:0:1', 'class com.hexu.ebank.user.controller.TUserController', 'login', '2019-12-28 13:49:19');
INSERT INTO `t_user_log` VALUES (387, '373221f0-c52c-48f9-a4c4-f146d8ae2aef', '2019-12-28 13:49:45', '39418E43E1D53E010B2B0DCC3F6006DF', '0:0:0:0:0:0:0:1', 'class com.hexu.ebank.user.controller.TUserController', 'login1', '2019-12-28 13:49:45');
INSERT INTO `t_user_log` VALUES (388, 'e8654adc-b1ec-4f48-a0c0-a32c162d86fb', '2019-12-28 13:56:44', 'AFB799479271F0145BBE97A634756A99', '0:0:0:0:0:0:0:1', 'class com.hexu.ebank.user.controller.TUserController', 'login1', '2019-12-28 13:56:44');
INSERT INTO `t_user_log` VALUES (389, '4ab91ebe-718f-40b4-813a-899389810fc2', '2019-12-28 13:57:17', 'AFB799479271F0145BBE97A634756A99', '0:0:0:0:0:0:0:1', 'class com.hexu.ebank.user.controller.TUserController', 'login', '2019-12-28 13:57:17');
INSERT INTO `t_user_log` VALUES (390, '9bddea9e-e04f-4087-8244-bfe2206b243a', '2019-12-28 15:59:58', '26033CD4B53FB305E2BC5720BF9C72B7', '192.168.1.5', 'class com.hexu.ebank.user.controller.InstanceStatusController', 'defaultPage', '2019-12-28 15:59:58');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
