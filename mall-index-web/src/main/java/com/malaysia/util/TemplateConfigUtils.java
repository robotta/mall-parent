package com.malaysia.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import java.io.IOException;

/**
 * Created by Administrator on 2016/5/9.
 */
public class TemplateConfigUtils {

    @Autowired
    private static FreeMarkerConfigurer freeMarkerConfigurer;

    public static Template getTemplateConfig(String templateName) throws IOException {
        Configuration configuration = freeMarkerConfigurer.getConfiguration();
        Template template = configuration.getTemplate(templateName);
        return template;
    }
}
