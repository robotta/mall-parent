package com.malaysia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2016/5/23.
 */

@Controller
@RequestMapping("/temp")
public class JdTempController {

    @RequestMapping("/index")
    public String jingdong(HttpServletRequest request) throws Exception {

        return "temp/jingdong";
    }

    @RequestMapping("/shop")
    public String shop(HttpServletRequest request) throws Exception {

        return "temp/shop";
    }
}
