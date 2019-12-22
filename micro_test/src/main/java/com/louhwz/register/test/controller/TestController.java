package com.louhwz.register.test.controller;

import com.louhwz.register.test.repository.master.MasterDao;
import com.louhwz.register.test.repository.second.SecondDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TestController {

    @Autowired
    MasterDao masterDao;

    @Autowired
    SecondDao secondDao;

    @GetMapping("/test")
    public String test(){
        return "success";
    }

    @GetMapping("/master")
    public List<String> testMaster(String groupId){
        System.out.println(groupId);
        return masterDao.testMaster();
    }

    @GetMapping("/second")
    public List<String> testSecond(){
        return secondDao.testSecond();
    }
}
