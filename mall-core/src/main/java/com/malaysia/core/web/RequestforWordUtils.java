package com.malaysia.core.web;

import com.malaysia.core.Contants;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2016/5/16.
 */
public class RequestforWordUtils {
    /**
     * 路劲重置
     * @param request
     * @return
     */
    public static String forwordHtml(HttpServletRequest request) {
        String html = String.valueOf(request.getAttribute("createHtml"));
        html = html.substring(html.indexOf("/")+1);

        return html;
    }

}
