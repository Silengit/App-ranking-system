package com.example.springweb.service;

import com.example.springweb.dao.AppInfo;
import com.example.springweb.mapper.AppInfoMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class AppInfoService {
    @Resource
    private AppInfoMapper appInfoMapper;

    public List<AppInfo> getAppList() {
        List<AppInfo> list = appInfoMapper.findAll();
        return list;
    }

    public void InsertApp(Map<String, String> params){
        ObjectMapper objectMapper = new ObjectMapper();
        AppInfo appinfo = objectMapper.convertValue(params, AppInfo.class);
        appInfoMapper.insert(appinfo);
    }


    public AppInfo getOne(String id){
        AppInfo result = appInfoMapper.getOne(id);
//        System.out.println("getOne:"+result);
        if (result==null)
        {
            result=new AppInfo();//索引为空的时候，返回null，需要这时候对其getId,getName就会出错。
        }
//        System.out.println(result.toString());
        return result;
    }

    public void UpdateByID(Map<String, String> params){
        String id = params.get("id");
        AppInfo temp = appInfoMapper.getOne(id);
        if(params.get("name")!=null)
            temp.setName(params.get("name"));
        if(params.get("scope")!=null) {
//            System.out.println("scope:"+params.get("scope"));
            switch (params.get("scope")) {
                case "1":
                    temp.setScope(1);
                    break;
                case "2":
                    temp.setScope(2);
                    break;
                case "3":
                    temp.setScope(3);
                    break;
                default:
                    temp.setScope(0);
            }
        }
        if(params.get("business")!=null) {
            switch (params.get("business")) {
                case "1":
                    temp.setBusiness(1);
                    break;
                case "2":
                    temp.setBusiness(2);
                    break;
                case "3":
                    temp.setBusiness(3);
                    break;
                case "4":
                    temp.setBusiness(4);
                    break;
                default:
                    temp.setBusiness(0);
            }
        }
        if(params.get("knowledge")!=null) {
            switch (params.get("knowledge")) {
                case "1":
                    temp.setKnowledge(1);
                    break;
                case "2":
                    temp.setKnowledge(2);
                    break;
                case "3":
                    temp.setKnowledge(3);
                    break;
                default:
                    temp.setKnowledge(0);
            }
        }
        if(params.get("ranking")!=null) {
            switch (params.get("ranking")) {
                case "1":
                    temp.setRanking(1);
                    break;
                case "2":
                    temp.setRanking(2);
                    break;
                case "3":
                    temp.setRanking(3);
                    break;
                case "4":
                    temp.setRanking(4);
                    break;
                case "5":
                    temp.setRanking(5);
                    break;
                default:
                    temp.setRanking(0);
            }
        }
        appInfoMapper.updateByID(temp);
    }

    public void DeleteByID(String id){
        appInfoMapper.deleteByID(id);
        System.out.println("AfterDelete:"+appInfoMapper.getOne(id));
    }
}
