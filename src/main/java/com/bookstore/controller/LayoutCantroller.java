package com.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LayoutCantroller {
    @RequestMapping("/myaccount")
    public String myAccount(){
        return "myaccount";
    }

    @RequestMapping("/login")
    public String login(){
        return "myaccount";
    }
    @RequestMapping("/forget")
    public String forget(){
        return "myaccount";
    }
}
