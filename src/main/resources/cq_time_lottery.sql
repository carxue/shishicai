/*
Navicat MySQL Data Transfer

Source Server         : 本地虚拟机192.168.110.224
Source Server Version : 50727
Source Host           : 192.168.110.224:3306
Source Database       : xuekui

Target Server Type    : MYSQL
Target Server Version : 50727
File Encoding         : 65001

Date: 2020-01-02 14:18:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cq_time_lottery
-- ----------------------------
DROP TABLE IF EXISTS `cq_time_lottery`;
CREATE TABLE `cq_time_lottery` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `open_date` int(11) NOT NULL,
  `sort_no` varchar(255) NOT NULL,
  `open_num` varchar(255) NOT NULL,
  `zu_third_position123` varchar(255) NOT NULL,
  `zu_third_position124` varchar(255) NOT NULL,
  `zu_third_position125` varchar(255) NOT NULL,
  `zu_third_position134` varchar(255) NOT NULL,
  `zu_third_position135` varchar(255) NOT NULL,
  `zu_third_position145` varchar(255) NOT NULL,
  `zu_third_position234` varchar(255) NOT NULL,
  `zu_third_position235` varchar(255) NOT NULL,
  `zu_third_position245` varchar(255) NOT NULL,
  `zu_third_position345` varchar(255) NOT NULL,
  `zu_five` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2177 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for cq_time_lottery_statistics
-- ----------------------------
DROP TABLE IF EXISTS `cq_time_lottery_statistics`;
CREATE TABLE `cq_time_lottery_statistics` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `open_date` int(11) NOT NULL,
  `zu_third_position123_count` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '0',
  `zu_third_position123_bao_count` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '0',
  `zu_third_position124_count` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '0',
  `zu_third_position124_bao_count` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '0',
  `zu_third_position125_count` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '0',
  `zu_third_position125_bao_count` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '0',
  `zu_third_position134_count` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '0',
  `zu_third_position134_bao_count` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '0',
  `zu_third_position135_count` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '0',
  `zu_third_position135_bao_count` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '0',
  `zu_third_position145_count` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '0',
  `zu_third_position145_bao_count` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '0',
  `zu_third_position234_count` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '0',
  `zu_third_position234_bao_count` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '0',
  `zu_third_position235_count` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '0',
  `zu_third_position235_bao_count` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '0',
  `zu_third_position245_count` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '0',
  `zu_third_position245_bao_count` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '0',
  `zu_third_position345_count` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '0',
  `zu_third_position345_bao_count` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '0',
  `zu_five20_acount` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '0',
  `zu_five30_acount` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '0',
  `zu_five10_acount` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '0',
  `zu_five5_acount` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '0',
  `zu_five120_acount` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2045 DEFAULT CHARSET=utf8mb4;
