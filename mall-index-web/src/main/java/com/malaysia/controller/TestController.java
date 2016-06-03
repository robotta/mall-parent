package com.malaysia.controller;

import com.malaysia.core.web.RequestforWordUtils;
import com.malaysia.entity.User;
import com.malaysia.util.TemplateConfigUtils;
import freemarker.template.Template;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Administrator on 2016/5/6.
 */

@Controller
@RequestMapping("/index")
public class TestController {

    @RequestMapping("/test")
    public String test(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
       // Template template = TemplateConfigUtils.getTemplateConfig("index.ftl");
        User user = new User();
        user.setAge(12);
        user.setId(1233);
        user.setName("测试");
        List<User> users = new ArrayList<User>();
        users.add(user);
        model.addAttribute("users",users);
        RequestforWordUtils.setPagckageAndResultFileName(request,"index","test.html");
        return "index";

    }


    @RequestMapping("/tmall")
    public String tmall(HttpServletRequest request) throws Exception {
        request.setAttribute("createHtml","index/tmall");
        return "tmall";
    }
}
