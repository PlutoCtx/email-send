/*
 Navicat Premium Data Transfer

 Source Server         : testmmysql
 Source Server Type    : MySQL
 Source Server Version : 100605
 Source Host           : localhost:3306
 Source Schema         : email

 Target Server Type    : MySQL
 Target Server Version : 100605
 File Encoding         : 65001

 Date: 04/07/2023 20:51:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id，主键',
  `email` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '邮箱',
  `password` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '密码',
  `salt` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '盐',
  `confirm_code` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '确认码',
  `activation_time` datetime(0) NULL DEFAULT NULL COMMENT '激活失效时间',
  `is_valid` tinyint(1) NULL DEFAULT NULL COMMENT '是否可用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (6, '2013299721@qq.com', 'b5abf7fbaff235fc9d4f2ecc2ffbfcff', 'e8xmsr', '1614136487857754112', '2023-01-15 13:45:38', 0);
INSERT INTO `user` VALUES (7, 'chenmochen1954@163.com', 'a73b96d8f16b6716293bc0ca4f1f313c', 'dpyhne', '1614137193914306560', '2023-01-15 13:47:52', 0);
INSERT INTO `user` VALUES (12, 'ctx195467@163.com', '9128384eeda32a9ebdfa7ac8ea5e063f', 'jcf1xl', '1614173471733059584', '2023-01-15 16:12:00', 1);
INSERT INTO `user` VALUES (20, 'chentingxian195467@163.com', 'b909020ac1c753742d5d5c6a6d14c147', '47xxrx', '1630094721412108288', '2023-02-28 14:37:21', 0);
INSERT INTO `user` VALUES (21, '15905898514@163.com', 'f40f30cbe33007508bc3ba0a5e274618', 'iestlb', '1676211427796455424', '2023-07-05 20:48:41', 0);

SET FOREIGN_KEY_CHECKS = 1;
