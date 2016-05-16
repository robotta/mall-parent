package com.malaysia.core.web;

import com.malaysia.core.Contants;
import freemarker.template.SimpleHash;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Locale;
import java.util.Map;

/**
 * Created by Administrator on 2016/5/6.
 */
public class FreemarkerViewUtil extends FreeMarkerView {

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
        Locale locale = RequestContextUtils.getLocale(request);
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
        //String.valueOf(request.getAttribute("htmlPath");
        String basePath = request.getSession().getServletContext().getRealPath("/");
        File htmlFile = new File(basePath+filePath);
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
        Contants.HTML_MAPPING.put(request.getRequestURI(),filePath);
        request.getRequestDispatcher(RequestforWordUtils.forwordHtml(request)).forward(request, response);
       // response.sendRedirect(RequestforWordUtils.forwordHtml(request));
    }


}
