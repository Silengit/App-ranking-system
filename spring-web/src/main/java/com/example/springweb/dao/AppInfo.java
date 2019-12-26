package com.example.springweb.dao;

import java.io.Serializable;

public class AppInfo implements Serializable {
    private String id;
    private String name;
    private int scope;
    private int business;
    private int knowledge;
    private int ranking;

    public AppInfo(){
        id = null;
        name = null;
        scope = 0;
        business = 0;
        knowledge = 0;
        ranking = 0;
    }
    public AppInfo(String id, String name, String scope, String business, String knowledge, int ranking){
        this.id=id;
        this.name=name;
        this.ranking = ranking;
        switch (scope) {
            case "基础共性App":
                this.scope = 1;
                break;
            case "行业通用App":
                this.scope = 2;
                break;
            case "企业专用App":
                this.scope = 3;
                break;
            default:
                this.scope = 0;
        }

        switch (business) {
            case "研发设计App":
                this.business = 1;
                break;
            case "生产制造App":
                this.business = 2;
                break;
            case "运营维护App":
                this.business = 3;
                break;
            case "经营管理App":
                this.business = 4;
                break;
            default:
                this.business = 0;
        }

        switch (knowledge) {
            case "业务信息化类":
                this.knowledge = 1;
                break;
            case "数据分析类":
                this.knowledge = 2;
                break;
            case "知识建模类":
                this.knowledge = 3;
                break;
            default:
                this.knowledge = 0;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScope() {
        return scope;
    }

    public void setScope(int scope) { this.scope =  scope; }

    public int getBusiness() {
        return business;
    }

    public void setBusiness(int business) { this.business =  business; }

    public int getKnowledge() { return knowledge; }

    public void setKnowledge(int knowledge) { this.knowledge =  knowledge; }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) { this.ranking =  ranking; }
}
