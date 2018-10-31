package com.mayousheng.www.resolver;

import com.mayousheng.www.exception.UsernameDuplicateException;
import org.apache.log4j.Logger;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class MyExceptionHandler implements HandlerExceptionResolver {
    private Logger logger = Logger.getLogger(MyExceptionHandler.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
                                         Exception ex) {
        logger.error(ex.getMessage(),ex);
/*        if(ex instanceof MaxUploadSizeExceededException){
            map.put("msg", "文件大小超过限制!");
            return new ModelAndView(new MappingJackson2JsonView(),map);
        }*/
        Map<String,Object> map = new HashMap<String,Object>();
        if(ex instanceof UsernameDuplicateException){
            map.put("code", -1);
            map.put("message", "学号/工号已经注册");
            return new ModelAndView(new MappingJackson2JsonView(),map);
        }

        map.put("code", -1);
        map.put("message", "服务器错误，请稍后再试");
        return new ModelAndView(new MappingJackson2JsonView(),map);
    }
}
