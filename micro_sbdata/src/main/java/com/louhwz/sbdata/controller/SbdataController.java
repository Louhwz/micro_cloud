package com.louhwz.sbdata.controller;

import com.alibaba.fastjson.JSONObject;
import com.louhwz.sbdata.service.SbdataService;
import com.louhwz.sbdata.utils.Response;
import com.louhwz.sbdata.utils.Sbdata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
200 OK 服务器返回用户请求的数据，该操作是幂等的
201 CREATED 新建或者修改数据成功
204 NOT CONTENT 删除数据成功
400 BAD REQUEST 用户发出的请求有问题，该操作是幂等的
401 Unauthoried 表示用户没有认证，无法进行操作
403 Forbidden 用户访问是被禁止的
422 Unprocesable Entity 当创建一个对象时，发生一个验证错误
500 INTERNAL SERVER ERROR 服务器内部错误，用户将无法判断发出的请求是否成功
503 Service Unavailable 服务不可用状态，多半是因为服务器问题，例如CPU占用率大，等等
 */
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class SbdataController {


    @Autowired
    SbdataService sbdataService;


    @GetMapping("/test")
    public String test(){
        return "测试成功！";
    }


    @PostMapping("/gsd")
    @ResponseBody
    public Response gsd(@RequestBody JSONObject jsonObject) {
        int caseId = jsonObject.getIntValue("caseId");
        System.out.println(caseId);
        return sbdataService.getData(caseId);
    }

    @PostMapping("/gst")
    public Sbdata gst(@RequestBody JSONObject jsonObject){
        int caseId = jsonObject.getIntValue("caseId");
        System.out.println(caseId);
        System.out.println("jsonObject"+jsonObject);
        Response rs = sbdataService.getData(caseId);
        return rs.getData();
    }
}
