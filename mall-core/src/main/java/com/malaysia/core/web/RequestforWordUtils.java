package com.malaysia.core.web;

import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

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

    public static String langeuageIndex(HttpServletRequest request) {
        Locale locale = RequestContextUtils.getLocale(request);
        String index = "";
        if(locale.toString().toLowerCase().equals("zh_cn")){
            index = "1";
        }else if(locale.toString().toLowerCase().equals("en")){
            index = "2";
        }else if(locale.toString().toLowerCase().equals("en_id")){
            index="3";
        }else if(locale.toString().toLowerCase().equals("en_th")){
            index="4";
        }else if(locale.toString().toLowerCase().equals("en_my")){
            index="5";
        }
        return index;
    }


    /**
     * 设置静态静态页面返回
     * @param request
     * @param pageckDir  文件夹名
     * @param fileName 文件名（要生成的文件）
     */
    public static void setPagckageAndResultFileName(HttpServletRequest request, String pageckDir, String fileName) {
        request.setAttribute("createHtml",pageckDir+"/"+ RequestforWordUtils.langeuageIndex(request)+"-"+fileName);
    }

}
