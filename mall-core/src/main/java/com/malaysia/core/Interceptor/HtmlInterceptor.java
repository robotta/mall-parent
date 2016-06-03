package com.malaysia.core.Interceptor;

import com.malaysia.core.Contants;
import com.malaysia.core.web.RequestforWordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.HashMap;
import java.util.Locale;

/**
 * Created by Administrator on 2016/5/6.
 */
public class HtmlInterceptor implements HandlerInterceptor {

    @Autowired
    CookieLocaleResolver resolver;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Locale locale = resolver.resolveLocale(request);
        String urlBorw= request.getServletPath()+"_"+locale;
        String htmlUrl = Contants.HTML_MAPPING.get(urlBorw);
        if(null != htmlUrl && htmlUrl.length()>0) {
            String langPath = request.getSession().getServletContext().getRealPath("/");
            File file = new File(langPath+"/"+htmlUrl);
            if(file.exists()) {
                request.setAttribute("createHtml",htmlUrl);
                request.getRequestDispatcher(RequestforWordUtils.forwordHtml(request)).forward(request,response);
                //response.sendRedirect(Contants.default_parent_html+htmlUrl);
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
