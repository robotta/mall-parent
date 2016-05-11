package com.malaysia.controller;

import com.malaysia.entity.User;
import com.malaysia.util.TemplateConfigUtils;
import freemarker.template.Template;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2016/5/6.
 */

@Controller
public class TestController {

    @RequestMapping("test")
    public String test(HttpServletRequest request, HttpServletResponse response) throws Exception {
       // Template template = TemplateConfigUtils.getTemplateConfig("index.ftl");
        User user = new User();
        user.setAge(12);
        user.setId(1233);
        user.setName("测试");
        request.setAttribute("user",user);
        return "index";

    }

}
