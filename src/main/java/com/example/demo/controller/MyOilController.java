package com.example.demo.controller;

import com.example.demo.service.LoginService;
import com.example.demo.service.MyOilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MyOilController {
    @Autowired
    MyOilService myOilService;

    @Autowired
    LoginService loginService;

    @GetMapping("/myoil")
    public String mOilGet(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.getName().equals("anonymousUser")){
            return "index";
        }
        model.addAttribute("isLogin",true)
                .addAttribute("chineseName", loginService.loadUserByUsername(auth.getName()).getChineseName())
                .addAttribute("rightmenu", "rightmenu_login");
        model.addAttribute("123",123);

        return "myoil";
    }

    @PostMapping("/myoil")
    public String mOilPost(){
        return "myoil";
    }
}
