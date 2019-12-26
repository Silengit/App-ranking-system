package com.example.springweb.mapper;

import com.example.springweb.dao.AppInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AppInfoMapper {
    @Select("select * from appinfo ")
    @Results({
            @Result(property = "id", column = "stringId"),
            @Result(property = "name", column = "app_name")
    })
    List<AppInfo> findAll();

    @Insert("insert into appinfo(stringId,app_name,apply_scope,business_kind,knowledge_type,ranking) " +
            "values(#{id},#{name},#{scope},#{business},#{knowledge},#{ranking})")
    void insert(AppInfo appInfo);


    @Select("select * from appinfo where stringId = #{id}")
    @Results({
            @Result(property = "id",column = "stringId"),
            @Result(property = "name",column = "app_name"),
            @Result(property = "scope",column = "apply_scope"),
            @Result(property = "business",column = "business_kind"),
            @Result(property = "knowledge",column = "knowledge_type"),
            @Result(property = "ranking",column = "ranking")

    })
    AppInfo getOne(String id);

    @Update("update appinfo set app_name = #{name}, apply_scope = #{scope},  business_kind = #{business}, " +
            "knowledge_type = #{knowledge}, ranking = #{ranking} where StringId = #{id}")
    void updateByID(AppInfo appInfo);//UPDATE 表名称 SET 列名称 = 新值 WHERE 列名称 = 某值

    @Delete("delete from appinfo where StringId = #{id}")
    void deleteByID(String id);//DELETE FROM 表名称 WHERE 列名称 = 值
}
