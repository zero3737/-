/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : zy-nbz

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 22/09/2019 23:37:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for zy_nbz_admin
-- ----------------------------
DROP TABLE IF EXISTS `zy_nbz_admin`;
CREATE TABLE `zy_nbz_admin`  (
  `adminname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `e_mail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`adminname`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of zy_nbz_admin
-- ----------------------------
INSERT INTO `zy_nbz_admin` VALUES ('admin1', 'e10adc3949ba59abbe56e057f20f883e', '2654092834@qq.com', '2019-09-09 12:04:58');

-- ----------------------------
-- Table structure for zy_nbz_admin_role
-- ----------------------------
DROP TABLE IF EXISTS `zy_nbz_admin_role`;
CREATE TABLE `zy_nbz_admin_role`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `adminname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `role` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of zy_nbz_admin_role
-- ----------------------------
INSERT INTO `zy_nbz_admin_role` VALUES ('e62aa575001e4b5bae5e67470d8a2954', 'admin1', 'admin', '2019-09-09 14:32:10');

-- ----------------------------
-- Table structure for zy_nbz_cms
-- ----------------------------
DROP TABLE IF EXISTS `zy_nbz_cms`;
CREATE TABLE `zy_nbz_cms`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `template_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `body` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `image_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of zy_nbz_cms
-- ----------------------------
INSERT INTO `zy_nbz_cms` VALUES ('0a14a0558bde4917af99c79e19e78cb4', '图片在左边', '“影星”总统泽连斯基承诺将乌克兰打造成电影强国', '据俄罗斯卫星通讯社报道，乌克兰最高拉达周四（12日）通过了乌克兰预算法修正案，该法案通过确立国家预算保护条款以确保稳定的电影融资，还为吸引私人资金进入电影行业建立了机制。\r\n泽连斯基此前承诺，将尽一切努力，“为每一个有能力的乌克兰人开辟一条道路，让他们首先在自己的国家自由实施自己的倡议。” 泽连斯基称，“让乌克兰成为我们的天才继续征服世界的基地。”', '/images/2019/09/15/1568540397382.jpg', '2019-09-15 09:39:57');
INSERT INTO `zy_nbz_cms` VALUES ('8aa89af685bb4cdcb7612744cf1f5167', '图片在右边', '真香！iPhone11预售卖断货，但苹果市值蒸发了1300亿元', '昨天（9月13日）晚上20点，iPhone 11 开始预售，暗夜绿一度抢断货！\r\n除了苹果中国官网外，此次iPhone 11 系列预售的平台还有天猫和京东。\r\n据了解，昨晚预售开始后，相当一部分人还是在第一时间冲进了苹果官网、天猫、京东等平台选择下单购买，三个平台一度都出现了卡顿的情况。\r\n手速快的人，抢到后立马在朋友圈晒了单。嗯，一起感受下~~', '/images/2019/09/15/1568541568785.jpg', '2019-09-15 09:59:29');
INSERT INTO `zy_nbz_cms` VALUES ('97bfce14c43149869b94aadd8176c57d', '顶部图片', '西藏环保成效如何？书记：野驴都跑到了公路边', '9月12日上午，国务院新闻办公室举行省(区、市)系列新闻发布会。西藏自治区委员会书记吴英杰，西藏自治区委员会副书记、自治区人民政府主席齐扎拉围绕“加强民族团结 建设美丽西藏”作介绍，并答记者问。\r\n吴英杰在回答记者关于西藏环境保护的问题时表示，西藏环境保护得很好，环境保护在西藏已经形成了共识。他还说，冈仁布齐和珠峰大本营等地区的野驴都跑到了路边上。', '/images/2019/09/13/1568307599055.jpg', '2019-09-12 16:59:59');
INSERT INTO `zy_nbz_cms` VALUES ('a1aa869af229417cacbeeb2c014e8254', '顶部图片', '俄罗斯待够了？斯诺登：希望德法提供庇护', '现居住在俄罗斯的“棱镜门”揭秘者爱德华·斯诺登（Edward Snowden），近日频繁接受欧洲媒体采访，在披露自己在俄罗斯的生活现状后，继续呼吁欧洲各国能够给予自己庇护。\r\n\r\n在德国《世界报》9月13日刊登的采访中，斯诺登表达了自己希望离开俄罗斯的想法，提出“如果德国政府愿意接纳自己的话”，希望得到德国政府的庇护；甚至，如果美政府承诺公正客观地审判，他愿意回国。', '/images/2019/09/15/1568542000849.jpg', '2019-09-15 10:06:41');

-- ----------------------------
-- Table structure for zy_nbz_role
-- ----------------------------
DROP TABLE IF EXISTS `zy_nbz_role`;
CREATE TABLE `zy_nbz_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of zy_nbz_role
-- ----------------------------
INSERT INTO `zy_nbz_role` VALUES (1, 'admin');
INSERT INTO `zy_nbz_role` VALUES (2, 'guest');

-- ----------------------------
-- Table structure for zy_nbz_user
-- ----------------------------
DROP TABLE IF EXISTS `zy_nbz_user`;
CREATE TABLE `zy_nbz_user`  (
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `e_mail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of zy_nbz_user
-- ----------------------------
INSERT INTO `zy_nbz_user` VALUES ('ljl1', 'e10adc3949ba59abbe56e057f20f883e', '2654092834@qq.com', '2019-09-07 14:42:24');

SET FOREIGN_KEY_CHECKS = 1;
