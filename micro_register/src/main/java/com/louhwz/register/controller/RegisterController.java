package com.louhwz.register.controller;


import com.alibaba.fastjson.JSONObject;
import com.louhwz.register.entity.User;
import com.louhwz.register.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class RegisterController {

    @Autowired
    private RegisterService registerService;


    @GetMapping("/test")
    public String test(){
        return "这是一个测试";
    }

    /**
     * vue前端注册实现
     * @return
     */
    @PostMapping("/hasRegistered")
    public int hasRegistered(@RequestBody JSONObject jsonObject){
        String username = jsonObject.getString("username");
        String password = jsonObject.getString("password");

        return registerService.hasRegistered(username);
    }

    @PostMapping("/register")
    public int register(@RequestBody JSONObject jsonObject){
        String username = jsonObject.getString("username");
        String password = jsonObject.getString("password");


        User user = new User();
        if(username != null) {
            user.setUserName(username);
        }
        if(null != password) {
            user.setUserPassword(password);
        }
        user.setAccount("user");
        user.setRoleName("用户管理员");
        System.out.println("注册传进来的jsonObject" + jsonObject);
        System.out.println("注册传进来的username:" + username +"注册传进来的密码："+password);

        return registerService.register(user);

    }
}
