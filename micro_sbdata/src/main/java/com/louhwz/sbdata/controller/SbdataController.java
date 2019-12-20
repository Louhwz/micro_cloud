package com.louhwz.sbdata.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.louhwz.sbdata.service.SbdataService;
import com.louhwz.sbdata.utils.Case;
import com.louhwz.sbdata.utils.HotelData;
import com.louhwz.sbdata.utils.Response;
import com.louhwz.sbdata.utils.Sbdata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.apache.http.client.methods.RequestBuilder.put;

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

    @PostMapping("/testsend")
    public JSONObject testsend(@RequestBody JSONObject jsonObject){
        return jsonObject;
    }

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


    @PostMapping("/hoteldata")
    public List<HotelData> getHotelData(@RequestBody JSONObject jsonObject){
        Integer groupId = jsonObject.getInteger("groupId");
        List<HotelData> hotelInfo = sbdataService.getHotelInfo(groupId);
        System.out.println(hotelInfo.get(0));
        return hotelInfo;
    }

    @PostMapping("/order")
    public Integer[] receiveOrderFromVue(@RequestBody List<JSONObject> jsonObject){
        Integer[] array = new Integer[jsonObject.size()];
        for(int i=0;i<jsonObject.size();i++) {
            Integer addIn = jsonObject.get(i).getInteger("id");

            array[i] = addIn;
        }
        return array;
    }

    @GetMapping("/caseshow")
    public List<Case> getCase(){
        List<Case>  res = sbdataService.getCaseInfo();
        //List<Map<Integer, Integer>> maxRound = sbdataService.getMaxRound();
        int maxRound[] = {6,6,6};

        for (Case re : res) {
            int nowCaseId = re.getCaseId();
            if (re.getCurrentRound() > maxRound[nowCaseId]) {
                re.setIfFinished(true);
            }
        }

        System.out.println(res.get(0));

        return res;
    }


}
