/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 100126
Source Host           : localhost:3306
Source Database       : legacy_local

Target Server Type    : MYSQL
Target Server Version : 100126
File Encoding         : 65001

Date: 2017-09-25 22:58:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for contract
-- ----------------------------
DROP TABLE IF EXISTS `contract`;
CREATE TABLE `contract` (
  `con_id` int(11) NOT NULL AUTO_INCREMENT,
  `con_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`con_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of contract
-- ----------------------------
INSERT INTO `contract` VALUES ('1', 'โอนย้าย');
INSERT INTO `contract` VALUES ('2', 'สัญญาจ้าง');
INSERT INTO `contract` VALUES ('3', 'รายวัน');
INSERT INTO `contract` VALUES ('4', 'รายเดือน(ปรับเป็นประจำเมื่อผ่านโปร)');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `dept_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `created` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `active` tinyint(4) DEFAULT '1',
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', 'Business Relationship', '2017-09-15 15:19:56', '1');
INSERT INTO `department` VALUES ('2', 'Department', '2017-09-15 15:20:12', '1');
INSERT INTO `department` VALUES ('3', 'Operation', '2017-09-15 15:20:16', '1');
INSERT INTO `department` VALUES ('4', 'Product & Business Development', '2017-09-15 15:20:28', '1');
INSERT INTO `department` VALUES ('5', 'Strategic Planning & Corporate Identity', '2017-09-15 15:21:12', '1');
INSERT INTO `department` VALUES ('6', 'Cafe 7', '2017-09-19 14:18:24', '1');

-- ----------------------------
-- Table structure for division
-- ----------------------------
DROP TABLE IF EXISTS `division`;
CREATE TABLE `division` (
  `div_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `dept_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`div_id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of division
-- ----------------------------
INSERT INTO `division` VALUES ('1', 'Business Deveopment', '4');
INSERT INTO `division` VALUES ('2', 'Cafe 7 (สาทร)', '6');
INSERT INTO `division` VALUES ('3', 'Call Center', '3');
INSERT INTO `division` VALUES ('4', 'Code Of Conduct', '1');
INSERT INTO `division` VALUES ('5', 'Customer Experience Managment', '3');
INSERT INTO `division` VALUES ('6', 'Domestic Branch Trendy', '3');
INSERT INTO `division` VALUES ('7', 'Domestic Branch ขอนแก่น', '3');
INSERT INTO `division` VALUES ('8', 'Domestic Branch ชลบุรี', '3');
INSERT INTO `division` VALUES ('9', 'Domestic Branch เชียงใหม่', '3');
INSERT INTO `division` VALUES ('10', 'Domestic Branch ทองหล่อ', '3');
INSERT INTO `division` VALUES ('11', 'Domestic Branch นครปฐม', '3');
INSERT INTO `division` VALUES ('12', 'Domestic Branch นครศรีธรรมราช', '3');
INSERT INTO `division` VALUES ('13', 'Domestic Branch นครสวรรค์', '3');
INSERT INTO `division` VALUES ('14', 'Domestic Branch บางกะปิสแควร์', '3');
INSERT INTO `division` VALUES ('15', 'Domestic Branch เพชรบุรี', '3');
INSERT INTO `division` VALUES ('16', 'Domestic Branch ภูเก็ต', '3');
INSERT INTO `division` VALUES ('17', 'Domestic Branch ยะลา', '3');
INSERT INTO `division` VALUES ('18', 'Domestic Branch ระยอง', '3');
INSERT INTO `division` VALUES ('19', 'Domestic Branch รังสิต', '3');
INSERT INTO `division` VALUES ('20', 'Domestic Branch สาทร', '3');
INSERT INTO `division` VALUES ('21', 'Domestic Branch หาดใหญ่', '3');
INSERT INTO `division` VALUES ('22', 'Domestic Branch ศรีสะเกษ', '3');
INSERT INTO `division` VALUES ('23', 'Event', null);
INSERT INTO `division` VALUES ('24', 'Finance', null);
INSERT INTO `division` VALUES ('25', 'General Affair', null);
INSERT INTO `division` VALUES ('26', 'Human Resource', null);
INSERT INTO `division` VALUES ('27', 'IT & System', '3');
INSERT INTO `division` VALUES ('28', 'Marketing', null);
INSERT INTO `division` VALUES ('29', 'Operation', '3');
INSERT INTO `division` VALUES ('30', 'Operation Support', '3');
INSERT INTO `division` VALUES ('31', 'Oversea Distribution', '3');
INSERT INTO `division` VALUES ('32', 'Premium Product Development', '5');
INSERT INTO `division` VALUES ('33', 'Product Development', '4');
INSERT INTO `division` VALUES ('34', 'Product Quality Assurance', '4');
INSERT INTO `division` VALUES ('35', 'Purchasing', null);
INSERT INTO `division` VALUES ('36', 'Strategic Planning & Corporate Identity', '5');

-- ----------------------------
-- Table structure for location
-- ----------------------------
DROP TABLE IF EXISTS `location`;
CREATE TABLE `location` (
  `loc_id` int(11) NOT NULL AUTO_INCREMENT,
  `loc_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`loc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of location
-- ----------------------------
INSERT INTO `location` VALUES ('1', 'สาทร');
INSERT INTO `location` VALUES ('2', 'Trendy');
INSERT INTO `location` VALUES ('3', 'ขอนแก่น');
INSERT INTO `location` VALUES ('4', 'ชลบุรี');
INSERT INTO `location` VALUES ('5', 'เชียงใหม่');
INSERT INTO `location` VALUES ('6', 'ทองหล่อ');
INSERT INTO `location` VALUES ('7', 'นครปฐม');
INSERT INTO `location` VALUES ('8', 'นครศรีธรรมราช');
INSERT INTO `location` VALUES ('9', 'นครสวรรค์');
INSERT INTO `location` VALUES ('10', 'บางกะปิ');
INSERT INTO `location` VALUES ('11', 'บางนา');
INSERT INTO `location` VALUES ('12', 'เพชรบุรี');
INSERT INTO `location` VALUES ('13', 'ภูเก็ต');
INSERT INTO `location` VALUES ('14', 'มักกะสัน');
INSERT INTO `location` VALUES ('15', 'ยะลา');
INSERT INTO `location` VALUES ('16', 'ระยอง');
INSERT INTO `location` VALUES ('17', 'รังสิต');
INSERT INTO `location` VALUES ('18', 'ศรีสะเกษ');
INSERT INTO `location` VALUES ('19', 'หาดใหญ่');

-- ----------------------------
-- Table structure for position
-- ----------------------------
DROP TABLE IF EXISTS `position`;
CREATE TABLE `position` (
  `pos_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `div_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`pos_id`)
) ENGINE=InnoDB AUTO_INCREMENT=180 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of position
-- ----------------------------
INSERT INTO `position` VALUES ('1', 'Application Control Officer', '30');
INSERT INTO `position` VALUES ('2', 'Application Control Supervisor', '30');
INSERT INTO `position` VALUES ('3', 'Assistant Operation Director', '29');
INSERT INTO `position` VALUES ('4', 'Branch Setup Admin', '30');
INSERT INTO `position` VALUES ('5', 'Branch Setup Officer', '30');
INSERT INTO `position` VALUES ('6', 'Call Center Delivery Officer', '30');
INSERT INTO `position` VALUES ('7', 'Corporate Identity Designer', '36');
INSERT INTO `position` VALUES ('8', 'Graphic Designer', '36');
INSERT INTO `position` VALUES ('9', 'Marketing Admin', '28');
INSERT INTO `position` VALUES ('10', 'Marketing Devision Manager', '28');
INSERT INTO `position` VALUES ('11', 'Marketing Executive', '28');
INSERT INTO `position` VALUES ('12', 'Online Delivery Officer', '30');
INSERT INTO `position` VALUES ('13', 'Operation Director', '29');
INSERT INTO `position` VALUES ('14', 'Operation trainer', '30');
INSERT INTO `position` VALUES ('15', 'Oversea Admin', '31');
INSERT INTO `position` VALUES ('16', 'Packaging Designer', '32');
INSERT INTO `position` VALUES ('17', 'Planning Officer', '30');
INSERT INTO `position` VALUES ('18', 'Premium Product Development Division Manager', '36');
INSERT INTO `position` VALUES ('19', 'Product Development Advisor', '33');
INSERT INTO `position` VALUES ('20', 'Product Quality Assurance Advisor', '34');
INSERT INTO `position` VALUES ('21', 'Product Quality Assurance Division Manager', '34');
INSERT INTO `position` VALUES ('22', 'Product Quality Assurance Supervisor', '34');
INSERT INTO `position` VALUES ('23', 'Production Planning Supervisor', '30');
INSERT INTO `position` VALUES ('24', 'R&D Product Development Division Manager', '33');
INSERT INTO `position` VALUES ('25', 'Senior Product Development', '33');
INSERT INTO `position` VALUES ('26', 'Senior General Purchasing', '35');
INSERT INTO `position` VALUES ('27', 'Senior Product Purchasing', '35');
INSERT INTO `position` VALUES ('28', 'Store Delivery Officer', '30');
INSERT INTO `position` VALUES ('29', 'Strategic Planning & Corporate Identity Department Manager', '36');
INSERT INTO `position` VALUES ('30', 'Trade Marketing', '28');
INSERT INTO `position` VALUES ('31', 'Assistant Managing Director', '25');
INSERT INTO `position` VALUES ('32', 'Assistant Event Manager', '23');
INSERT INTO `position` VALUES ('33', 'Barista', '2');
INSERT INTO `position` VALUES ('34', 'Branch Manager', '6');
INSERT INTO `position` VALUES ('35', 'Branch Manager', '7');
INSERT INTO `position` VALUES ('36', 'Branch Manager', '8');
INSERT INTO `position` VALUES ('37', 'Branch Manager', '9');
INSERT INTO `position` VALUES ('38', 'Branch Manager', '10');
INSERT INTO `position` VALUES ('39', 'Branch Manager', '11');
INSERT INTO `position` VALUES ('40', 'Branch Manager', '12');
INSERT INTO `position` VALUES ('41', 'Branch Manager', '13');
INSERT INTO `position` VALUES ('42', 'Branch Manager', '14');
INSERT INTO `position` VALUES ('43', 'Branch Manager', '15');
INSERT INTO `position` VALUES ('44', 'Branch Manager', '16');
INSERT INTO `position` VALUES ('45', 'Branch Manager', '17');
INSERT INTO `position` VALUES ('46', 'Branch Manager', '18');
INSERT INTO `position` VALUES ('47', 'Branch Manager', '19');
INSERT INTO `position` VALUES ('48', 'Branch Manager', '20');
INSERT INTO `position` VALUES ('49', 'Branch Manager', '21');
INSERT INTO `position` VALUES ('50', 'Branch Manager', '22');
INSERT INTO `position` VALUES ('51', 'Branch Manager (Acting)', '6');
INSERT INTO `position` VALUES ('52', 'Branch Manager (Acting)', '7');
INSERT INTO `position` VALUES ('53', 'Branch Manager (Acting)', '8');
INSERT INTO `position` VALUES ('54', 'Branch Manager (Acting)', '9');
INSERT INTO `position` VALUES ('55', 'Branch Manager (Acting)', '10');
INSERT INTO `position` VALUES ('56', 'Branch Manager (Acting)', '11');
INSERT INTO `position` VALUES ('57', 'Branch Manager (Acting)', '12');
INSERT INTO `position` VALUES ('58', 'Branch Manager (Acting)', '13');
INSERT INTO `position` VALUES ('59', 'Branch Manager (Acting)', '14');
INSERT INTO `position` VALUES ('60', 'Branch Manager (Acting)', '15');
INSERT INTO `position` VALUES ('61', 'Branch Manager (Acting)', '16');
INSERT INTO `position` VALUES ('62', 'Branch Manager (Acting)', '17');
INSERT INTO `position` VALUES ('63', 'Branch Manager (Acting)', '18');
INSERT INTO `position` VALUES ('64', 'Branch Manager (Acting)', '19');
INSERT INTO `position` VALUES ('65', 'Branch Manager (Acting)', '20');
INSERT INTO `position` VALUES ('66', 'Branch Manager (Acting)', '21');
INSERT INTO `position` VALUES ('67', 'Branch Manager (Acting)', '22');
INSERT INTO `position` VALUES ('68', 'Branch Store Officer', '6');
INSERT INTO `position` VALUES ('69', 'Branch Store Officer', '7');
INSERT INTO `position` VALUES ('70', 'Branch Store Officer', '8');
INSERT INTO `position` VALUES ('71', 'Branch Store Officer', '9');
INSERT INTO `position` VALUES ('72', 'Branch Store Officer', '10');
INSERT INTO `position` VALUES ('73', 'Branch Store Officer', '11');
INSERT INTO `position` VALUES ('74', 'Branch Store Officer', '12');
INSERT INTO `position` VALUES ('75', 'Branch Store Officer', '13');
INSERT INTO `position` VALUES ('76', 'Branch Store Officer', '14');
INSERT INTO `position` VALUES ('77', 'Branch Store Officer', '15');
INSERT INTO `position` VALUES ('78', 'Branch Store Officer', '16');
INSERT INTO `position` VALUES ('79', 'Branch Store Officer', '17');
INSERT INTO `position` VALUES ('80', 'Branch Store Officer', '18');
INSERT INTO `position` VALUES ('81', 'Branch Store Officer', '19');
INSERT INTO `position` VALUES ('82', 'Branch Store Officer', '20');
INSERT INTO `position` VALUES ('83', 'Branch Store Officer', '21');
INSERT INTO `position` VALUES ('84', 'Branch Store Officer', '22');
INSERT INTO `position` VALUES ('85', 'Business Development Advisor', '1');
INSERT INTO `position` VALUES ('86', 'Business Development Specialist', '1');
INSERT INTO `position` VALUES ('87', 'Business Development Division Manager', '1');
INSERT INTO `position` VALUES ('88', 'Business Development Officer', '1');
INSERT INTO `position` VALUES ('89', 'Call Center', '3');
INSERT INTO `position` VALUES ('90', 'Call Center Supervisor', '3');
INSERT INTO `position` VALUES ('91', 'Code Of Conduct Advisor', '4');
INSERT INTO `position` VALUES ('92', 'Code Of Conduct Officer', '4');
INSERT INTO `position` VALUES ('93', 'Commission Auditor Officer', '24');
INSERT INTO `position` VALUES ('94', 'Customer Experience Management Division Manager', '5');
INSERT INTO `position` VALUES ('95', 'Customer Service', '6');
INSERT INTO `position` VALUES ('96', 'Customer Service', '7');
INSERT INTO `position` VALUES ('97', 'Customer Service', '8');
INSERT INTO `position` VALUES ('98', 'Customer Service', '9');
INSERT INTO `position` VALUES ('99', 'Customer Service', '10');
INSERT INTO `position` VALUES ('100', 'Customer Service', '11');
INSERT INTO `position` VALUES ('101', 'Customer Service', '12');
INSERT INTO `position` VALUES ('102', 'Customer Service', '13');
INSERT INTO `position` VALUES ('103', 'Customer Service', '14');
INSERT INTO `position` VALUES ('104', 'Customer Service', '15');
INSERT INTO `position` VALUES ('105', 'Customer Service', '16');
INSERT INTO `position` VALUES ('106', 'Customer Service', '17');
INSERT INTO `position` VALUES ('107', 'Customer Service', '18');
INSERT INTO `position` VALUES ('108', 'Customer Service', '19');
INSERT INTO `position` VALUES ('109', 'Customer Service', '20');
INSERT INTO `position` VALUES ('110', 'Customer Service', '21');
INSERT INTO `position` VALUES ('111', 'Customer Service', '22');
INSERT INTO `position` VALUES ('112', 'Event Division Manager', '23');
INSERT INTO `position` VALUES ('113', 'Finance Division Manager', '24');
INSERT INTO `position` VALUES ('114', 'Finance Officer', '24');
INSERT INTO `position` VALUES ('115', 'Finance Supervisor', '24');
INSERT INTO `position` VALUES ('116', 'Head Of Distribution Center', '6');
INSERT INTO `position` VALUES ('117', 'Head Of Distribution Center', '7');
INSERT INTO `position` VALUES ('118', 'Head Of Distribution Center', '8');
INSERT INTO `position` VALUES ('119', 'Head Of Distribution Center', '9');
INSERT INTO `position` VALUES ('120', 'Head Of Distribution Center', '10');
INSERT INTO `position` VALUES ('121', 'Head Of Distribution Center', '11');
INSERT INTO `position` VALUES ('122', 'Head Of Distribution Center', '12');
INSERT INTO `position` VALUES ('123', 'Head Of Distribution Center', '13');
INSERT INTO `position` VALUES ('124', 'Head Of Distribution Center', '14');
INSERT INTO `position` VALUES ('125', 'Head Of Distribution Center', '15');
INSERT INTO `position` VALUES ('126', 'Head Of Distribution Center', '16');
INSERT INTO `position` VALUES ('127', 'Head Of Distribution Center', '17');
INSERT INTO `position` VALUES ('128', 'Head Of Distribution Center', '18');
INSERT INTO `position` VALUES ('129', 'Head Of Distribution Center', '19');
INSERT INTO `position` VALUES ('130', 'Head Of Distribution Center', '20');
INSERT INTO `position` VALUES ('131', 'Head Of Distribution Center', '21');
INSERT INTO `position` VALUES ('132', 'Head Of Distribution Center', '22');
INSERT INTO `position` VALUES ('133', 'House Keeper', '6');
INSERT INTO `position` VALUES ('134', 'House Keeper', '7');
INSERT INTO `position` VALUES ('135', 'House Keeper', '8');
INSERT INTO `position` VALUES ('136', 'House Keeper', '9');
INSERT INTO `position` VALUES ('137', 'House Keeper', '10');
INSERT INTO `position` VALUES ('138', 'House Keeper', '11');
INSERT INTO `position` VALUES ('139', 'House Keeper', '12');
INSERT INTO `position` VALUES ('140', 'House Keeper', '13');
INSERT INTO `position` VALUES ('141', 'House Keeper', '14');
INSERT INTO `position` VALUES ('142', 'House Keeper', '15');
INSERT INTO `position` VALUES ('143', 'House Keeper', '16');
INSERT INTO `position` VALUES ('144', 'House Keeper', '17');
INSERT INTO `position` VALUES ('145', 'House Keeper', '18');
INSERT INTO `position` VALUES ('146', 'House Keeper', '19');
INSERT INTO `position` VALUES ('147', 'House Keeper', '20');
INSERT INTO `position` VALUES ('148', 'House Keeper', '21');
INSERT INTO `position` VALUES ('149', 'House Keeper', '22');
INSERT INTO `position` VALUES ('150', 'HR Support', '26');
INSERT INTO `position` VALUES ('151', 'HRM Officer', '26');
INSERT INTO `position` VALUES ('152', 'HRM Supervisor', '26');
INSERT INTO `position` VALUES ('153', 'IT & System Division Manager', '27');
INSERT INTO `position` VALUES ('154', 'IT Technician Support Officer', '27');
INSERT INTO `position` VALUES ('155', 'Managing Director', null);
INSERT INTO `position` VALUES ('156', 'Project Coordinator', '23');
INSERT INTO `position` VALUES ('157', 'Project Executive', '23');
INSERT INTO `position` VALUES ('158', 'Project Executive Supervisor', '23');
INSERT INTO `position` VALUES ('159', 'Project Supervisor', '23');
INSERT INTO `position` VALUES ('160', 'Senior Store Officer', '6');
INSERT INTO `position` VALUES ('161', 'Senior Store Officer', '7');
INSERT INTO `position` VALUES ('162', 'Senior Store Officer', '8');
INSERT INTO `position` VALUES ('163', 'Senior Store Officer', '9');
INSERT INTO `position` VALUES ('164', 'Senior Store Officer', '10');
INSERT INTO `position` VALUES ('165', 'Senior Store Officer', '11');
INSERT INTO `position` VALUES ('166', 'Senior Store Officer', '12');
INSERT INTO `position` VALUES ('167', 'Senior Store Officer', '13');
INSERT INTO `position` VALUES ('168', 'Senior Store Officer', '14');
INSERT INTO `position` VALUES ('169', 'Senior Store Officer', '15');
INSERT INTO `position` VALUES ('170', 'Senior Store Officer', '16');
INSERT INTO `position` VALUES ('171', 'Senior Store Officer', '17');
INSERT INTO `position` VALUES ('172', 'Senior Store Officer', '18');
INSERT INTO `position` VALUES ('173', 'Senior Store Officer', '19');
INSERT INTO `position` VALUES ('174', 'Senior Store Officer', '20');
INSERT INTO `position` VALUES ('175', 'Senior Store Officer', '21');
INSERT INTO `position` VALUES ('176', 'Senior Store Officer', '22');
INSERT INTO `position` VALUES ('177', 'System Administrator', '27');
INSERT INTO `position` VALUES ('178', 'Trade Marketing', '28');
INSERT INTO `position` VALUES ('179', 'Web Developer', '27');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'ADMIN');
INSERT INTO `role` VALUES ('2', 'USER');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `active` int(11) DEFAULT NULL,
  `code` varchar(20) DEFAULT NULL,
  `nickname` varchar(30) DEFAULT NULL,
  `gender` varchar(20) DEFAULT NULL,
  `name_english` varchar(255) DEFAULT NULL,
  `startdate` date DEFAULT NULL,
  `prodate_mid` date DEFAULT NULL,
  `prodate_final` date DEFAULT NULL,
  `prodate_end` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `address` text,
  `telephone_private` varchar(30) DEFAULT NULL,
  `telephone_company` varchar(30) DEFAULT NULL,
  `card_id` varchar(20) DEFAULT NULL,
  `bookbank_no` varchar(30) DEFAULT NULL,
  `bookbank_branch` varchar(255) DEFAULT NULL,
  `birthday_card` date DEFAULT NULL,
  `birthday_born` date DEFAULT NULL,
  `recruitment_source` varchar(255) DEFAULT NULL,
  `loc_id` int(11) DEFAULT NULL,
  `pos_id` int(11) DEFAULT NULL,
  `con_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `loc_id` (`loc_id`),
  CONSTRAINT `loc_id` FOREIGN KEY (`loc_id`) REFERENCES `location` (`loc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('4', 'arnont', 'prajonklar', '$2a$10$HAA2uGoYj6SvZiWJxC8EVOhw3ylzovEU9DvMIiIzV2Od9.wuChRoi', 'arnont@mail.com', '1', '136990', 'nont', 'ชาย', 'arnont prajonklar', '2017-10-10', '2017-10-10', '2017-10-10', '2017-10-10', 'yoizrider@mail.com', 'address', '0885161006', '0885161006', '1369900205974', '1369900', 'paradise', '2017-10-10', '2017-10-10', 'HR', '1', '20', '1');
INSERT INTO `user` VALUES ('46', 'arnont', 'prajonklar', '$2a$10$C/8i9uhJeUSGlTV8z/zR/.ch2hhdJ3oL9a2MBeFX8T0hHFDYAP54m', 'yoizrider', '1', '136990', 'nont', 'ชาย', 'arnont prajonklar', '2017-10-10', '2017-10-10', '2017-10-10', '2017-10-10', 'yoizrider@mail.com', 'address', '0885161006', '0885161006', '1369900205974', '1369900', 'paradise', '2017-10-10', '2017-10-10', 'HR', '1', '153', '1');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`),
  CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('4', '1');
INSERT INTO `user_role` VALUES ('46', '2');
