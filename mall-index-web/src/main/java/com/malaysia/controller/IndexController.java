package com.malaysia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2016/5/23.
 */

@Controller
@RequestMapping("/index")
public class IndexController {

    @RequestMapping("/index")
    public String init(HttpServletRequest request, HttpServletResponse response) {


        return "test/robotta";
    }

    @RequestMapping("/product")
    public String product(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "test/pl";
    }

    @RequestMapping("/details")
    public String details(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "test/details";
    }
}
