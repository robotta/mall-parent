package com.malaysia.controller;

import com.malaysia.entity.User;
import com.malaysia.util.TemplateConfigUtils;
import freemarker.template.Template;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

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
        request.setAttribute("createHtml","index/test");
        return "index";

    }

}
