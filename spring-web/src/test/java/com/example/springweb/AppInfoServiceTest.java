package com.example.springweb;

import com.example.springweb.dao.AppInfo;
import com.example.springweb.service.AppInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppInfoServiceTest {
    @Autowired
    AppInfoService appInfoService;

    @Test
    public void getApps() {
        List<AppInfo> apps = appInfoService.getAppList();
        assertNotNull("App not null", apps);
        assertNotEquals(apps.size(), 0);
    }

    @Test
    public void testInsertUpdateAndDelete() throws Exception{
        Map<String,String> params1=new HashMap<>();
        params1.put("id","4");
        params1.put("name","huo");
        params1.put("scope","1");
        params1.put("business","2");
        params1.put("knowledge","3");
        params1.put("ranking","4");
        appInfoService.InsertApp(params1);
        assertEquals(appInfoService.getOne("4").getName(),"huo");
        assertEquals(appInfoService.getAppList().size(),2);
        Map<String,String> params2=new HashMap<>();
        params2.put("id","4");
        params2.put("name","hai");
        appInfoService.UpdateByID(params2);
        assertEquals(appInfoService.getOne("4").getName(),"hai");
        appInfoService.DeleteByID("4");
        assertNull(appInfoService.getOne("4").getName());
    }

    @Test
    public void testGetOne() throws Exception{
        AppInfo app = appInfoService.getOne("9");
        assertNull(app.getName());
    }

    @Test
    public void testInsertOneAndDelete() throws Exception{
        Map<String,String> params=new HashMap<>();
        params.put("id","9");
        params.put("name","hei");
        params.put("scope","3");
        params.put("business","3");
        params.put("knowledge","3");
        params.put("ranking","3");
        appInfoService.InsertApp(params);
        assertEquals(appInfoService.getOne("9").getName(),"hei");
        assertEquals(appInfoService.getOne("9").getScope(),3);
        assertNotNull(appInfoService.getOne("9").getName());
        appInfoService.DeleteByID("9");
        assertNull(appInfoService.getOne("9").getName());
    }

    @Test
    public void testUpdate() throws Exception {
        Map<String,String> params=new HashMap<>();
        params.put("id","1");
        params.put("name","NotTestApp");
        appInfoService.UpdateByID(params);
        assertEquals(appInfoService.getOne("1").getName(),"NotTestApp");
    }
}
