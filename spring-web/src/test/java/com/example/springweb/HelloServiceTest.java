package com.example.springweb;

import com.example.springweb.dao.HelloUser;
import com.example.springweb.service.HelloService;
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
public class HelloServiceTest {
    @Autowired
    HelloService helloService;

    @Test
    public void getUsers() {
        List<HelloUser> users = helloService.getUserList();
        assertNotNull("User not null", users);
        assertNotEquals(users.size(), 0);
    }

    @Test
    public void testInsertUpdateAndDelete() throws Exception{
        Map<String,String> params1=new HashMap<>();
        params1.put("id","4");
        params1.put("name","niha");
        params1.put("password","yes");
        helloService.InsertUser(params1);
        assertEquals(helloService.getOne("4").getName(),"niha");
        assertEquals(helloService.getUserList().size(),2);
        Map<String,String> params2=new HashMap<>();
        params2.put("id","4");
        params2.put("name","yyy");
        helloService.UpdateByID(params2);
        assertEquals(helloService.getOne("4").getName(),"yyy");
        helloService.DeleteByID("4");
        assertNull(helloService.getOne("4").getName());
    }

    @Test
    public void testGetOne() throws Exception{
        HelloUser helloUser = helloService.getOne("9");
        assertNull(helloUser.getName());
    }

    @Test
    public void testInsertOneAndDelete() throws Exception{
        Map<String,String> params=new HashMap<>();
        params.put("id","9");
        params.put("name","nana");
        params.put("password","no");
        helloService.InsertUser(params);
        assertEquals(helloService.getOne("9").getName(),"nana");
        assertNotNull(helloService.getOne("9").getName());
        helloService.DeleteByID("9");
        assertNull(helloService.getOne("9").getName());
    }

    @Test
    public void testUpdate() throws Exception {
        Map<String,String> params=new HashMap<>();
        params.put("id","1");
        params.put("password","not12345");
        helloService.UpdateByID(params);
        assertEquals(helloService.getOne("1").getPassword(),"not12345");
    }
}
