/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : localhost:3306
 Source Schema         : report

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 08/12/2018 15:54:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `token` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'admin', 'admin', NULL, '超级管理员');

-- ----------------------------
-- Table structure for authority
-- ----------------------------
DROP TABLE IF EXISTS `authority`;
CREATE TABLE `authority`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teacher_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `user_type` int(11) NOT NULL,
  `report_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `ref_teacher_auth`(`teacher_id`) USING BTREE,
  INDEX `ref_report_auth`(`report_id`) USING BTREE,
  INDEX `ref_user_auth`(`user_id`) USING BTREE,
  CONSTRAINT `ref_report_auth` FOREIGN KEY (`report_id`) REFERENCES `report` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `ref_teacher_auth` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of authority
-- ----------------------------
INSERT INTO `authority` VALUES (1, 5, 1, 3, 18);
INSERT INTO `authority` VALUES (7, 3, 3, 3, 15);

-- ----------------------------
-- Table structure for laboratory
-- ----------------------------
DROP TABLE IF EXISTS `laboratory`;
CREATE TABLE `laboratory`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teacher_id` int(11) NULL DEFAULT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `address` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `about` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `ref_teacher`(`teacher_id`) USING BTREE,
  CONSTRAINT `ref_teacher` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of laboratory
-- ----------------------------
INSERT INTO `laboratory` VALUES (1, 2, '人工智能aaaaaaa(别删)', 'aaaaa417', 'aaaaaa研发。');
INSERT INTO `laboratory` VALUES (2, NULL, '嵌入aaaaa验室', NULL, NULL);
INSERT INTO `laboratory` VALUES (3, NULL, '老杨aaaaa', 'dddddd', 'ddddd');
INSERT INTO `laboratory` VALUES (11, NULL, 'dfghfgdhhfdg', 'fghfghhgf', 'fdghfdgh');

