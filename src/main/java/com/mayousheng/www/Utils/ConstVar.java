package com.mayousheng.www.Utils;

public class ConstVar {
    //三种用户分类
    public static int _ADMIN_ = 1; //管理员
    public static int _TEACHER_ =2; //老师
    public static int _STUDENT_ =3; //学生


    //错误类型
    public static int _ERROR_COMMON_ = -1; //通用错误
    public static int _ERROR_NOTFOUND = -2; //数据库中未找到记录
    public static int _ERROR_DUPLICATE_ = -3; //数据库中违反UNIQUE约束违反
}
