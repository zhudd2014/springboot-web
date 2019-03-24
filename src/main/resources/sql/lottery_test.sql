/*
 Navicat Premium Data Transfer

 Source Server         : 服务器数据库
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : 120.78.145.12:3306
 Source Schema         : lottery_test

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 24/03/2019 23:37:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for lottery
-- ----------------------------
DROP TABLE IF EXISTS `lottery`;
CREATE TABLE `lottery`  (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '活动标题',
  `banner` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '活动图片',
  `desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '活动描述',
  `open_type` int(6) NULL DEFAULT NULL COMMENT '开奖方式',
  `open_date` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '开奖日期',
  `open_participator_num` int(4) NULL DEFAULT NULL COMMENT '开奖人数',
  `sponsor` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '赞助者',
  `status` int(2) NULL DEFAULT NULL COMMENT '开奖状态',
  `award` json NULL COMMENT '奖项设置',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录插入时间',
  `update_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '记录修改时间',
  `is_delete` bit(1) NULL DEFAULT b'0' COMMENT '是否已经逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lottery
-- ----------------------------
INSERT INTO `lottery` VALUES (1, '春节抽奖', '12456.png', '回馈老客户', NULL, '2019-03-24 23:28:38', NULL, '张璐个人赞助', NULL, '{\"award1\": {\"prizes\": [{\"prizeId\": 1, \"quantity\": 1}], \"winerIds\": [1]}, \"award2\": {\"prizes\": [{\"prizeId\": 2, \"quantity\": 1}], \"winerIds\": [2]}, \"award3\": {\"prizes\": [{\"prizeId\": 3, \"quantity\": 1}, {\"prizeId\": 4, \"quantity\": 1}], \"winerIds\": [3, 4]}, \"award4\": {\"prizes\": [{\"prizeId\": 4, \"quantity\": 1}, {\"prizeId\": 5, \"quantity\": 1}], \"winerIds\": [5, 6]}, \"award5\": {\"prizes\": [{\"prizeId\": 5, \"quantity\": 2}], \"winerIds\": [7, 8, 9]}}', '2019-03-24 18:44:41', '2019-03-24 23:28:38', b'0');

-- ----------------------------
-- Table structure for participant
-- ----------------------------
DROP TABLE IF EXISTS `participant`;
CREATE TABLE `participant`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '参与id',
  `lottery_id` int(6) NOT NULL COMMENT '活动id',
  `lottery_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '活动标题',
  `user_id` int(11) NOT NULL COMMENT '参与者id',
  `username` varchar(63) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '参与者名称',
  `prize_level` int(1) NULL DEFAULT NULL COMMENT '中奖等级（-1-未中奖；0-单一奖品奖；1～5对应一到五等奖）',
  `jion_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '参与时间',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录插入时间',
  `update_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '记录修改时间',
  `is_delete` bit(1) NULL DEFAULT b'0' COMMENT '是否已经逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of participant
-- ----------------------------
INSERT INTO `participant` VALUES (1, 1, '春节抽奖', 1, '张三', NULL, '2019-03-24 22:31:38', '2019-03-24 22:31:38', NULL, b'0');
INSERT INTO `participant` VALUES (2, 1, '春节抽奖', 2, '张三丰', NULL, '2019-03-24 22:32:29', '2019-03-24 22:32:29', NULL, b'0');

-- ----------------------------
-- Table structure for prize
-- ----------------------------
DROP TABLE IF EXISTS `prize`;
CREATE TABLE `prize`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '奖品编号',
  `title` varchar(63) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '奖品名',
  `desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '奖品描述',
  `price` int(11) NOT NULL COMMENT '奖品价格',
  `quantity` int(11) NOT NULL COMMENT '奖品库存数',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录插入时间',
  `update_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '记录修改时间',
  `is_delete` bit(1) NULL DEFAULT b'0' COMMENT '是否已经逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of prize
-- ----------------------------
INSERT INTO `prize` VALUES (1, 'MacBookPro', '新一代全新平板', 19800, 5, '2019-03-24 16:57:34', '2019-03-24 17:37:57', b'0');
INSERT INTO `prize` VALUES (2, 'IPhoneXR', '刘海屏幕', 8990, 20, '2019-03-24 16:58:16', '2019-03-24 17:38:42', b'0');
INSERT INTO `prize` VALUES (3, '华为Mate20', '麒麟芯片就是快', 4880, 50, '2019-03-24 16:59:20', '2019-03-24 17:39:24', b'0');
INSERT INTO `prize` VALUES (4, '小米8', '质优价廉，性价比超高', 1998, 210, '2019-03-24 17:00:17', '2019-03-24 17:40:20', b'0');
INSERT INTO `prize` VALUES (5, '小米只能音箱', '超远范围', 98, 500, '2019-03-24 17:41:24', NULL, b'0');
INSERT INTO `prize` VALUES (6, '飞科剃须刀', '超顺超滑超干净', 168, 250, '2019-03-24 17:59:57', NULL, b'0');
INSERT INTO `prize` VALUES (7, '心相印纸巾', '请胡顺华', 4, 1000, '2019-03-24 18:04:05', NULL, b'0');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `username` varchar(63) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `gender` tinyint(2) NOT NULL COMMENT '性别',
  `mobile` varchar(13) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `open_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '微信openId',
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '微信头像',
  `nickname` varchar(63) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '微信昵称',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录插入时间',
  `update_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '记录修改时间',
  `is_delete` bit(1) NULL DEFAULT b'0' COMMENT '是否已经逻辑删除',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '张三', 0, '13500001111', '广东省深圳市', 'openid123456485315554565', 'icon.png', '抠脚大叔', '2019-03-24 21:55:42', NULL, b'0');
INSERT INTO `user` VALUES (2, '张三丰', 0, '13900001111', '广东省广东市', 'openid123456485315554565', 'icon.png', '猥琐大叔', '2019-03-24 22:15:22', NULL, b'0');
INSERT INTO `user` VALUES (3, '许勇华', 0, '15900003333', '广东省佛山市', 'openid123456485315554565', 'icon.png', '小可爱大叔', '2019-03-24 22:16:11', NULL, b'0');
INSERT INTO `user` VALUES (4, '许三朵', 0, '15900003333', '广东省佛山市', 'openid123456485315554565', 'icon.png', '小可爱大叔', '2019-03-24 23:22:07', NULL, b'0');
INSERT INTO `user` VALUES (5, '许时多', 0, '15900003333', '广东省佛山市', 'openid123456485315554565', 'icon.png', '小可爱大叔', '2019-03-24 23:22:20', NULL, b'0');
INSERT INTO `user` VALUES (6, '马武', 0, '15900003333', '广东省佛山市', 'openid123456485315554565', 'icon.png', '小可爱大叔', '2019-03-24 23:22:28', NULL, b'0');
INSERT INTO `user` VALUES (7, '萝莉', 0, '15900003333', '广东省佛山市', 'openid123456485315554565', 'icon.png', '小可爱', '2019-03-24 23:22:42', NULL, b'0');
INSERT INTO `user` VALUES (8, '李世门', 0, '15900003333', '上海市', 'openid123456485315554565', 'icon.png', '小可爱', '2019-03-24 23:23:07', NULL, b'0');
INSERT INTO `user` VALUES (9, '王宝强', 0, '15900003333', '北京市', 'openid123456485315554565', 'icon.png', '屌丝逆袭', '2019-03-24 23:23:31', NULL, b'0');
INSERT INTO `user` VALUES (10, '王宝', 0, '15900003333', '天津市', 'openid123456485315554565', 'icon.png', '屌丝逆袭', '2019-03-24 23:23:45', NULL, b'0');

SET FOREIGN_KEY_CHECKS = 1;
