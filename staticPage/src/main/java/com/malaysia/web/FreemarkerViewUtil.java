package com.malaysia.web;

import com.malaysia.util.Contants;
import freemarker.template.SimpleHash;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Locale;
import java.util.Map;

/**
 * 静态化页面生成
 * Created by zhaoyun on 2016/5/6.
 */
public class FreemarkerViewUtil extends FreeMarkerView {
    private Locale locale = null;
    @Override
    protected void doRender(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        // Expose model to JSP tags (as request attributes).
        exposeModelAsRequestAttributes(model, request);
        // Expose all standard FreeMarker hash models.
        SimpleHash fmModel = buildTemplateModel(model, request, response);
        if (logger.isDebugEnabled()) {
            logger.debug("Rendering FreeMarker template [" + getUrl() + "] in FreeMarkerView '" + getBeanName() + "'");
        }
        // Grab the locale-specific version of the template.
        locale = RequestContextUtils.getLocale(request);
        if (null != request.getAttribute("createHtml") && String.valueOf(request.getAttribute("createHtml")).length() > 0) {
            createHTML(getTemplate(locale),fmModel, request, response);
        } else
        {
            processTemplate(getTemplate(locale), fmModel, response);
        }

    }

    public void createHTML(Template template, SimpleHash model, HttpServletRequest request, HttpServletResponse response)
            throws IOException, TemplateException, ServletException {
        String filePath = String.valueOf(request.getAttribute("createHtml"));
        String basePath = request.getSession().getServletContext().getRealPath("/");
        File htmlFile = new File(basePath+Contants.default_parent_html+filePath); // 创建区域文件
        if (!htmlFile.getParentFile().exists()) {
            htmlFile.getParentFile().mkdirs();
        }
        if (!htmlFile.exists()) {
            htmlFile.createNewFile();
        }
        Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(htmlFile), "UTF-8"));
        //处理模版
        template.process(model, out);
        out.flush();
        out.close();
        Contants.HTML_MAPPING.put(request.getRequestURI()+"_"+locale,filePath);
        response.sendRedirect(Contants.default_parent_html+filePath);
        //request.getRequestDispatcher(RequestforWordUtils.forwordHtml(request)).forward(request, response);
    }


    /**
     * 根据不同语言生成不同的模板文件
     * @author zhaoyun
     * Created by zhaoyun on 2016/06/12
     */
    public void createFileForLanguage(Template template, SimpleHash model, HttpServletRequest request, HttpServletResponse response) {

    }
}
