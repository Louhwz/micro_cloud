/*
Navicat MySQL Data Transfer

Source Server         : 本地数据库
Source Server Version : 50727
Source Host           : localhost:3307
Source Database       : cloud_ida

Target Server Type    : MYSQL
Target Server Version : 50727
File Encoding         : 65001

Date: 2020-03-08 11:26:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sbdata_room_orders
-- ----------------------------
DROP TABLE IF EXISTS `sbdata_room_orders`;
CREATE TABLE `sbdata_room_orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `expid` int(11) DEFAULT NULL,
  `groupid` int(11) DEFAULT NULL,
  `round` int(11) DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `room_id` int(11) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of sbdata_room_orders
-- ----------------------------
INSERT INTO `sbdata_room_orders` VALUES ('1', '34', '43', '3', '11', '557', '580');
INSERT INTO `sbdata_room_orders` VALUES ('2', '34', '43', '3', '11', '558', '580');
INSERT INTO `sbdata_room_orders` VALUES ('3', '34', '43', '3', '11', '559', '580');
INSERT INTO `sbdata_room_orders` VALUES ('4', '57', '124', '3', '11', '9225', '588');
INSERT INTO `sbdata_room_orders` VALUES ('5', '57', '124', '3', '11', '9226', '588');
INSERT INTO `sbdata_room_orders` VALUES ('6', '57', '124', '3', '11', '9236', '1333');
INSERT INTO `sbdata_room_orders` VALUES ('7', '57', '124', '3', '11', '9237', '1333');
INSERT INTO `sbdata_room_orders` VALUES ('8', '57', '124', '3', '11', '9239', '1333');
INSERT INTO `sbdata_room_orders` VALUES ('9', '57', '124', '3', '11', '9240', '1333');
