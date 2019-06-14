/*
Navicat MySQL Data Transfer

Source Server         : 阿里云
Source Server Version : 50724
Source Host           : youxiu326.xin:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2019-01-26 19:25:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for group_
-- ----------------------------
DROP TABLE IF EXISTS `group_`;
CREATE TABLE `group_` (
  `group_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `group_name` varchar(254) NOT NULL DEFAULT '',
  PRIMARY KEY (`group_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of group_
-- ----------------------------
INSERT INTO `group_` VALUES ('1', 'Group-1');
INSERT INTO `group_` VALUES ('2', 'Group-2');

-- ----------------------------
-- Table structure for post
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post` (
  `post_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(10) unsigned NOT NULL,
  `title` varchar(254) NOT NULL DEFAULT '',
  `content` varchar(256) DEFAULT NULL,
  `created` datetime NOT NULL,
  PRIMARY KEY (`post_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of post
-- ----------------------------
INSERT INTO `post` VALUES ('1', '1', 'MyBatis关联数据查询', '在实际项目中，经常使用关联表的查询，比如：多对一，一对多等。这些查询是如何处理的呢，这一讲就讲这个问题。我们首先创建一个 post 表，并初始化数据.', '2015-09-23 21:40:17');
INSERT INTO `post` VALUES ('2', '1', 'MyBatis开发环境搭建', '为了方便学习，这里直接建立java 工程，但一般都是开发 Web 项目。', '2015-09-23 21:42:14');
INSERT INTO `post` VALUES ('3', '2', '这个是别人发的', 'content,内容...', '1998-05-05 00:00:00');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` bigint(20) NOT NULL COMMENT '主键ID',
  `name` varchar(30) DEFAULT NULL COMMENT '姓名',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', 'Jone', '18', 'test1@baomidou.com');
INSERT INTO `student` VALUES ('2', 'Jack', '20', 'test2@baomidou.com');
INSERT INTO `student` VALUES ('3', 'Tom', '28', 'test3@baomidou.com');
INSERT INTO `student` VALUES ('4', 'Sandy', '21', 'test4@baomidou.com');
INSERT INTO `student` VALUES ('5', 'Billie', '24', 'test5@baomidou.com');
INSERT INTO `student` VALUES ('6', null, '24', 'test6@qq.com');
INSERT INTO `student` VALUES ('7', 'TomT', '15', 'test7@baomidou.com');

-- ----------------------------
-- Table structure for student_group
-- ----------------------------
DROP TABLE IF EXISTS `student_group`;
CREATE TABLE `student_group` (
  `student_id` int(10) unsigned NOT NULL DEFAULT '0',
  `group_id` int(10) unsigned NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of student_group
-- ----------------------------
INSERT INTO `student_group` VALUES ('1', '1');
INSERT INTO `student_group` VALUES ('2', '1');
INSERT INTO `student_group` VALUES ('1', '2');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(64) NOT NULL DEFAULT '',
  `mobile` int(10) unsigned NOT NULL DEFAULT '0',
  `created` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'yiibai', '100', '2015-09-23 20:11:23');
