package com.malaysia.core.shiro;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 重写shiro资源匹配
 * Created by abner on 2016/3/17.
 */
public class ResourceCheckFilter extends AccessControlFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        Subject subject = getSubject(request,response);
        String url = getPathWithinApplication(request);
        return subject.isPermitted(url);
    }

    /**
     * 规则匹配不上，执行
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest hRequest = (HttpServletRequest) request;
        HttpServletResponse hResponse = (HttpServletResponse) response;
        hResponse.sendRedirect(hRequest.getContextPath()+"/error.jsp");
        /**
         * 执行当前登录用户所属的授权页面
         * response.sendRedirect();
         */
        return false;
    }

}
