package com.juphoon.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author rongbin.huang
 * @create 2018-10-12 下午4:51
 **/
@Controller
public class HomeController {

    @RequestMapping("/")
    public String login() {
        return "redirect:/login.html";
    }

}
