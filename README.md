# Report   
## 注意： 
推荐使用chrome浏览器，不支持IE10以下的浏览器；由于引用的插件较多且没有优化，若部署的服务器网络带宽小，首次加载请耐心等待。     

## 已完成的
**管理员**：添加删除编辑实验室、为某个实验室添加删除编辑老师（可以设置主要负责老师）、为老师和学生重置密码。  
**老师**：批阅周报（打分、评语）、查看别的老师分享的周报、增加删除修改学生、修改周报提交的截止日期、分享周报给别的老师、修改自己的密码。  
**学生**：新建周报、查看自己的所有周报、查看和自己一个老师的同门的周报、查看老师分享的优秀的周报、修改自己的密码。  
## 未完成的
教师修改周报截止时间的功能还无法正常使用。  
没有分页和搜索功能（也无法对用户进行即时搜索选择，只能输入学号和工号）。   
顶部消息提示红点闪烁没有判断功能，好像也没有已读消息区分（但后台已经写了接口）。
## 部署：  
Github版本中login.html,admin_index.html,teacher_index.html,student_index.html中背景没有使用外链视频和图片，但本人实际部署到服务器后使用了腾讯云对象存储加快CDN速度。   
**注意配置mysql的my.ini**   
default-character-set=utf8     
character-set-server=utf8   
如果建立数据库名称report，root密码123456就不需要修改配置文件。
数据库转储文件在sql/BackupDatabase.sql  
## 界面
登录页背景视频+图片，图片可以换成与你相关的图，开发者名字、logo都可以轻易替换。  
欢迎页视差滚动效果，所有控件Bootstrap现代风格。  
AJAX通讯，带通讯时黑色动画遮罩（该插件预定义动画样式和颜色都可以自由替换），通讯结果弹出式提示。  
![图片无法加载](https://raw.githubusercontent.com/chwangteng/Report/master/src/main/resources/screenshots/%E5%B1%8F%E5%B9%95%E6%88%AA%E5%9B%BE(74).png)  
![图片无法加载](https://raw.githubusercontent.com/chwangteng/Report/master/src/main/resources/screenshots/%E5%B1%8F%E5%B9%95%E6%88%AA%E5%9B%BE(75).png)  
![图片无法加载](https://raw.githubusercontent.com/chwangteng/Report/master/src/main/resources/screenshots/%E5%B1%8F%E5%B9%95%E6%88%AA%E5%9B%BE(78).png)  
![图片无法加载](https://raw.githubusercontent.com/chwangteng/Report/master/src/main/resources/screenshots/%E5%B1%8F%E5%B9%95%E6%88%AA%E5%9B%BE(79).png)  
![图片无法加载](https://raw.githubusercontent.com/chwangteng/Report/master/src/main/resources/screenshots/%E5%B1%8F%E5%B9%95%E6%88%AA%E5%9B%BE(80).png)  
![图片无法加载](https://raw.githubusercontent.com/chwangteng/Report/master/src/main/resources/screenshots/%E5%B1%8F%E5%B9%95%E6%88%AA%E5%9B%BE(81).png)  
![图片无法加载](https://raw.githubusercontent.com/chwangteng/Report/master/src/main/resources/screenshots/%E5%B1%8F%E5%B9%95%E6%88%AA%E5%9B%BE(82).png)  
![图片无法加载](https://raw.githubusercontent.com/chwangteng/Report/master/src/main/resources/screenshots/%E5%B1%8F%E5%B9%95%E6%88%AA%E5%9B%BE(83).png)  

