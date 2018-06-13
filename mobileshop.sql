/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1_3306
Source Server Version : 50557
Source Host           : 127.0.0.1:3306
Source Database       : mobileshop

Target Server Type    : MYSQL
Target Server Version : 50557
File Encoding         : 65001

Date: 2017-12-15 11:04:54
*/

SET FOREIGN_KEY_CHECKS=0;


-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL,
  `email` varchar(40) NOT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `money` decimal(10,2) DEFAULT '100000.00',
  `gmt_create` datetime NOT NULL,
  `gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `state` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`uid`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('1', 'wuyuchen', 'I/xAqxzk5N9uDePpTLBpzw==', '425031186@qq.com', '18797955764', '九江职业技术学院', '471362.00', '2017-10-30 21:36:22', '2017-11-22 16:03:09', '0');
INSERT INTO `user_info` VALUES ('2', 'meiyou', '4QrcOUm6Wau+VuBX8g+IPg==', '425@qq.com', '18797950000', '九江职业技术学院濂溪校区', '97552.00', '2017-11-19 19:10:19', '2017-11-22 16:06:44', '0');
INSERT INTO `user_info` VALUES ('3', 'test123', '4QrcOUm6Wau+VuBX8g+IPg==', '12aaa3@qq.com', null, null, '100000.00', '2017-11-19 19:13:31', '2017-11-19 19:13:31', '0');


-- ----------------------------
-- Table structure for product_info
-- ----------------------------
DROP TABLE IF EXISTS `product_info`;
CREATE TABLE `product_info` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `price` decimal(10,3) DEFAULT NULL,
  `stock` int(11) DEFAULT '0',
  `brand` varchar(40) NOT NULL,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=319 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_info
-- ----------------------------
INSERT INTO `product_info` VALUES ('1', '荣耀9 全网通 4G 64G', '2299.000', '1000', '华为', '2017-11-02 14:51:42', '2017-11-22 13:30:40');
INSERT INTO `product_info` VALUES ('2', '荣耀9 全网通 4G 64G', '2299.000', '1000', '华为', '2017-11-02 14:53:08', '2017-11-22 13:28:54');
INSERT INTO `product_info` VALUES ('3', '荣耀9 全网通 4G+64G', '2299.000', '999', '华为', '2017-11-02 14:53:08', '2017-11-19 17:15:20');
INSERT INTO `product_info` VALUES ('4', '荣耀9 全网通 4G+64G', '2299.000', '1000', '华为', '2017-11-02 14:53:08', '2017-11-02 14:53:08');
INSERT INTO `product_info` VALUES ('5', '荣耀9 全网通 4G+64G', '2299.000', '1000', '华为', '2017-11-02 14:53:08', '2017-11-02 14:53:08');
INSERT INTO `product_info` VALUES ('6', '荣耀9 全网通 4G+64G', '2299.000', '1000', '华为', '2017-11-02 14:53:08', '2017-11-02 14:53:08');
INSERT INTO `product_info` VALUES ('7', '荣耀9 全网通 4G+64G', '2299.000', '1000', '华为', '2017-11-02 14:53:08', '2017-11-02 14:53:08');
INSERT INTO `product_info` VALUES ('8', '荣耀9 全网通 4G+64G', '2299.000', '1000', '华为', '2017-11-02 14:53:08', '2017-11-02 14:53:08');
INSERT INTO `product_info` VALUES ('9', '荣耀9 全网通 4G+64G', '2299.000', '1000', '华为', '2017-11-02 14:53:08', '2017-11-02 14:53:08');
INSERT INTO `product_info` VALUES ('10', '荣耀9 全网通 4G+64G', '2299.000', '1000', '华为', '2017-11-02 14:53:08', '2017-11-02 14:53:08');
INSERT INTO `product_info` VALUES ('11', '荣耀9 全网通 4G+64G', '2299.000', '1000', '华为', '2017-11-02 14:53:08', '2017-11-02 14:53:08');
INSERT INTO `product_info` VALUES ('12', '荣耀9 全网通 4G+64G', '2299.000', '1000', '华为', '2017-11-02 14:53:08', '2017-11-02 14:53:08');
INSERT INTO `product_info` VALUES ('13', '荣耀9 全网通 4G+64G', '2299.000', '1000', '华为', '2017-11-02 14:53:08', '2017-11-02 14:53:08');
INSERT INTO `product_info` VALUES ('14', '荣耀9 全网通 4G+64G', '2299.000', '1000', '华为', '2017-11-02 14:53:08', '2017-11-02 14:53:08');
INSERT INTO `product_info` VALUES ('15', '荣耀9 全网通 4G+64G', '2299.000', '1000', '华为', '2017-11-02 14:53:08', '2017-11-02 14:53:08');
INSERT INTO `product_info` VALUES ('16', '荣耀9 全网通 4G+64G', '2299.000', '1000', '华为', '2017-11-02 14:53:08', '2017-11-02 14:53:08');
INSERT INTO `product_info` VALUES ('17', '荣耀9 全网通 4G+64G', '2299.000', '1000', '华为', '2017-11-02 14:53:08', '2017-11-02 14:53:08');
INSERT INTO `product_info` VALUES ('18', '荣耀9 全网通 4G+64G', '2299.000', '1000', '华为', '2017-11-02 14:53:08', '2017-11-02 14:53:08');
INSERT INTO `product_info` VALUES ('19', '荣耀9 全网通 4G+64G', '2299.000', '1000', '华为', '2017-11-02 14:53:08', '2017-11-02 14:53:08');
INSERT INTO `product_info` VALUES ('20', '荣耀9 全网通 4G+64G', '2299.000', '1000', '华为', '2017-11-02 14:53:08', '2017-11-02 14:53:08');
INSERT INTO `product_info` VALUES ('21', '荣耀9 全网通 4G+64G', '2299.000', '1000', '华为', '2017-11-02 14:53:08', '2017-11-02 14:53:08');
INSERT INTO `product_info` VALUES ('22', '荣耀9 全网通 4G+64G', '2299.000', '1000', '华为', '2017-11-02 14:53:08', '2017-11-02 14:53:08');
INSERT INTO `product_info` VALUES ('23', '荣耀9 全网通 4G+64G', '2299.000', '1000', '华为', '2017-11-02 14:53:08', '2017-11-02 14:53:08');
INSERT INTO `product_info` VALUES ('24', '荣耀9 全网通 4G+64G', '2299.000', '1000', '华为', '2017-11-02 14:53:08', '2017-11-02 14:53:08');
INSERT INTO `product_info` VALUES ('25', '荣耀9 全网通 4G+64G', '2299.000', '1000', '华为', '2017-11-02 14:53:08', '2017-11-02 14:53:08');
INSERT INTO `product_info` VALUES ('26', '荣耀9 全网通 4G+64G', '2299.000', '1000', '华为', '2017-11-02 14:53:08', '2017-11-02 14:53:08');
INSERT INTO `product_info` VALUES ('27', '荣耀9 全网通 4G+64G', '2299.000', '1000', '华为', '2017-11-02 14:53:08', '2017-11-02 14:53:08');
INSERT INTO `product_info` VALUES ('28', '荣耀9 全网通 4G+64G', '2299.000', '1000', '华为', '2017-11-02 14:53:08', '2017-11-02 14:53:08');
INSERT INTO `product_info` VALUES ('29', '荣耀9 全网通 4G+64G', '2299.000', '1000', '华为', '2017-11-02 14:53:08', '2017-11-02 14:53:08');
INSERT INTO `product_info` VALUES ('30', '荣耀9 全网通 4G+64G', '2299.000', '1000', '华为', '2017-11-02 14:53:08', '2017-11-02 14:53:08');
INSERT INTO `product_info` VALUES ('31', '荣耀9 全网通 4G+64G', '2299.000', '1000', '华为', '2017-11-02 14:53:08', '2017-11-02 14:53:08');
INSERT INTO `product_info` VALUES ('32', '荣耀9 全网通 4G+64G', '2299.000', '1000', '华为', '2017-11-02 14:53:08', '2017-11-02 14:53:08');
INSERT INTO `product_info` VALUES ('33', '荣耀9 全网通 4G+64G', '2299.000', '1000', '华为', '2017-11-02 14:53:08', '2017-11-02 14:53:08');
INSERT INTO `product_info` VALUES ('34', '荣耀9 全网通 4G+64G', '2299.000', '998', '华为', '2017-11-02 14:53:08', '2017-11-19 17:15:20');
INSERT INTO `product_info` VALUES ('35', 'Apple IPhone 6 32GB', '2599.000', '992', 'Apple', '2017-11-02 14:58:21', '2017-11-19 11:28:44');
INSERT INTO `product_info` VALUES ('36', 'Apple IPhone 6 32GB', '2599.000', '995', 'Apple', '2017-11-02 14:58:21', '2017-11-19 11:28:44');
INSERT INTO `product_info` VALUES ('37', 'Apple IPhone 6 32GB', '2599.000', '1000', 'Apple', '2017-11-02 14:58:21', '2017-11-22 14:38:57');
INSERT INTO `product_info` VALUES ('38', 'Apple IPhone 6 32GB', '2599.000', '1000', 'Apple', '2017-11-02 14:58:21', '2017-11-02 14:58:21');
INSERT INTO `product_info` VALUES ('39', 'Apple IPhone 6 32GB', '2599.000', '1000', 'Apple', '2017-11-02 14:58:21', '2017-11-22 14:38:59');
INSERT INTO `product_info` VALUES ('40', 'Apple IPhone 6 32GB', '2599.000', '1000', 'Apple', '2017-11-02 14:58:21', '2017-11-02 14:58:21');
INSERT INTO `product_info` VALUES ('41', 'Apple IPhone 6 32GB', '2599.000', '1000', 'Apple', '2017-11-02 14:58:21', '2017-11-02 14:58:21');
INSERT INTO `product_info` VALUES ('42', 'Apple IPhone 6 32GB', '2599.000', '1000', 'Apple', '2017-11-02 14:58:21', '2017-11-02 14:58:21');
INSERT INTO `product_info` VALUES ('43', 'Apple IPhone 6 32GB', '2599.000', '1000', 'Apple', '2017-11-02 14:58:21', '2017-11-02 14:58:21');
INSERT INTO `product_info` VALUES ('44', 'Apple IPhone 6 32GB', '2599.000', '1000', 'Apple', '2017-11-02 14:58:21', '2017-11-02 14:58:21');
INSERT INTO `product_info` VALUES ('45', 'Apple IPhone 6 32GB', '2599.000', '1000', 'Apple', '2017-11-02 14:58:21', '2017-11-02 14:58:21');
INSERT INTO `product_info` VALUES ('46', 'Apple IPhone 6 32GB', '2599.000', '1000', 'Apple', '2017-11-02 14:58:21', '2017-11-02 14:58:21');
INSERT INTO `product_info` VALUES ('47', 'Apple IPhone 6 32GB', '2599.000', '1000', 'Apple', '2017-11-02 14:58:21', '2017-11-02 14:58:21');
INSERT INTO `product_info` VALUES ('48', 'Apple IPhone 6 32GB', '2599.000', '1000', 'Apple', '2017-11-02 14:58:21', '2017-11-02 14:58:21');
INSERT INTO `product_info` VALUES ('49', 'Apple IPhone 6 32GB', '2599.000', '1000', 'Apple', '2017-11-02 14:58:21', '2017-11-02 14:58:21');
INSERT INTO `product_info` VALUES ('50', 'Apple IPhone 6 32GB', '2599.000', '1000', 'Apple', '2017-11-02 14:58:22', '2017-11-02 14:58:22');
INSERT INTO `product_info` VALUES ('51', 'Apple IPhone 6 32GB', '2599.000', '1000', 'Apple', '2017-11-02 14:58:22', '2017-11-02 14:58:22');
INSERT INTO `product_info` VALUES ('52', 'Apple IPhone 6 32GB', '2599.000', '1000', 'Apple', '2017-11-02 14:58:22', '2017-11-02 14:58:22');
INSERT INTO `product_info` VALUES ('53', 'Apple IPhone 6 32GB', '2599.000', '1000', 'Apple', '2017-11-02 14:58:22', '2017-11-02 14:58:22');
INSERT INTO `product_info` VALUES ('54', 'Apple IPhone 6 32GB', '2599.000', '1000', 'Apple', '2017-11-02 14:58:22', '2017-11-02 14:58:22');
INSERT INTO `product_info` VALUES ('55', 'Apple IPhone 6 32GB', '2599.000', '1000', 'Apple', '2017-11-02 14:58:22', '2017-11-02 14:58:22');
INSERT INTO `product_info` VALUES ('56', 'Apple IPhone 6 32GB', '2599.000', '1000', 'Apple', '2017-11-02 14:58:22', '2017-11-02 14:58:22');
INSERT INTO `product_info` VALUES ('57', 'Apple IPhone 6 32GB', '2599.000', '1000', 'Apple', '2017-11-02 14:58:22', '2017-11-02 14:58:22');
INSERT INTO `product_info` VALUES ('58', 'Apple IPhone 6 32GB', '2599.000', '1000', 'Apple', '2017-11-02 14:58:22', '2017-11-02 14:58:22');
INSERT INTO `product_info` VALUES ('59', 'Apple IPhone 6 32GB', '2599.000', '1000', 'Apple', '2017-11-02 14:58:22', '2017-11-02 14:58:22');
INSERT INTO `product_info` VALUES ('60', 'Apple IPhone 6 32GB', '2599.000', '1000', 'Apple', '2017-11-02 14:58:22', '2017-11-02 14:58:22');
INSERT INTO `product_info` VALUES ('61', 'Apple IPhone 6 32GB', '2599.000', '999', 'Apple', '2017-11-02 14:58:22', '2017-11-22 13:29:08');
INSERT INTO `product_info` VALUES ('62', 'Apple IPhone 7 Plus 128GB', '6388.000', '1000', 'Apple', '2017-11-02 15:00:05', '2017-11-02 15:00:05');
INSERT INTO `product_info` VALUES ('63', 'Apple IPhone 7 Plus 128GB', '6388.000', '1000', 'Apple', '2017-11-02 15:00:05', '2017-11-02 15:00:05');
INSERT INTO `product_info` VALUES ('64', 'Apple IPhone 7 Plus 128GB', '6388.000', '1000', 'Apple', '2017-11-02 15:00:05', '2017-11-02 15:00:05');
INSERT INTO `product_info` VALUES ('65', 'Apple IPhone 7 Plus 128GB', '6388.000', '1000', 'Apple', '2017-11-02 15:00:05', '2017-11-02 15:00:05');
INSERT INTO `product_info` VALUES ('66', 'Apple IPhone 7 Plus 128GB', '6388.000', '1000', 'Apple', '2017-11-02 15:00:05', '2017-11-02 15:00:05');
INSERT INTO `product_info` VALUES ('67', 'Apple IPhone 7 Plus 128GB', '6388.000', '1000', 'Apple', '2017-11-02 15:00:05', '2017-11-02 15:00:05');
INSERT INTO `product_info` VALUES ('68', 'Apple IPhone 7 Plus 128GB', '6388.000', '1000', 'Apple', '2017-11-02 15:00:05', '2017-11-02 15:00:05');
INSERT INTO `product_info` VALUES ('69', 'Apple IPhone 7 Plus 128GB', '6388.000', '1000', 'Apple', '2017-11-02 15:00:05', '2017-11-02 15:00:05');
INSERT INTO `product_info` VALUES ('70', 'Apple IPhone 7 Plus 128GB', '6388.000', '1000', 'Apple', '2017-11-02 15:00:05', '2017-11-02 15:00:05');
INSERT INTO `product_info` VALUES ('71', 'Apple IPhone 7 Plus 128GB', '6388.000', '1000', 'Apple', '2017-11-02 15:00:05', '2017-11-02 15:00:05');
INSERT INTO `product_info` VALUES ('72', 'Apple IPhone 7 Plus 128GB', '6388.000', '1000', 'Apple', '2017-11-02 15:00:05', '2017-11-02 15:00:05');
INSERT INTO `product_info` VALUES ('73', 'Apple IPhone 7 Plus 128GB', '6388.000', '1000', 'Apple', '2017-11-02 15:00:05', '2017-11-02 15:00:05');
INSERT INTO `product_info` VALUES ('74', 'Apple IPhone 7 Plus 128GB', '6388.000', '1000', 'Apple', '2017-11-02 15:00:05', '2017-11-02 15:00:05');
INSERT INTO `product_info` VALUES ('75', 'Apple IPhone 7 Plus 128GB', '6388.000', '1000', 'Apple', '2017-11-02 15:00:05', '2017-11-02 15:00:05');
INSERT INTO `product_info` VALUES ('76', 'Apple IPhone 7 Plus 128GB', '6388.000', '1000', 'Apple', '2017-11-02 15:00:05', '2017-11-02 15:00:05');
INSERT INTO `product_info` VALUES ('77', 'Apple IPhone 7 Plus 128GB', '6388.000', '1000', 'Apple', '2017-11-02 15:00:05', '2017-11-02 15:00:05');
INSERT INTO `product_info` VALUES ('78', 'Apple IPhone 7 Plus 128GB', '6388.000', '1000', 'Apple', '2017-11-02 15:00:05', '2017-11-02 15:00:05');
INSERT INTO `product_info` VALUES ('79', 'Apple IPhone 7 Plus 128GB', '6388.000', '1000', 'Apple', '2017-11-02 15:00:05', '2017-11-02 15:00:05');
INSERT INTO `product_info` VALUES ('80', 'Apple IPhone 7 Plus 128GB', '6388.000', '1000', 'Apple', '2017-11-02 15:00:05', '2017-11-02 15:00:05');
INSERT INTO `product_info` VALUES ('81', 'Apple IPhone 7 Plus 128GB', '6388.000', '1000', 'Apple', '2017-11-02 15:00:05', '2017-11-02 15:00:05');
INSERT INTO `product_info` VALUES ('82', 'Apple IPhone 7 Plus 128GB', '6388.000', '1000', 'Apple', '2017-11-02 15:00:05', '2017-11-02 15:00:05');
INSERT INTO `product_info` VALUES ('83', 'Apple IPhone 7 Plus 128GB', '6388.000', '999', 'Apple', '2017-11-02 15:00:05', '2017-11-22 16:03:09');
INSERT INTO `product_info` VALUES ('84', 'Apple IPhone 7 Plus 128GB', '6388.000', '1000', 'Apple', '2017-11-02 15:00:05', '2017-11-02 15:00:05');
INSERT INTO `product_info` VALUES ('85', 'Apple IPhone 7 Plus 128GB', '6388.000', '1000', 'Apple', '2017-11-02 15:00:05', '2017-11-02 15:00:05');
INSERT INTO `product_info` VALUES ('86', 'Apple IPhone 7 Plus 128GB', '6388.000', '1000', 'Apple', '2017-11-02 15:00:05', '2017-11-02 15:00:05');
INSERT INTO `product_info` VALUES ('87', 'Apple IPhone 7 Plus 128GB', '6388.000', '1000', 'Apple', '2017-11-02 15:00:05', '2017-11-02 15:00:05');
INSERT INTO `product_info` VALUES ('88', 'Apple IPhone 7 Plus 128GB', '6388.000', '1000', 'Apple', '2017-11-02 15:00:05', '2017-11-02 15:00:05');
INSERT INTO `product_info` VALUES ('89', 'Apple IPhone 7 Plus 128GB', '6388.000', '1000', 'Apple', '2017-11-02 15:00:05', '2017-11-02 15:00:05');
INSERT INTO `product_info` VALUES ('90', 'Apple IPhone 7 Plus 128GB', '6388.000', '1000', 'Apple', '2017-11-02 15:00:05', '2017-11-02 15:00:05');
INSERT INTO `product_info` VALUES ('91', 'Apple IPhone 7 Plus 128GB', '6388.000', '1000', 'Apple', '2017-11-02 15:00:05', '2017-11-02 15:00:05');
INSERT INTO `product_info` VALUES ('92', 'OPPO A57 3G+32G', '1399.000', '1000', 'OPPO', '2017-11-02 15:02:01', '2017-11-02 15:02:01');
INSERT INTO `product_info` VALUES ('93', 'OPPO A57 3G+32G', '1399.000', '1000', 'OPPO', '2017-11-02 15:02:01', '2017-11-02 15:02:01');
INSERT INTO `product_info` VALUES ('94', 'OPPO A57 3G+32G', '1399.000', '1000', 'OPPO', '2017-11-02 15:02:01', '2017-11-02 15:02:01');
INSERT INTO `product_info` VALUES ('95', 'OPPO A57 3G+32G', '1399.000', '1000', 'OPPO', '2017-11-02 15:02:01', '2017-11-02 15:02:01');
INSERT INTO `product_info` VALUES ('96', 'OPPO A57 3G+32G', '1399.000', '1000', 'OPPO', '2017-11-02 15:02:01', '2017-11-02 15:02:01');
INSERT INTO `product_info` VALUES ('97', 'OPPO A57 3G+32G', '1399.000', '1000', 'OPPO', '2017-11-02 15:02:01', '2017-11-02 15:02:01');
INSERT INTO `product_info` VALUES ('98', 'OPPO A57 3G+32G', '1399.000', '1000', 'OPPO', '2017-11-02 15:02:01', '2017-11-02 15:02:01');
INSERT INTO `product_info` VALUES ('99', 'OPPO A57 3G+32G', '1399.000', '1000', 'OPPO', '2017-11-02 15:02:01', '2017-11-02 15:02:01');
INSERT INTO `product_info` VALUES ('100', 'OPPO A57 3G+32G', '1399.000', '1000', 'OPPO', '2017-11-02 15:02:01', '2017-11-02 15:02:01');
INSERT INTO `product_info` VALUES ('101', 'OPPO A57 3G+32G', '1399.000', '1000', 'OPPO', '2017-11-02 15:02:01', '2017-11-02 15:02:01');
INSERT INTO `product_info` VALUES ('102', 'OPPO A57 3G+32G', '1399.000', '1000', 'OPPO', '2017-11-02 15:02:01', '2017-11-02 15:02:01');
INSERT INTO `product_info` VALUES ('103', 'OPPO A57 3G+32G', '1399.000', '1000', 'OPPO', '2017-11-02 15:02:01', '2017-11-02 15:02:01');
INSERT INTO `product_info` VALUES ('104', 'OPPO A57 3G+32G', '1399.000', '1000', 'OPPO', '2017-11-02 15:02:01', '2017-11-02 15:02:01');
INSERT INTO `product_info` VALUES ('105', 'OPPO A57 3G+32G', '1399.000', '999', 'OPPO', '2017-11-02 15:02:01', '2017-11-22 16:06:44');
INSERT INTO `product_info` VALUES ('106', 'OPPO A57 3G+32G', '1399.000', '1000', 'OPPO', '2017-11-02 15:02:01', '2017-11-02 15:02:01');
INSERT INTO `product_info` VALUES ('107', 'OPPO A57 3G+32G', '1399.000', '1000', 'OPPO', '2017-11-02 15:02:01', '2017-11-02 15:02:01');
INSERT INTO `product_info` VALUES ('108', 'OPPO A57 3G+32G', '1399.000', '1000', 'OPPO', '2017-11-02 15:02:01', '2017-11-02 15:02:01');
INSERT INTO `product_info` VALUES ('109', 'OPPO A57 3G+32G', '1399.000', '1000', 'OPPO', '2017-11-02 15:02:01', '2017-11-02 15:02:01');
INSERT INTO `product_info` VALUES ('110', 'OPPO A57 3G+32G', '1399.000', '1000', 'OPPO', '2017-11-02 15:02:01', '2017-11-02 15:02:01');
INSERT INTO `product_info` VALUES ('111', 'OPPO A57 3G+32G', '1399.000', '1000', 'OPPO', '2017-11-02 15:02:01', '2017-11-02 15:02:01');
INSERT INTO `product_info` VALUES ('112', 'OPPO A57 3G+32G', '1399.000', '1000', 'OPPO', '2017-11-02 15:02:01', '2017-11-02 15:02:01');
INSERT INTO `product_info` VALUES ('113', 'OPPO A57 3G+32G', '1399.000', '1000', 'OPPO', '2017-11-02 15:02:01', '2017-11-02 15:02:01');
INSERT INTO `product_info` VALUES ('114', 'OPPO A57 3G+32G', '1399.000', '1000', 'OPPO', '2017-11-02 15:02:01', '2017-11-02 15:02:01');
INSERT INTO `product_info` VALUES ('115', 'OPPO A57 3G+32G', '1399.000', '1000', 'OPPO', '2017-11-02 15:02:01', '2017-11-02 15:02:01');
INSERT INTO `product_info` VALUES ('116', 'OPPO A57 3G+32G', '1399.000', '1000', 'OPPO', '2017-11-02 15:02:01', '2017-11-02 15:02:01');
INSERT INTO `product_info` VALUES ('117', 'OPPO A57 3G+32G', '1399.000', '1000', 'OPPO', '2017-11-02 15:02:01', '2017-11-02 15:02:01');
INSERT INTO `product_info` VALUES ('118', 'OPPO A57 3G+32G', '1399.000', '1000', 'OPPO', '2017-11-02 15:02:01', '2017-11-02 15:02:01');
INSERT INTO `product_info` VALUES ('119', 'OPPO A57 3G+32G', '1399.000', '1000', 'OPPO', '2017-11-02 15:02:01', '2017-11-02 15:02:01');
INSERT INTO `product_info` VALUES ('120', 'OPPO A57 3G+32G', '1399.000', '1000', 'OPPO', '2017-11-02 15:02:01', '2017-11-02 15:02:01');
INSERT INTO `product_info` VALUES ('121', 'OPPO A57 3G+32G', '1399.000', '1000', 'OPPO', '2017-11-02 15:02:01', '2017-11-02 15:02:01');
INSERT INTO `product_info` VALUES ('122', 'OPPO R11 4G+64G', '2799.000', '1000', 'OPPO', '2017-11-02 15:03:55', '2017-11-02 15:03:55');
INSERT INTO `product_info` VALUES ('123', 'OPPO R11 4G+64G', '2799.000', '1000', 'OPPO', '2017-11-02 15:03:55', '2017-11-02 15:03:55');
INSERT INTO `product_info` VALUES ('124', 'OPPO R11 4G+64G', '2799.000', '1000', 'OPPO', '2017-11-02 15:03:55', '2017-11-02 15:03:55');
INSERT INTO `product_info` VALUES ('125', 'OPPO R11 4G+64G', '2799.000', '1000', 'OPPO', '2017-11-02 15:03:55', '2017-11-02 15:03:55');
INSERT INTO `product_info` VALUES ('126', 'OPPO R11 4G+64G', '2799.000', '1000', 'OPPO', '2017-11-02 15:03:55', '2017-11-02 15:03:55');
INSERT INTO `product_info` VALUES ('127', 'OPPO R11 4G+64G', '2799.000', '1000', 'OPPO', '2017-11-02 15:03:55', '2017-11-02 15:03:55');
INSERT INTO `product_info` VALUES ('128', 'OPPO R11 4G+64G', '2799.000', '1000', 'OPPO', '2017-11-02 15:03:55', '2017-11-02 15:03:55');
INSERT INTO `product_info` VALUES ('129', 'OPPO R11 4G+64G', '2799.000', '1000', 'OPPO', '2017-11-02 15:03:55', '2017-11-02 15:03:55');
INSERT INTO `product_info` VALUES ('130', 'OPPO R11 4G+64G', '2799.000', '1000', 'OPPO', '2017-11-02 15:03:55', '2017-11-02 15:03:55');
INSERT INTO `product_info` VALUES ('131', 'OPPO R11 4G+64G', '2799.000', '1000', 'OPPO', '2017-11-02 15:03:55', '2017-11-02 15:03:55');
INSERT INTO `product_info` VALUES ('132', 'OPPO R11 4G+64G', '2799.000', '1000', 'OPPO', '2017-11-02 15:03:55', '2017-11-02 15:03:55');
INSERT INTO `product_info` VALUES ('133', 'OPPO R11 4G+64G', '2799.000', '1000', 'OPPO', '2017-11-02 15:03:55', '2017-11-02 15:03:55');
INSERT INTO `product_info` VALUES ('134', 'OPPO R11 4G+64G', '2799.000', '1000', 'OPPO', '2017-11-02 15:03:55', '2017-11-02 15:03:55');
INSERT INTO `product_info` VALUES ('135', 'OPPO R11 4G+64G', '2799.000', '1000', 'OPPO', '2017-11-02 15:03:55', '2017-11-02 15:03:55');
INSERT INTO `product_info` VALUES ('136', 'OPPO R11 4G+64G', '2799.000', '1000', 'OPPO', '2017-11-02 15:03:55', '2017-11-02 15:03:55');
INSERT INTO `product_info` VALUES ('137', 'OPPO R11 4G+64G', '2799.000', '1000', 'OPPO', '2017-11-02 15:03:55', '2017-11-02 15:03:55');
INSERT INTO `product_info` VALUES ('138', 'OPPO R11 4G+64G', '2799.000', '1000', 'OPPO', '2017-11-02 15:03:55', '2017-11-02 15:03:55');
INSERT INTO `product_info` VALUES ('139', 'OPPO R11 4G+64G', '2799.000', '1000', 'OPPO', '2017-11-02 15:03:55', '2017-11-02 15:03:55');
INSERT INTO `product_info` VALUES ('140', 'OPPO R11 4G+64G', '2799.000', '1000', 'OPPO', '2017-11-02 15:03:55', '2017-11-02 15:03:55');
INSERT INTO `product_info` VALUES ('141', 'OPPO R11 4G+64G', '2799.000', '1000', 'OPPO', '2017-11-02 15:03:55', '2017-11-02 15:03:55');
INSERT INTO `product_info` VALUES ('142', 'OPPO R11 4G+64G', '2799.000', '1000', 'OPPO', '2017-11-02 15:03:55', '2017-11-02 15:03:55');
INSERT INTO `product_info` VALUES ('143', 'OPPO R11 4G+64G', '2799.000', '1000', 'OPPO', '2017-11-02 15:03:55', '2017-11-02 15:03:55');
INSERT INTO `product_info` VALUES ('144', 'OPPO R11 4G+64G', '2799.000', '1000', 'OPPO', '2017-11-02 15:03:55', '2017-11-02 15:03:55');
INSERT INTO `product_info` VALUES ('145', 'OPPO R11 4G+64G', '2799.000', '1000', 'OPPO', '2017-11-02 15:03:55', '2017-11-02 15:03:55');
INSERT INTO `product_info` VALUES ('146', 'OPPO R11 4G+64G', '2799.000', '1000', 'OPPO', '2017-11-02 15:03:55', '2017-11-02 15:03:55');
INSERT INTO `product_info` VALUES ('147', 'OPPO R11 4G+64G', '2799.000', '1000', 'OPPO', '2017-11-02 15:03:55', '2017-11-02 15:03:55');
INSERT INTO `product_info` VALUES ('148', 'OPPO R11 4G+64G', '2799.000', '1000', 'OPPO', '2017-11-02 15:03:55', '2017-11-02 15:03:55');
INSERT INTO `product_info` VALUES ('149', 'OPPO R11 4G+64G', '2799.000', '1000', 'OPPO', '2017-11-02 15:03:55', '2017-11-02 15:03:55');
INSERT INTO `product_info` VALUES ('150', 'OPPO R11 4G+64G', '2799.000', '1000', 'OPPO', '2017-11-02 15:03:55', '2017-11-02 15:03:55');
INSERT INTO `product_info` VALUES ('151', 'OPPO R11 4G+64G', '2799.000', '1000', 'OPPO', '2017-11-02 15:03:55', '2017-11-02 15:03:55');
INSERT INTO `product_info` VALUES ('152', 'OPPO R11 4G+64G', '2799.000', '1000', 'OPPO', '2017-11-02 15:03:55', '2017-11-02 15:03:55');
INSERT INTO `product_info` VALUES ('153', 'OPPO R11 4G+64G', '2799.000', '1000', 'OPPO', '2017-11-02 15:03:55', '2017-11-02 15:03:55');
INSERT INTO `product_info` VALUES ('154', 'OPPO R11 4G+64G', '2799.000', '1000', 'OPPO', '2017-11-02 15:03:55', '2017-11-02 15:03:55');
INSERT INTO `product_info` VALUES ('155', 'OPPO R11 4G+64G', '2799.000', '1000', 'OPPO', '2017-11-02 15:03:55', '2017-11-02 15:03:55');
INSERT INTO `product_info` VALUES ('156', 'OPPO R11 4G+64G', '2799.000', '1000', 'OPPO', '2017-11-02 15:03:55', '2017-11-02 15:03:55');
INSERT INTO `product_info` VALUES ('157', 'OPPO R11 4G+64G', '2799.000', '1000', 'OPPO', '2017-11-02 15:03:55', '2017-11-02 15:03:55');
INSERT INTO `product_info` VALUES ('158', 'OPPO R11 4G+64G', '2799.000', '1000', 'OPPO', '2017-11-02 15:03:55', '2017-11-02 15:03:55');
INSERT INTO `product_info` VALUES ('159', 'OPPO R11 4G+64G', '2799.000', '1000', 'OPPO', '2017-11-02 15:03:55', '2017-11-02 15:03:55');
INSERT INTO `product_info` VALUES ('160', '魅族 PRO7 4G+64G 全网通', '2499.000', '1000', '魅族', '2017-11-02 15:05:34', '2017-11-05 16:19:28');
INSERT INTO `product_info` VALUES ('161', '魅族 PRO7 4G+64G 全网通', '2499.000', '1000', '魅族', '2017-11-02 15:05:34', '2017-11-05 16:19:30');
INSERT INTO `product_info` VALUES ('162', '魅族 PRO7 4G+64G 全网通', '2499.000', '1000', '魅族', '2017-11-02 15:05:34', '2017-11-05 16:19:32');
INSERT INTO `product_info` VALUES ('163', '魅族 PRO7 4G+64G 全网通', '2499.000', '1000', '魅族', '2017-11-02 15:05:34', '2017-11-05 16:19:35');
INSERT INTO `product_info` VALUES ('164', '魅族 PRO7 4G+64G 全网通', '2499.000', '1000', '魅族', '2017-11-02 15:05:34', '2017-11-05 16:19:39');
INSERT INTO `product_info` VALUES ('165', '魅族 PRO7 4G+64G 全网通', '2499.000', '1000', '魅族', '2017-11-02 15:05:34', '2017-11-05 16:19:47');
INSERT INTO `product_info` VALUES ('166', '魅族 PRO7 4G+64G 全网通', '2499.000', '1000', '魅族', '2017-11-02 15:05:34', '2017-11-05 16:19:49');
INSERT INTO `product_info` VALUES ('167', '魅族 PRO7 4G+64G 全网通', '2499.000', '1000', '魅族', '2017-11-02 15:05:34', '2017-11-05 16:19:52');
INSERT INTO `product_info` VALUES ('168', '魅族 PRO7 4G+64G 全网通', '2499.000', '1000', '魅族', '2017-11-02 15:05:34', '2017-11-05 16:20:57');
INSERT INTO `product_info` VALUES ('169', '魅族 PRO7 4G+64G 全网通', '2499.000', '1000', '魅族', '2017-11-02 15:05:34', '2017-11-05 16:21:00');
INSERT INTO `product_info` VALUES ('170', '魅族 PRO7 4G+64G 全网通', '2499.000', '1000', '魅族', '2017-11-02 15:05:34', '2017-11-05 16:20:54');
INSERT INTO `product_info` VALUES ('171', '魅族 PRO7 4G+64G 全网通', '2499.000', '1000', '魅族', '2017-11-02 15:05:34', '2017-11-05 16:20:52');
INSERT INTO `product_info` VALUES ('172', '魅族 PRO7 4G+64G 全网通', '2499.000', '1000', '魅族', '2017-11-02 15:05:34', '2017-11-05 16:20:51');
INSERT INTO `product_info` VALUES ('173', '魅族 PRO7 4G+64G 全网通', '2499.000', '1000', '魅族', '2017-11-02 15:05:34', '2017-11-05 16:20:49');
INSERT INTO `product_info` VALUES ('174', '魅族 PRO7 4G+64G 全网通', '2499.000', '1000', '魅族', '2017-11-02 15:05:34', '2017-11-05 16:20:48');
INSERT INTO `product_info` VALUES ('175', '魅族 PRO7 4G+64G 全网通', '2499.000', '1000', '魅族', '2017-11-02 15:05:34', '2017-11-05 16:20:46');
INSERT INTO `product_info` VALUES ('176', '魅族 PRO7 4G+64G 全网通', '2499.000', '1000', '魅族', '2017-11-02 15:05:34', '2017-11-05 16:20:42');
INSERT INTO `product_info` VALUES ('177', '魅族 PRO7 4G+64G 全网通', '2499.000', '1000', '魅族', '2017-11-02 15:05:34', '2017-11-05 16:20:40');
INSERT INTO `product_info` VALUES ('178', '魅族 PRO7 4G+64G 全网通', '2499.000', '1000', '魅族', '2017-11-02 15:05:34', '2017-11-05 16:20:36');
INSERT INTO `product_info` VALUES ('179', '魅族 PRO7 4G+64G 全网通', '2499.000', '1000', '魅族', '2017-11-02 15:05:34', '2017-11-05 16:20:31');
INSERT INTO `product_info` VALUES ('180', '魅族 PRO7 4G+64G 全网通', '2499.000', '1000', '魅族', '2017-11-02 15:05:34', '2017-11-05 16:20:30');
INSERT INTO `product_info` VALUES ('181', '魅族 PRO7 4G+64G 全网通', '2499.000', '1000', '魅族', '2017-11-02 15:05:34', '2017-11-05 16:20:28');
INSERT INTO `product_info` VALUES ('182', '魅族 PRO7 4G+64G 全网通', '2499.000', '1000', '魅族', '2017-11-02 15:05:34', '2017-11-05 16:20:26');
INSERT INTO `product_info` VALUES ('183', '魅族 PRO7 4G+64G 全网通', '2499.000', '1000', '魅族', '2017-11-02 15:05:35', '2017-11-05 16:20:24');
INSERT INTO `product_info` VALUES ('184', '魅族 PRO7 4G+64G 全网通', '2499.000', '1000', '魅族', '2017-11-02 15:05:35', '2017-11-05 16:20:22');
INSERT INTO `product_info` VALUES ('185', '魅族 PRO7 4G+64G 全网通', '2499.000', '1000', '魅族', '2017-11-02 15:05:35', '2017-11-05 16:20:21');
INSERT INTO `product_info` VALUES ('186', '魅族 PRO7 4G+64G 全网通', '2499.000', '1000', '魅族', '2017-11-02 15:05:35', '2017-11-05 16:20:18');
INSERT INTO `product_info` VALUES ('187', '魅族 PRO7 4G+64G 全网通', '2499.000', '1000', '魅族', '2017-11-02 15:05:35', '2017-11-05 16:20:16');
INSERT INTO `product_info` VALUES ('188', '魅族 PRO7 4G+64G 全网通', '2499.000', '1000', '魅族', '2017-11-02 15:05:35', '2017-11-05 16:20:15');
INSERT INTO `product_info` VALUES ('189', '魅族 PRO7 4G+64G 全网通', '2499.000', '1000', '魅族', '2017-11-02 15:05:35', '2017-11-05 16:20:11');
INSERT INTO `product_info` VALUES ('190', '魅族 PRO7 4G+64G 全网通', '2499.000', '1000', '魅族', '2017-11-02 15:05:35', '2017-11-05 16:20:09');
INSERT INTO `product_info` VALUES ('191', '魅族 PRO7 4G+64G 全网通', '2499.000', '1000', '魅族', '2017-11-02 15:05:35', '2017-11-05 16:20:08');
INSERT INTO `product_info` VALUES ('192', '魅族 PRO7 4G+64G 全网通', '2499.000', '1000', '魅族', '2017-11-02 15:05:35', '2017-11-05 16:20:06');
INSERT INTO `product_info` VALUES ('193', '魅族 PRO7 4G+64G 全网通', '2499.000', '1000', '魅族', '2017-11-02 15:05:35', '2017-11-05 16:20:04');
INSERT INTO `product_info` VALUES ('194', '魅族 PRO7 4G+64G 全网通', '2499.000', '1000', '魅族', '2017-11-02 15:05:35', '2017-11-05 16:20:02');
INSERT INTO `product_info` VALUES ('195', '魅族 PRO7 4G+64G 全网通', '2499.000', '1000', '魅族', '2017-11-02 15:05:35', '2017-11-05 16:20:00');
INSERT INTO `product_info` VALUES ('196', '魅族 PRO7 4G+64G 全网通', '2499.000', '1000', '魅族', '2017-11-02 15:05:35', '2017-11-05 16:19:58');
INSERT INTO `product_info` VALUES ('197', '魅族 魅蓝Note5 3G+32G', '1049.000', '1000', '魅族', '2017-11-02 15:07:51', '2017-11-02 15:07:51');
INSERT INTO `product_info` VALUES ('198', '魅族 魅蓝Note5 3G+32G', '1049.000', '1000', '魅族', '2017-11-02 15:07:51', '2017-11-02 15:07:51');
INSERT INTO `product_info` VALUES ('199', '魅族 魅蓝Note5 3G+32G', '1049.000', '1000', '魅族', '2017-11-02 15:07:51', '2017-11-02 15:07:51');
INSERT INTO `product_info` VALUES ('200', '魅族 魅蓝Note5 3G+32G', '1049.000', '1000', '魅族', '2017-11-02 15:07:51', '2017-11-02 15:07:51');
INSERT INTO `product_info` VALUES ('201', '魅族 魅蓝Note5 3G+32G', '1049.000', '1000', '魅族', '2017-11-02 15:07:51', '2017-11-02 15:07:51');
INSERT INTO `product_info` VALUES ('202', '魅族 魅蓝Note5 3G+32G', '1049.000', '1000', '魅族', '2017-11-02 15:07:51', '2017-11-02 15:07:51');
INSERT INTO `product_info` VALUES ('203', '魅族 魅蓝Note5 3G+32G', '1049.000', '1000', '魅族', '2017-11-02 15:07:51', '2017-11-02 15:07:51');
INSERT INTO `product_info` VALUES ('204', '魅族 魅蓝Note5 3G+32G', '1049.000', '1000', '魅族', '2017-11-02 15:07:51', '2017-11-02 15:07:51');
INSERT INTO `product_info` VALUES ('205', '魅族 魅蓝Note5 3G+32G', '1049.000', '1000', '魅族', '2017-11-02 15:07:51', '2017-11-02 15:07:51');
INSERT INTO `product_info` VALUES ('206', '魅族 魅蓝Note5 3G+32G', '1049.000', '1000', '魅族', '2017-11-02 15:07:51', '2017-11-02 15:07:51');
INSERT INTO `product_info` VALUES ('207', '魅族 魅蓝Note5 3G+32G', '1049.000', '1000', '魅族', '2017-11-02 15:07:51', '2017-11-02 15:07:51');
INSERT INTO `product_info` VALUES ('208', '魅族 魅蓝Note5 3G+32G', '1049.000', '1000', '魅族', '2017-11-02 15:07:51', '2017-11-02 15:07:51');
INSERT INTO `product_info` VALUES ('209', '魅族 魅蓝Note5 3G+32G', '1049.000', '1000', '魅族', '2017-11-02 15:07:51', '2017-11-02 15:07:51');
INSERT INTO `product_info` VALUES ('210', '魅族 魅蓝Note5 3G+32G', '1049.000', '1000', '魅族', '2017-11-02 15:07:51', '2017-11-02 15:07:51');
INSERT INTO `product_info` VALUES ('211', '魅族 魅蓝Note5 3G+32G', '1049.000', '1000', '魅族', '2017-11-02 15:07:52', '2017-11-02 15:07:52');
INSERT INTO `product_info` VALUES ('212', '魅族 魅蓝Note5 3G+32G', '1049.000', '1000', '魅族', '2017-11-02 15:07:52', '2017-11-02 15:07:52');
INSERT INTO `product_info` VALUES ('213', '魅族 魅蓝Note5 3G+32G', '1049.000', '1000', '魅族', '2017-11-02 15:07:52', '2017-11-02 15:07:52');
INSERT INTO `product_info` VALUES ('214', '魅族 魅蓝Note5 3G+32G', '1049.000', '1000', '魅族', '2017-11-02 15:07:52', '2017-11-02 15:07:52');
INSERT INTO `product_info` VALUES ('215', '魅族 魅蓝Note5 3G+32G', '1049.000', '1000', '魅族', '2017-11-02 15:07:52', '2017-11-02 15:07:52');
INSERT INTO `product_info` VALUES ('216', '魅族 魅蓝Note5 3G+32G', '1049.000', '1000', '魅族', '2017-11-02 15:07:52', '2017-11-02 15:07:52');
INSERT INTO `product_info` VALUES ('217', '魅族 魅蓝Note5 3G+32G', '1049.000', '1000', '魅族', '2017-11-02 15:07:52', '2017-11-02 15:07:52');
INSERT INTO `product_info` VALUES ('218', '魅族 魅蓝Note5 3G+32G', '1049.000', '1000', '魅族', '2017-11-02 15:07:52', '2017-11-02 15:07:52');
INSERT INTO `product_info` VALUES ('219', '魅族 魅蓝Note5 3G+32G', '1049.000', '1000', '魅族', '2017-11-02 15:07:52', '2017-11-02 15:07:52');
INSERT INTO `product_info` VALUES ('220', '魅族 魅蓝Note5 3G+32G', '1049.000', '1000', '魅族', '2017-11-02 15:07:52', '2017-11-02 15:07:52');
INSERT INTO `product_info` VALUES ('221', '魅族 魅蓝Note5 3G+32G', '1049.000', '1000', '魅族', '2017-11-02 15:07:52', '2017-11-02 15:07:52');
INSERT INTO `product_info` VALUES ('222', '魅族 魅蓝Note5 3G+32G', '1049.000', '1000', '魅族', '2017-11-02 15:07:52', '2017-11-02 15:07:52');
INSERT INTO `product_info` VALUES ('223', '魅族 魅蓝Note5 3G+32G', '1049.000', '1000', '魅族', '2017-11-02 15:07:52', '2017-11-02 15:07:52');
INSERT INTO `product_info` VALUES ('224', '魅族 魅蓝Note5 3G+32G', '1049.000', '1000', '魅族', '2017-11-02 15:07:52', '2017-11-02 15:07:52');
INSERT INTO `product_info` VALUES ('225', '魅族 魅蓝Note5 3G+32G', '1049.000', '1000', '魅族', '2017-11-02 15:07:52', '2017-11-02 15:07:52');
INSERT INTO `product_info` VALUES ('226', '魅族 魅蓝Note5 3G+32G', '1049.000', '1000', '魅族', '2017-11-02 15:07:52', '2017-11-02 15:07:52');
INSERT INTO `product_info` VALUES ('227', '魅族 魅蓝Note5 3G+32G', '1049.000', '1000', '魅族', '2017-11-02 15:07:52', '2017-11-02 15:07:52');
INSERT INTO `product_info` VALUES ('228', '魅族 魅蓝Note5 3G+32G', '1049.000', '1000', '魅族', '2017-11-02 15:07:52', '2017-11-02 15:07:52');
INSERT INTO `product_info` VALUES ('229', '魅族 魅蓝Note5 3G+32G', '1049.000', '1000', '魅族', '2017-11-02 15:07:52', '2017-11-02 15:07:52');
INSERT INTO `product_info` VALUES ('230', '魅族 魅蓝Note5 3G+32G', '1049.000', '999', '魅族', '2017-11-02 15:07:52', '2017-11-22 16:04:02');
INSERT INTO `product_info` VALUES ('231', '魅族 魅蓝Note5 3G+32G', '1049.000', '1000', '魅族', '2017-11-02 15:07:52', '2017-11-02 15:07:52');
INSERT INTO `product_info` VALUES ('232', '魅族 魅蓝Note5 3G+32G', '1049.000', '1000', '魅族', '2017-11-02 15:07:52', '2017-11-02 15:07:52');
INSERT INTO `product_info` VALUES ('233', '魅族 魅蓝Note5 3G+32G', '1049.000', '1000', '魅族', '2017-11-02 15:07:52', '2017-11-02 15:07:52');
INSERT INTO `product_info` VALUES ('234', '魅族 魅蓝Note5 3G+32G', '1049.000', '1000', '魅族', '2017-11-02 15:07:52', '2017-11-02 15:07:52');
INSERT INTO `product_info` VALUES ('235', '魅族 魅蓝Note5 3G+32G', '1049.000', '1000', '魅族', '2017-11-02 15:07:52', '2017-11-02 15:07:52');
INSERT INTO `product_info` VALUES ('236', '魅族 魅蓝Note5 3G+32G', '1049.000', '1000', '魅族', '2017-11-02 15:07:52', '2017-11-02 15:07:52');
INSERT INTO `product_info` VALUES ('237', '魅族 魅蓝Note5 3G+32G', '1049.000', '1000', '魅族', '2017-11-02 15:07:52', '2017-11-02 15:07:52');
INSERT INTO `product_info` VALUES ('238', '小米6 全网通 6G+128G', '2999.000', '1000', '小米', '2017-11-02 15:11:03', '2017-11-02 15:11:03');
INSERT INTO `product_info` VALUES ('239', '小米6 全网通 6G+128G', '2999.000', '1000', '小米', '2017-11-02 15:11:03', '2017-11-02 15:11:03');
INSERT INTO `product_info` VALUES ('240', '小米6 全网通 6G+128G', '2999.000', '1000', '小米', '2017-11-02 15:11:03', '2017-11-02 15:11:03');
INSERT INTO `product_info` VALUES ('241', '小米6 全网通 6G+128G', '2999.000', '1000', '小米', '2017-11-02 15:11:03', '2017-11-02 15:11:03');
INSERT INTO `product_info` VALUES ('242', '小米6 全网通 6G+128G', '2999.000', '1000', '小米', '2017-11-02 15:11:03', '2017-11-02 15:11:03');
INSERT INTO `product_info` VALUES ('243', '小米6 全网通 6G+128G', '2999.000', '1000', '小米', '2017-11-02 15:11:03', '2017-11-02 15:11:03');
INSERT INTO `product_info` VALUES ('244', '小米6 全网通 6G+128G', '2999.000', '1000', '小米', '2017-11-02 15:11:03', '2017-11-02 15:11:03');
INSERT INTO `product_info` VALUES ('245', '小米6 全网通 6G+128G', '2999.000', '1000', '小米', '2017-11-02 15:11:03', '2017-11-02 15:11:03');
INSERT INTO `product_info` VALUES ('246', '小米6 全网通 6G+128G', '2999.000', '1000', '小米', '2017-11-02 15:11:03', '2017-11-02 15:11:03');
INSERT INTO `product_info` VALUES ('247', '小米6 全网通 6G+128G', '2999.000', '1000', '小米', '2017-11-02 15:11:03', '2017-11-02 15:11:03');
INSERT INTO `product_info` VALUES ('248', '小米6 全网通 6G+128G', '2999.000', '1000', '小米', '2017-11-02 15:11:03', '2017-11-02 15:11:03');
INSERT INTO `product_info` VALUES ('249', '小米6 全网通 6G+128G', '2999.000', '1000', '小米', '2017-11-02 15:11:03', '2017-11-02 15:11:03');
INSERT INTO `product_info` VALUES ('250', '小米6 全网通 6G+128G', '2999.000', '1000', '小米', '2017-11-02 15:11:03', '2017-11-02 15:11:03');
INSERT INTO `product_info` VALUES ('251', '小米6 全网通 6G+128G', '2999.000', '1000', '小米', '2017-11-02 15:11:03', '2017-11-02 15:11:03');
INSERT INTO `product_info` VALUES ('252', '小米6 全网通 6G+128G', '2999.000', '1000', '小米', '2017-11-02 15:11:03', '2017-11-02 15:11:03');
INSERT INTO `product_info` VALUES ('253', '小米6 全网通 6G+128G', '2999.000', '1000', '小米', '2017-11-02 15:11:03', '2017-11-02 15:11:03');
INSERT INTO `product_info` VALUES ('254', '小米6 全网通 6G+128G', '2999.000', '1000', '小米', '2017-11-02 15:11:03', '2017-11-02 15:11:03');
INSERT INTO `product_info` VALUES ('255', '小米6 全网通 6G+128G', '2999.000', '1000', '小米', '2017-11-02 15:11:03', '2017-11-02 15:11:03');
INSERT INTO `product_info` VALUES ('256', '小米6 全网通 6G+128G', '2999.000', '1000', '小米', '2017-11-02 15:11:03', '2017-11-02 15:11:03');
INSERT INTO `product_info` VALUES ('257', '小米6 全网通 6G+128G', '2999.000', '1000', '小米', '2017-11-02 15:11:03', '2017-11-02 15:11:03');
INSERT INTO `product_info` VALUES ('258', '小米6 全网通 6G+128G', '2999.000', '1000', '小米', '2017-11-02 15:11:03', '2017-11-02 15:11:03');
INSERT INTO `product_info` VALUES ('259', '小米6 全网通 6G+128G', '2999.000', '1000', '小米', '2017-11-02 15:11:03', '2017-11-02 15:11:03');
INSERT INTO `product_info` VALUES ('260', '小米6 全网通 6G+128G', '2999.000', '1000', '小米', '2017-11-02 15:11:03', '2017-11-02 15:11:03');
INSERT INTO `product_info` VALUES ('261', '小米6 全网通 6G+128G', '2999.000', '1000', '小米', '2017-11-02 15:11:03', '2017-11-02 15:11:03');
INSERT INTO `product_info` VALUES ('262', '小米6 全网通 6G+128G', '2999.000', '1000', '小米', '2017-11-02 15:11:03', '2017-11-02 15:11:03');
INSERT INTO `product_info` VALUES ('263', '小米6 全网通 6G+128G', '2999.000', '1000', '小米', '2017-11-02 15:11:03', '2017-11-02 15:11:03');
INSERT INTO `product_info` VALUES ('264', '小米6 全网通 6G+128G', '2999.000', '1000', '小米', '2017-11-02 15:11:03', '2017-11-02 15:11:03');
INSERT INTO `product_info` VALUES ('265', '小米6 全网通 6G+128G', '2999.000', '1000', '小米', '2017-11-02 15:11:03', '2017-11-02 15:11:03');
INSERT INTO `product_info` VALUES ('266', '小米6 全网通 6G+128G', '2999.000', '1000', '小米', '2017-11-02 15:11:03', '2017-11-02 15:11:03');
INSERT INTO `product_info` VALUES ('267', '小米6 全网通 6G+128G', '2999.000', '1000', '小米', '2017-11-02 15:11:03', '2017-11-02 15:11:03');
INSERT INTO `product_info` VALUES ('268', '小米6 全网通 6G+128G', '2999.000', '1000', '小米', '2017-11-02 15:11:03', '2017-11-02 15:11:03');
INSERT INTO `product_info` VALUES ('269', '小米6 全网通 6G+128G', '2999.000', '1000', '小米', '2017-11-02 15:11:04', '2017-11-02 15:11:04');
INSERT INTO `product_info` VALUES ('270', '小米6 全网通 6G+128G', '2999.000', '1000', '小米', '2017-11-02 15:11:04', '2017-11-02 15:11:04');
INSERT INTO `product_info` VALUES ('271', '小米6 全网通 6G+128G', '2999.000', '1000', '小米', '2017-11-02 15:11:04', '2017-11-02 15:11:04');
INSERT INTO `product_info` VALUES ('272', '小米6 全网通 6G+128G', '2999.000', '1000', '小米', '2017-11-02 15:11:04', '2017-11-02 15:11:04');
INSERT INTO `product_info` VALUES ('273', '小米6 全网通 6G+128G', '2999.000', '1000', '小米', '2017-11-02 15:11:04', '2017-11-02 15:11:04');
INSERT INTO `product_info` VALUES ('274', '小米6 全网通 6G+128G', '2999.000', '1000', '小米', '2017-11-02 15:11:04', '2017-11-02 15:11:04');
INSERT INTO `product_info` VALUES ('275', '小米Max2 全网通 4G+64G', '1699.000', '1000', '小米', '2017-11-02 15:13:15', '2017-11-02 15:13:15');
INSERT INTO `product_info` VALUES ('276', '小米Max2 全网通 4G+64G', '1699.000', '1000', '小米', '2017-11-02 15:13:15', '2017-11-02 15:13:15');
INSERT INTO `product_info` VALUES ('277', '小米Max2 全网通 4G+64G', '1699.000', '1000', '小米', '2017-11-02 15:13:15', '2017-11-02 15:13:15');
INSERT INTO `product_info` VALUES ('278', '小米Max2 全网通 4G+64G', '1699.000', '1000', '小米', '2017-11-02 15:13:15', '2017-11-02 15:13:15');
INSERT INTO `product_info` VALUES ('279', '小米Max2 全网通 4G+64G', '1699.000', '1000', '小米', '2017-11-02 15:13:15', '2017-11-02 15:13:15');
INSERT INTO `product_info` VALUES ('280', '小米Max2 全网通 4G+64G', '1699.000', '1000', '小米', '2017-11-02 15:13:15', '2017-11-02 15:13:15');
INSERT INTO `product_info` VALUES ('281', '小米Max2 全网通 4G+64G', '1699.000', '1000', '小米', '2017-11-02 15:13:15', '2017-11-02 15:13:15');
INSERT INTO `product_info` VALUES ('282', '小米Max2 全网通 4G+64G', '1699.000', '1000', '小米', '2017-11-02 15:13:15', '2017-11-02 15:13:15');
INSERT INTO `product_info` VALUES ('283', '小米Max2 全网通 4G+64G', '1699.000', '1000', '小米', '2017-11-02 15:13:15', '2017-11-02 15:13:15');
INSERT INTO `product_info` VALUES ('284', '小米Max2 全网通 4G+64G', '1699.000', '1000', '小米', '2017-11-02 15:13:15', '2017-11-02 15:13:15');
INSERT INTO `product_info` VALUES ('285', '小米Max2 全网通 4G+64G', '1699.000', '1000', '小米', '2017-11-02 15:13:15', '2017-11-02 15:13:15');
INSERT INTO `product_info` VALUES ('286', '小米Max2 全网通 4G+64G', '1699.000', '1000', '小米', '2017-11-02 15:13:15', '2017-11-02 15:13:15');
INSERT INTO `product_info` VALUES ('287', '小米Max2 全网通 4G+64G', '1699.000', '1000', '小米', '2017-11-02 15:13:15', '2017-11-02 15:13:15');
INSERT INTO `product_info` VALUES ('288', '小米Max2 全网通 4G+64G', '1699.000', '1000', '小米', '2017-11-02 15:13:15', '2017-11-02 15:13:15');
INSERT INTO `product_info` VALUES ('289', '小米Max2 全网通 4G+64G', '1699.000', '1000', '小米', '2017-11-02 15:13:15', '2017-11-02 15:13:15');
INSERT INTO `product_info` VALUES ('290', '小米Max2 全网通 4G+64G', '1699.000', '1000', '小米', '2017-11-02 15:13:15', '2017-11-02 15:13:15');
INSERT INTO `product_info` VALUES ('291', '小米Max2 全网通 4G+64G', '1699.000', '1000', '小米', '2017-11-02 15:13:15', '2017-11-02 15:13:15');
INSERT INTO `product_info` VALUES ('292', '小米Max2 全网通 4G+64G', '1699.000', '1000', '小米', '2017-11-02 15:13:15', '2017-11-02 15:13:15');
INSERT INTO `product_info` VALUES ('293', '小米Max2 全网通 4G+64G', '1699.000', '1000', '小米', '2017-11-02 15:13:15', '2017-11-02 15:13:15');
INSERT INTO `product_info` VALUES ('294', '小米Max2 全网通 4G+64G', '1699.000', '1000', '小米', '2017-11-02 15:13:15', '2017-11-02 15:13:15');
INSERT INTO `product_info` VALUES ('295', '小米Max2 全网通 4G+64G', '1699.000', '1000', '小米', '2017-11-02 15:13:15', '2017-11-02 15:13:15');
INSERT INTO `product_info` VALUES ('296', '小米Max2 全网通 4G+64G', '1699.000', '1000', '小米', '2017-11-02 15:13:15', '2017-11-02 15:13:15');
INSERT INTO `product_info` VALUES ('297', '小米Max2 全网通 4G+64G', '1699.000', '1000', '小米', '2017-11-02 15:13:15', '2017-11-02 15:13:15');
INSERT INTO `product_info` VALUES ('298', '小米Max2 全网通 4G+64G', '1699.000', '1000', '小米', '2017-11-02 15:13:15', '2017-11-02 15:13:15');
INSERT INTO `product_info` VALUES ('299', '小米Max2 全网通 4G+64G', '1699.000', '1000', '小米', '2017-11-02 15:13:15', '2017-11-02 15:13:15');
INSERT INTO `product_info` VALUES ('300', '小米Max2 全网通 4G+64G', '1699.000', '1000', '小米', '2017-11-02 15:13:15', '2017-11-02 15:13:15');
INSERT INTO `product_info` VALUES ('301', '小米Max2 全网通 4G+64G', '1699.000', '1000', '小米', '2017-11-02 15:13:15', '2017-11-02 15:13:15');
INSERT INTO `product_info` VALUES ('302', '小米Max2 全网通 4G+64G', '1699.000', '1000', '小米', '2017-11-02 15:13:15', '2017-11-02 15:13:15');
INSERT INTO `product_info` VALUES ('303', '小米Max2 全网通 4G+64G', '1699.000', '1000', '小米', '2017-11-02 15:13:15', '2017-11-02 15:13:15');
INSERT INTO `product_info` VALUES ('304', '小米Max2 全网通 4G+64G', '1699.000', '1000', '小米', '2017-11-02 15:13:15', '2017-11-02 15:13:15');
INSERT INTO `product_info` VALUES ('305', '小米Max2 全网通 4G+64G', '1699.000', '1000', '小米', '2017-11-02 15:13:15', '2017-11-02 15:13:15');
INSERT INTO `product_info` VALUES ('306', '小米Max2 全网通 4G+64G', '1699.000', '1000', '小米', '2017-11-02 15:13:15', '2017-11-02 15:13:15');
INSERT INTO `product_info` VALUES ('307', '小米Max2 全网通 4G+64G', '1699.000', '1000', '小米', '2017-11-02 15:13:15', '2017-11-02 15:13:15');
INSERT INTO `product_info` VALUES ('308', '小米Max2 全网通 4G+64G', '1699.000', '1000', '小米', '2017-11-02 15:13:15', '2017-11-02 15:13:15');
INSERT INTO `product_info` VALUES ('309', '小米Max2 全网通 4G+64G', '1699.000', '1000', '小米', '2017-11-02 15:13:15', '2017-11-02 15:13:15');
INSERT INTO `product_info` VALUES ('310', '小米Max2 全网通 4G+64G', '1699.000', '1000', '小米', '2017-11-02 15:13:15', '2017-11-02 15:13:15');
INSERT INTO `product_info` VALUES ('311', '小米Max2 全网通 4G+64G', '1699.000', '1000', '小米', '2017-11-02 15:13:15', '2017-11-02 15:13:15');
INSERT INTO `product_info` VALUES ('312', '小米Max2 全网通 4G+64G', '1699.000', '1000', '小米', '2017-11-02 15:13:15', '2017-11-02 15:13:15');
INSERT INTO `product_info` VALUES ('313', '小米Max2 全网通 4G+64G', '1699.000', '1000', '小米', '2017-11-02 15:13:15', '2017-11-02 15:13:15');
INSERT INTO `product_info` VALUES ('314', '小米Max2 全网通 4G+64G', '1699.000', '1000', '小米', '2017-11-02 15:13:15', '2017-11-02 15:13:15');
INSERT INTO `product_info` VALUES ('315', '小米Max2 全网通 4G+64G', '1699.000', '1000', '小米', '2017-11-02 15:13:15', '2017-11-02 15:13:15');
INSERT INTO `product_info` VALUES ('318', '小米5X 全网通 4GB+64GB', '1599.000', '1000', '小米', '2017-11-23 11:46:44', '2017-11-23 11:46:44');

-- ----------------------------
-- Table structure for product_orders
-- ----------------------------
DROP TABLE IF EXISTS `product_orders`;
CREATE TABLE `product_orders` (
  `oid` bigint(11) NOT NULL AUTO_INCREMENT,
  `payment` decimal(10,3) NOT NULL,
  `quantity` int(11) NOT NULL,
  `pid` int(11) NOT NULL,
  `uid` int(11) NOT NULL,
  `state` int(11) NOT NULL DEFAULT '0',
  `gmt_create` datetime NOT NULL,
  `gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`oid`),
  KEY `orders_user_id_FK` (`uid`),
  KEY `orders_product_id_FK` (`pid`),
  CONSTRAINT `orders_product_id_FK` FOREIGN KEY (`pid`) REFERENCES `product_info` (`pid`),
  CONSTRAINT `orders_user_id_FK` FOREIGN KEY (`uid`) REFERENCES `user_info` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=189905852123803 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_orders
