package com.chwangteng.www.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chwangteng.www.Utils.ConstVar;
import com.chwangteng.www.Utils.SendMsgUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;


public class CustomInterceptor implements HandlerInterceptor{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HttpSession session = request.getSession();
        if (session.getAttribute(ConstVar._SESSION_USER_ID_) != null)
            return true;

        //拦截未登录时对API的操作
        Map<String,Object> map = new HashMap<String,Object>();
        map.put(ConstVar._KEY_CODE_, ConstVar._ERROR_NOTLOGIN_);
        map.put(ConstVar._KEY_MESSAGE_, "未登录，没有权限");
        SendMsgUtil.sendJsonMessage(response,map);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        //System.out.println("---------postHandle--------");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        //System.out.println("---------afterCompletion--------");
    }

}
