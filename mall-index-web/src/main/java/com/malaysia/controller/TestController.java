package com.malaysia.controller;

import com.malaysia.entity.Test;
import com.malaysia.entity.User;
import com.malaysia.service.TestService;
import com.malaysia.web.RequestforWordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @Autowired
    private TestService testService;

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

    @RequestMapping("tt")
    public void getById(HttpServletRequest request) throws  Exception {
       Test tt =  testService.getMemberById(1);
        System.out.print(tt);
    }

}
