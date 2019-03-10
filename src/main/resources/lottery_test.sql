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

 Date: 10/03/2019 20:36:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for lottery
-- ----------------------------
DROP TABLE IF EXISTS `lottery`;
CREATE TABLE `lottery`  (
  `id` int(6) NOT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '活动标题',
  `banner` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '活动图片',
  `desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '活动描述',
  `open_type` int(6) NOT NULL COMMENT '开奖方式',
  `open_date` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '开奖日期',
  `open_participator_num` int(4) NULL DEFAULT NULL COMMENT '开奖人数',
  `sponsor` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '赞助者',
  `status` int(2) NOT NULL COMMENT '开奖状态',
  `prizeType` int(1) NULL DEFAULT NULL,
  `prizeName` varchar(63) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `prizeNum` int(2) NULL DEFAULT NULL,
  `prizePic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `prizeType1` int(1) NULL DEFAULT NULL,
  `prizeName1` varchar(63) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `prizeNum1` int(2) NULL DEFAULT NULL,
  `prizePic1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `prizeType2` int(1) NULL DEFAULT NULL,
  `prizeName2` varchar(63) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `prizeNum2` int(2) NULL DEFAULT NULL,
  `prizePic2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `prizeType3` int(1) NULL DEFAULT NULL,
  `prizeName3` varchar(63) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `prizeNum3` int(2) NULL DEFAULT NULL,
  `prizePic3` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `prizeType4` int(1) NULL DEFAULT NULL,
  `prizeName4` varchar(63) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `prizeNum4` int(2) NULL DEFAULT NULL,
  `prizePic4` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `prizeType5` int(1) NULL DEFAULT NULL,
  `prizeName5` varchar(63) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `prizeNum5` int(2) NULL DEFAULT NULL,
  `prizePic5` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `prizeType6` int(1) NULL DEFAULT NULL,
  `prizeName6` varchar(63) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `prizeNum6` int(2) NULL DEFAULT NULL,
  `prizePic6` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录插入时间',
  `update_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '记录修改时间',
  `is_delete` bigint(20) NULL DEFAULT 0 COMMENT '是否已经逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
  `is_delete` bigint(20) NULL DEFAULT 0 COMMENT '是否已经逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
  `is_delete` bigint(20) NULL DEFAULT 0 COMMENT '是否已经逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
  `is_delete` bigint(20) NULL DEFAULT 0 COMMENT '是否已经逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
