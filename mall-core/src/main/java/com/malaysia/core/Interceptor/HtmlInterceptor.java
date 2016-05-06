package com.malaysia.core.Interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.HashMap;

/**
 * Created by Administrator on 2016/5/6.
 */
public class HtmlInterceptor implements HandlerInterceptor {
    private static final HashMap<String,String> HTML_MAPPING = new HashMap<String,String>();

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String urlBorw= request.getServletPath();
        String htmlUrl = HTML_MAPPING.get(urlBorw);
        if(null != htmlUrl && htmlUrl.length()>0) {
            File file = new File(request.getSession().getServletContext().getRealPath("")+htmlUrl);
            if(file.exists()) {
                request.getRequestDispatcher(htmlUrl).forward(request,response);
                return false;
            }else {
                return true;
            }
        }
        return false;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
