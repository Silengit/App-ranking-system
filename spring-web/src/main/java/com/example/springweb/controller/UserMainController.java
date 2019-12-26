package com.example.springweb.controller;

import com.example.springweb.dao.AppInfo;
import com.example.springweb.service.AppInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;


@Controller
public class UserMainController {
    @Autowired
    AppInfoService appInfoService;

    @RequestMapping("/user")
    public String userland() {
        return "main";
    }

    @RequestMapping("/user/addApp")
    public String addApp() {
        return "addApp";
    }

    @RequestMapping("/user/addApp/submit")
    public String submitApp(String name, String scope, String business, String knowledge, int ranking) {
//        System.out.println(name);
//        System.out.println(scope);
//        System.out.println(business);
//        System.out.println(knowledge);
//        System.out.println(ranking);
        for (AppInfo a : appInfoService.getAppList()
        )
            if(a.getName().equals(name))
                return "addApp";
        AppInfo app = new AppInfo(name,name,scope,business,knowledge,ranking);
        Map myMap = new HashMap<String, String>();
        myMap.put("id", app.getId());
        myMap.put("name", app.getName());
        myMap.put("scope", app.getScope());
        myMap.put("business", app.getBusiness());
        myMap.put("knowledge", app.getKnowledge());
        myMap.put("ranking", app.getRanking());
        appInfoService.InsertApp(myMap);
        return "file";
    }

    @RequestMapping("/user/file/uploaded")
    public String uploadFile() {
        return "main";
    }
}
