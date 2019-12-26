package com.example.springweb.controller;

import com.example.springweb.service.HelloService;
import com.example.springweb.dao.HelloUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class LogInController {
    @Autowired
    HelloService helloService;

    @RequestMapping("/index")
    public String login() {
        return "index";
    }

    @RequestMapping("/login")
    public String getLogin(@ModelAttribute HelloUser user){
        String name = user.getName();
        String password = user.getPassword();
//        System.out.println(name);
//        System.out.println(password);
        for (HelloUser u : helloService.getUserList()
             ) {
            if(u.getName().equals(name)&&u.getPassword().equals(password))
                return "main";
        }
        return "index";
    }
}
