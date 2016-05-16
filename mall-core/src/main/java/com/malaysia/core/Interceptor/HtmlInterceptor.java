package com.malaysia.core.Interceptor;

import com.malaysia.core.Contants;
import com.malaysia.core.web.RequestforWordUtils;
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

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String urlBorw= request.getServletPath();
        System.out.print(urlBorw);
        String htmlUrl = Contants.HTML_MAPPING.get(urlBorw);
        if(null != htmlUrl && htmlUrl.length()>0) {
            System.out.println(request.getSession().getServletContext().getRealPath(""));
            File file = new File(request.getSession().getServletContext().getRealPath("")+"/"+htmlUrl);
            if(file.exists()) {
                request.setAttribute("createHtml",htmlUrl);
                request.getRequestDispatcher(RequestforWordUtils.forwordHtml(request)).forward(request,response);
                return false;
            }else {
                return true;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
