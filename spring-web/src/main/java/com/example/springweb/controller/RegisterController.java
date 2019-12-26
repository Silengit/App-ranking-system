package com.example.springweb.controller;

import com.example.springweb.dao.HelloUser;
import com.example.springweb.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;


@Controller
public class RegisterController {
    @Autowired
    HelloService helloService;

    @RequestMapping("/register")
    public String getRegister(){
        return "register";
    }

    @RequestMapping("/register/submit")
    public String getSubmit(String name, String password, String confirm_psd){
        if(password.equals(confirm_psd)) {
            for (HelloUser u : helloService.getUserList()
            )
                if(u.getName().equals(name))
                    return "register";
            Map myMap = new HashMap<String, String>();
            myMap.put("id", name);
            myMap.put("name", name);
            myMap.put("password", password);
            helloService.InsertUser(myMap);
            return "index";
        }
        else
            return "register";
    }
}