-- ----------------------------
INSERT INTO `product_orders` VALUES ('6925706328183', '5598.000', '2', '142', '1', '1', '2017-11-14 19:43:40', '2017-11-14 22:59:33');
INSERT INTO `product_orders` VALUES ('7787243609549', '1399.000', '1', '93', '1', '1', '2017-11-14 19:58:02', '2017-11-14 23:05:40');
INSERT INTO `product_orders` VALUES ('8488820650381', '5198.000', '2', '36', '1', '1', '2017-11-13 18:33:55', '2017-11-15 14:40:09');
INSERT INTO `product_orders` VALUES ('9342824546955', '1049.000', '1', '214', '1', '1', '2017-11-14 20:23:57', '2017-11-14 22:59:31');
INSERT INTO `product_orders` VALUES ('9342839786968', '2299.000', '1', '12', '1', '1', '2017-11-14 20:23:57', '2017-11-14 22:59:31');
INSERT INTO `product_orders` VALUES ('9795008857341', '12776.000', '2', '80', '1', '1', '2017-11-14 20:31:30', '2017-11-14 22:59:30');
INSERT INTO `product_orders` VALUES ('9817994050661', '2999.000', '1', '255', '1', '1', '2017-11-14 20:31:52', '2017-11-14 20:58:33');
INSERT INTO `product_orders` VALUES ('9843657991251', '259900.000', '100', '50', '1', '1', '2017-11-14 20:32:18', '2017-11-14 20:58:31');
INSERT INTO `product_orders` VALUES ('10214910490142', '1399.000', '1', '93', '1', '1', '2017-11-14 20:38:29', '2017-11-14 20:52:07');
INSERT INTO `product_orders` VALUES ('12448116195452', '5596.000', '4', '93', '1', '1', '2017-11-13 19:39:54', '2017-11-14 22:59:36');
INSERT INTO `product_orders` VALUES ('12448129103885', '4598.000', '2', '3', '1', '1', '2017-11-13 19:39:54', '2017-11-14 22:59:34');
INSERT INTO `product_orders` VALUES ('12448143174983', '12776.000', '2', '75', '1', '1', '2017-11-13 19:39:54', '2017-11-15 14:40:13');
INSERT INTO `product_orders` VALUES ('18020891042125', '17994.000', '6', '274', '1', '1', '2017-11-14 15:43:09', '2017-11-14 23:04:46');
INSERT INTO `product_orders` VALUES ('18020917519482', '8397.000', '3', '132', '1', '1', '2017-11-14 15:43:09', '2017-11-14 23:04:49');
INSERT INTO `product_orders` VALUES ('18667705466404', '2799.000', '1', '153', '1', '1', '2017-11-14 22:59:22', '2017-11-14 22:59:29');
INSERT INTO `product_orders` VALUES ('27923434187748', '11495.000', '5', '2', '1', '1', '2017-11-15 14:39:54', '2017-11-15 14:40:00');
INSERT INTO `product_orders` VALUES ('27923451635756', '11996.000', '4', '247', '1', '1', '2017-11-15 14:39:54', '2017-11-15 14:40:04');
INSERT INTO `product_orders` VALUES ('149719581773260', '6388.000', '1', '83', '1', '1', '2017-11-22 16:03:09', '2017-11-22 16:29:32');
INSERT INTO `product_orders` VALUES ('149773075130599', '1049.000', '1', '230', '2', '1', '2017-11-22 16:04:02', '2017-11-22 16:06:55');
INSERT INTO `product_orders` VALUES ('149934697400713', '1399.000', '1', '105', '2', '1', '2017-11-22 16:06:44', '2017-11-22 16:06:46');
INSERT INTO `product_orders` VALUES ('166272933294577', '2299.000', '1', '2', '1', '0', '2017-11-19 10:41:33', '2017-11-19 10:41:33');
INSERT INTO `product_orders` VALUES ('166272951175934', '2599.000', '1', '35', '1', '0', '2017-11-19 10:41:33', '2017-11-19 10:41:33');
INSERT INTO `product_orders` VALUES ('169045208666500', '12995.000', '5', '35', '1', '0', '2017-11-19 11:27:45', '2017-11-19 11:27:45');
INSERT INTO `product_orders` VALUES ('169104366543155', '2599.000', '1', '37', '1', '1', '2017-11-19 11:28:44', '2017-11-19 14:34:42');
INSERT INTO `product_orders` VALUES ('169104381784953', '12995.000', '5', '36', '1', '0', '2017-11-19 11:28:44', '2017-11-19 11:28:44');
INSERT INTO `product_orders` VALUES ('169104399773866', '7797.000', '3', '35', '1', '0', '2017-11-19 11:28:44', '2017-11-19 11:28:44');
INSERT INTO `product_orders` VALUES ('189905837213116', '4598.000', '2', '34', '1', '1', '2017-11-19 17:15:20', '2017-11-22 16:29:34');
INSERT INTO `product_orders` VALUES ('189905852123802', '2299.000', '1', '3', '1', '0', '2017-11-19 17:15:20', '2017-11-19 17:15:20');