-- ----------------------------
-- Table structure for motification
-- ----------------------------
DROP TABLE IF EXISTS `motification`;
CREATE TABLE `motification`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id_mo` int(11) NOT NULL,
  `user_type_mo` int(11) NOT NULL,
  `generate_time_mo` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `title_mo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `content_mo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `read_mo` int(11) NOT NULL DEFAULT -1,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of motification
-- ----------------------------
INSERT INTO `motification` VALUES (1, 1, 3, '2018-12-06 00:43:32', '您收到一篇新的周报推荐', '杨柏林给您分享了一篇周报，请在分享周报中查阅', -1);
INSERT INTO `motification` VALUES (4, 3, 3, '2018-12-07 00:15:21', '您收到一篇新的周报推荐', '王慧燕给您分享了一篇周报，请在分享周报中查阅', -1);

-- ----------------------------
-- Table structure for report
-- ----------------------------
DROP TABLE IF EXISTS `report`;
CREATE TABLE `report`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `this_week` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `bug_meet` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `next_week` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `student_id` int(11) NOT NULL,
  `pv` int(255) NULL DEFAULT 0,
  `score` int(255) NULL DEFAULT NULL,
  `reply` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `submit_time` timestamp(0) NULL DEFAULT NULL,
  `reply_time` timestamp(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `ref_student`(`student_id`) USING BTREE,
  INDEX `title_index`(`title`) USING BTREE,
  CONSTRAINT `ref_student` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of report
-- ----------------------------
INSERT INTO `report` VALUES (15, 'ss的周报-11月5日', '<div>&nbsp; &nbsp; &nbsp; &nbsp;计算机视觉就是用各种成象系统代替视觉器官作为输入敏感手段，由计算机来代替大脑完成处理和解释。</div><div><br></div><div>&nbsp; &nbsp; &nbsp; &nbsp; 计算机视觉的最终研究目标就是使计算机能象人那样通过视觉观察和理解世界，具有自主适应环境的能力。</div><div><br></div><div>&nbsp; &nbsp; &nbsp; &nbsp; 在实现最终目标以前，人们努力的中期目标是建立一种视觉系统，这个系统能依据视觉敏感和反馈的某种程度的智能完成一定的任务。例如，计算机视觉的一个重要应用领域就是自主车辆的视觉导航，还没有条件实现象人那样能识别和理解任何环境，完成自主导航的系统。</div><div><br></div><div>&nbsp; &nbsp; &nbsp; &nbsp; 在计算机视觉系统中计算机起代替人脑的作用，但并不意味着计算机必须按人类视觉的方法完成视觉信息的处理。计算机视觉可以而且应该根据计算机系统的特点来进行视觉信息的处理。因此，用计算机信息处理的方法研究人类视觉的机理，建立人类视觉的计算理论，也是一个非常重要和信人感兴趣的研究领域。这方面的研究被称为计算视觉。计算视觉可被认为是计算机视觉中的一个研究领域。</div>', '&nbsp; &nbsp; 1、学习了吴恩达老师微专业课《深度学习工程师》&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;第三篇：结构化机器学习项目<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;第二周内容：机器学习（ML）策略（2）<br></span>&nbsp; &nbsp; 2、学习了两节李飞飞计算机视觉的课程<span>&nbsp;&nbsp; &nbsp;3、跑了一个 小的分类模型<span>&nbsp; &nbsp;</span></span>', '&nbsp;1、继续学习吴恩达老师的微专业课程<span>&nbsp; &nbsp; 2、再找一些小的Demo、看一些源码</span><span>&nbsp; &nbsp; 3、<span>学习机器学习内容</span></span>', 1, 0, 86, '一般般吧一般般吧一般般吧一般般吧一般般吧一般般吧一般般吧一般般吧', '2018-12-05 19:15:04', '2018-12-06 18:07:50');
INSERT INTO `report` VALUES (16, 'ss的周报-11月5日', '<div>1.&nbsp; &nbsp; &nbsp;完成对JSP的基础学习。</div><div><br></div><div>2.&nbsp; &nbsp; &nbsp;继续期末复习。</div><div><br></div><div>3.&nbsp; &nbsp; &nbsp;对javascript的项目的初级学习。</div><div><br></div><div>本周总结：</div><div><br></div><div>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;这个周的话感觉状态并不好，一是因为接近期末了，我担心期末的考试。二是因为我感觉这个周的精神状况不太乐观，也许是因为自己没有调整好吧。</div><div><br></div><div>&nbsp; &nbsp; &nbsp;还有就是跟着李老师的视频在做javascript的小项目，感觉一个动态的网页要加的东西还是非常多的，比如Ajax、javascript、XML、Dom等。有些东西有点了解，有些的话就不了解了，其实觉得期末考试挺烦的，现在又要抽很多的时间来应对期末考试。什么知识点啊，考点啊啥的都没有除了英语老师说了一点关于考试的重点范围的，其他科的考试范围就是这学期学的所有东西。就感觉什么东要靠自己去做。就像离散一样，一面下来定义多得可怜，记定义就像是记英语单词一样，老多老多了，现在复习离散就像是预习离散一样。</div><div><br></div><div>&nbsp; &nbsp; &nbsp; 没办法，期末就在那摆着，任务也在那摆着就如同我还是要吃饭一样，Just do it 了。反正要有意义的生活就要付出精力和体力。</div>', '<div>1.&nbsp; &nbsp; &nbsp;完成对JSP的基础学习。</div><div><br></div><div>2.&nbsp; &nbsp; &nbsp;继续期末复习。</div><div><br></div><div>3.&nbsp; &nbsp; &nbsp;对javascript的项目的初级学习。</div><div><br></div><div>本周总结：</div><div><br></div><div>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;这个周的话感觉状态并不好，一是因为接近期末了，我担心期末的考试。二是因为我感觉这个周的精神状况不太乐观，也许是因为自己没有调整好吧。</div><div><br></div><div>&nbsp; &nbsp; &nbsp;还有就是跟着李老师的视频在做javascript的小项目，感觉一个动态的网页要加的东西还是非常多的，比如Ajax、javascript、XML、Dom等。有些东西有点了解，有些的话就不了解了，其实觉得期末考试挺烦的，现在又要抽很多的时间来应对期末考试。什么知识点啊，考点啊啥的都没有除了英语老师说了一点关于考试的重点范围的，其他科的考试范围就是这学期学的所有东西。就感觉什么东要靠自己去做。就像离散一样，一面下来定义多得可怜，记定义就像是记英语单词一样，老多老多了，现在复习离散就像是预习离散一样。</div><div><br></div><div>&nbsp; &nbsp; &nbsp; 没办法，期末就在那摆着，任务也在那摆着就如同我还是要吃饭一样，Just do it 了。反正要有意义的生活就要付出精力和体力。</div>', '<div>1.&nbsp; &nbsp; &nbsp;完成对JSP的基础学习。</div><div><br></div><div>2.&nbsp; &nbsp; &nbsp;继续期末复习。</div><div><br></div><div>3.&nbsp; &nbsp; &nbsp;对javascript的项目的初级学习。</div><div><br></div><div>本周总结：</div><div><br></div><div>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;这个周的话感觉状态并不好，一是因为接近期末了，我担心期末的考试。二是因为我感觉这个周的精神状况不太乐观，也许是因为自己没有调整好吧。</div><div><br></div><div>&nbsp; &nbsp; &nbsp;还有就是跟着李老师的视频在做javascript的小项目，感觉一个动态的网页要加的东西还是非常多的，比如Ajax、javascript、XML、Dom等。有些东西有点了解，有些的话就不了解了，其实觉得期末考试挺烦的，现在又要抽很多的时间来应对期末考试。什么知识点啊，考点啊啥的都没有除了英语老师说了一点关于考试的重点范围的，其他科的考试范围就是这学期学的所有东西。就感觉什么东要靠自己去做。就像离散一样，一面下来定义多得可怜，记定义就像是记英语单词一样，老多老多了，现在复习离散就像是预习离散一样。</div><div><br></div><div>&nbsp; &nbsp; &nbsp; 没办法，期末就在那摆着，任务也在那摆着就如同我还是要吃饭一样，Just do it 了。反正要有意义的生活就要付出精力和体力。</div>', 1, 0, NULL, NULL, '2018-12-05 19:16:01', NULL);
INSERT INTO `report` VALUES (18, 'sss的周报-11月5日', '<b><u>我是一包糖我是一包糖我是一包糖我是一包糖我是一包糖我是一包糖我是一包糖我是一包糖我是一包糖我是一包糖我是一包糖我是一包糖我是一包糖我是一包糖我是一包糖我是一包糖我是一包糖我是一包糖我是一包糖我是一包糖我是一包糖我是一包糖我是一包糖我是一包糖我是一包糖我是一包糖我是一包糖我是一包糖我是一包糖我是一包糖我是一包糖我是一包糖</u></b>', '我是一包糖我是一包糖我是一包糖我是一包糖我是一包糖我是一包糖我是一包糖我是一包糖我是一包糖我是一包糖我是一包糖我是一包糖我是一包糖我是一包糖我是一包糖我是一包糖我是一包糖我是一包糖我是一包糖我是一包糖我是一包糖我是一包糖我是一包糖我是一包糖我是一包糖我是一包糖我是一包糖我是一包糖v', '我是一包糖我是一包糖我是一包糖我是一包糖我是一包糖我是一包糖我是一包糖我是一包糖我是一包糖我是一包糖我是一包糖我是一包糖', 3, 0, 100, '写得太好了，老师很看好你哦', '2018-12-05 21:25:10', '2018-12-05 21:26:38');
INSERT INTO `report` VALUES (19, 'sss的周报-11月6日', '<h1>这是一篇有样式的周报</h1><h3>这是一篇有样式的周报</h3><b>这是一篇有样式的周报</b><br><i>这是一篇有样式的周报</i><br><u>这是一篇有样式的周报<br></u><br>这是一篇有样式的周报<br>这是一篇有样式的周报<br><a href=\"http://baidu.com\" target=\"_blank\" rel=\"nofollow\">这是一篇有样式的周报</a><br>上面是一个链接<br>', '啊大大十分但是发放', '撒打发发达', 2, 0, 96, 'sss', '2018-12-06 17:56:48', '2018-12-06 23:07:45');
INSERT INTO `report` VALUES (20, 'sss的周报-11月6日', '<h2><b><i><u>据说要字写的长老师才会注意到我的周报<br><br></u></i></b></h2>', '没什么困难啊，太优秀了<br><img src=\"http://img.027cgb.com/612107/201871411545849481.gif\"><br>', '下周就是继续优秀啊。<br><img src=\"http://img.027cgb.com/612107/201711513421988336.jpg\"><br>', 1, 0, 0, '周报里用表情包？期末考零分', '2018-12-06 18:04:16', '2018-12-06 18:06:43');
INSERT INTO `report` VALUES (21, 'ss英的周报-11月6日', '这周我很认真呀', 'xinded&nbsp;', 'xinded&nbsp;<br><br><img src=\"http://img.027cgb.com/612107/201711513421988336.jpg\"><br>', 2, 0, NULL, NULL, '2018-12-06 21:49:06', NULL);
INSERT INTO `report` VALUES (22, 'sss的周报-11月6日', '这周我干了什么呢', '', '', 2, 0, NULL, NULL, '2018-12-06 22:12:46', NULL);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sex` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `telephone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mail` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `token` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `teacher_id` int(11) NULL DEFAULT NULL,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username_unique`(`username`) USING BTREE,
  INDEX `ref_teacher_id`(`teacher_id`) USING BTREE,
  CONSTRAINT `ref_teacher_id` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, '1', '17816875157', 'chwangteng@126.com', NULL, 'aa（别删）', 3, '18020100027', '100027');
INSERT INTO `student` VALUES (2, '-1', '13616852042', 'haiyinchen@126.com', NULL, 'bb（别删）', 3, '18020100028', '100028');
INSERT INTO `student` VALUES (3, '1', '17195818118', 'yibaotang@126.com', NULL, 'cc', 4, '18020100029', '100029');
INSERT INTO `student` VALUES (5, NULL, NULL, NULL, NULL, '用来删的1', 3, NULL, NULL);
INSERT INTO `student` VALUES (7, NULL, NULL, NULL, NULL, '用来补全信息的1', 3, NULL, NULL);
INSERT INTO `student` VALUES (8, '-1', '110', '', NULL, '用来补全信息的2', 3, NULL, NULL);
INSERT INTO `student` VALUES (9, '1', '1212', '12312312', NULL, '测试的新增', 3, '18020100099', '100099');
INSERT INTO `student` VALUES (11, '-1', '11111111', '111111111111', NULL, '测试的学生', 15, '1234567890', '567890');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `is_supervisor` int(11) NOT NULL DEFAULT -1,
  `about` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `telephone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mail` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `token` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `lab_id` int(11) NULL DEFAULT NULL,
  `deadline` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'Sun2200',
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE,
  INDEX `ref_lab`(`lab_id`) USING BTREE,
  CONSTRAINT `ref_lab` FOREIGN KEY (`lab_id`) REFERENCES `laboratory` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (2, 1, 'sdfsdf计划', '男', '17816875157', 'jindfdfdfddfdfdf', NULL, 'ddd', 1, 'Sun2200', '18020100027', '100027');
INSERT INTO `teacher` VALUES (3, -1, '115人才第三层次', '女', '17195818118', 'cedfdfdfd.cn', NULL, '王gffg', 1, 'Sun2200', '18020100028', '100028');
INSERT INTO `teacher` VALUES (4, -1, '蝉联sdfsdf师', '女', '17818273681', 'zdfdfdfddfdcn', NULL, 'df', 1, 'Sun2200', '18020100029', '100029');
INSERT INTO `teacher` VALUES (5, -1, '副dfdf', '男', '13616852222', '@dfdfdfdffdf.cn', NULL, '杨dfd', 3, 'Sun2200', '18020100030', '100030');
INSERT INTO `teacher` VALUES (7, -1, '345345435345', '女', '345345345', '345345345', NULL, '老dfdf', 11, 'Sun2200', '34545345345', '345345');
INSERT INTO `teacher` VALUES (8, -1, '345345345', '男', '345435453', '345345', NULL, '345435435', 11, 'Sun2200', '345345345', '345345');
INSERT INTO `teacher` VALUES (9, -1, '22222', '女', '2222222222222', '222222222222222222', NULL, '22222222222', 11, 'Sun2200', '2222222222222222', '222222');
INSERT INTO `teacher` VALUES (10, -1, '546456546', '男', '456546', '456456', NULL, 'llllllllllllll', 11, 'Sun2200', '7645654', '645654');
INSERT INTO `teacher` VALUES (12, 1, '测试测试测试测试测试', '女', '12121212121212', '21212121211121212', NULL, '测试测试', 11, 'Sun2200', '1212121212121212', '121212');
INSERT INTO `teacher` VALUES (14, -1, '5464545645', '男', '456456456456', '456456456456', NULL, '456456456', 2, 'Sun2200', '546456456456456456', '456456');
INSERT INTO `teacher` VALUES (15, -1, '11111111111111111', '男', '1111111111111', '111111111111111', NULL, '测试的姓名', 11, 'Sun2200', '1234567890', '567890');

SET FOREIGN_KEY_CHECKS = 1;