-- ----------------------------
-- Table structure for product_cart
-- ----------------------------
DROP TABLE IF EXISTS `product_cart`;
CREATE TABLE `product_cart` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `pid` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `payable` decimal(10,3) NOT NULL,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`cid`),
  KEY `product_type_id_FK` (`uid`),
  KEY `product_brand_id_FK` (`pid`),
  CONSTRAINT `product_brand_id_FK` FOREIGN KEY (`pid`) REFERENCES `product_info` (`pid`),
  CONSTRAINT `product_type_id_FK` FOREIGN KEY (`uid`) REFERENCES `user_info` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_cart
-- ----------------------------


-- ----------------------------
-- Table structure for user_collection
-- ----------------------------
DROP TABLE IF EXISTS `user_collection`;
CREATE TABLE `user_collection` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) NOT NULL,
  `uid` int(11) NOT NULL,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`cid`),
  KEY `collection_user_id_FK` (`uid`),
  KEY `collection_product_id_FK` (`pid`),
  CONSTRAINT `collection_product_id_FK` FOREIGN KEY (`pid`) REFERENCES `product_info` (`pid`),
  CONSTRAINT `collection_user_id_FK` FOREIGN KEY (`uid`) REFERENCES `user_info` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_collection
-- ----------------------------
INSERT INTO `user_collection` VALUES ('1', '7', '1', '2017-11-19 13:31:37', '2017-11-19 13:31:37');
INSERT INTO `user_collection` VALUES ('2', '3', '1', '2017-11-19 13:31:42', '2017-11-19 13:31:42');
INSERT INTO `user_collection` VALUES ('3', '36', '1', '2017-11-19 13:37:25', '2017-11-19 13:37:25');
INSERT INTO `user_collection` VALUES ('4', '37', '1', '2017-11-19 13:37:28', '2017-11-19 13:37:28');
INSERT INTO `user_collection` VALUES ('5', '42', '1', '2017-11-19 13:37:35', '2017-11-19 13:37:35');
INSERT INTO `user_collection` VALUES ('6', '185', '1', '2017-11-19 13:44:59', '2017-11-19 13:44:59');
INSERT INTO `user_collection` VALUES ('7', '152', '1', '2017-11-19 13:45:14', '2017-11-19 13:45:14');
INSERT INTO `user_collection` VALUES ('8', '212', '1', '2017-11-19 13:45:18', '2017-11-19 13:45:18');
INSERT INTO `user_collection` VALUES ('9', '237', '1', '2017-11-19 13:45:40', '2017-11-19 13:45:40');
INSERT INTO `user_collection` VALUES ('10', '5', '1', '2017-11-19 13:45:48', '2017-11-19 13:45:48');
INSERT INTO `user_collection` VALUES ('11', '2', '1', '2017-11-19 13:45:54', '2017-11-19 13:45:54');
INSERT INTO `user_collection` VALUES ('12', '75', '1', '2017-11-19 13:45:58', '2017-11-19 13:45:58');
INSERT INTO `user_collection` VALUES ('13', '239', '1', '2017-11-19 13:46:03', '2017-11-19 13:46:03');
INSERT INTO `user_collection` VALUES ('14', '244', '1', '2017-11-19 13:46:07', '2017-11-19 13:46:07');
INSERT INTO `user_collection` VALUES ('15', '48', '1', '2017-11-19 13:46:10', '2017-11-19 13:46:10');
INSERT INTO `user_collection` VALUES ('16', '19', '1', '2017-11-19 13:46:13', '2017-11-19 13:46:13');
INSERT INTO `user_collection` VALUES ('17', '201', '1', '2017-11-19 13:46:16', '2017-11-19 13:46:16');
INSERT INTO `user_collection` VALUES ('18', '205', '1', '2017-11-19 13:46:19', '2017-11-19 13:46:19');
INSERT INTO `user_collection` VALUES ('20', '35', '1', '2017-11-19 14:40:48', '2017-11-19 14:40:48');
INSERT INTO `user_collection` VALUES ('21', '36', '1', '2017-11-19 14:41:00', '2017-11-19 14:41:00');
INSERT INTO `user_collection` VALUES ('22', '36', '2', '2017-11-22 16:29:52', '2017-11-22 16:29:52');

DROP TRIGGER IF EXISTS `stock_update`;
DELIMITER ;;
CREATE TRIGGER `stock_update` AFTER DELETE ON `product_cart` FOR EACH ROW begin
    update product_info set stock = stock - old.quantity where pid=old.pid;
end
;;
DELIMITER ;
