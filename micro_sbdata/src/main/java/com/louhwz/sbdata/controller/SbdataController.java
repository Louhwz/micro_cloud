package com.louhwz.sbdata.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.louhwz.sbdata.repository.second.SandboxDAO;
import com.louhwz.sbdata.service.SbdataService;
import com.louhwz.sbdata.utils.Case;
import com.louhwz.sbdata.utils.HotelData;
import com.louhwz.sbdata.utils.Response;
import com.louhwz.sbdata.utils.Sbdata;
import com.teradata.common.bean.ResponseBean;
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

    @Autowired
    SandboxDAO sandboxDAO;
    /**
     * 测试用
     * @return
     */
    @GetMapping("/test")
    public String test(){
        return "测试成功！";
    }

    @GetMapping("/second")
    public List<String> testSecond(){
        return sandboxDAO.testSecond();
    }
    /**
     * 与前端交互
     * @return  所有可以增改的case TODO 增加用户需要改进修改的case
     */
    @GetMapping("/caseshow")
    public ResponseBean getCase(){
        List<Case>  res = sbdataService.getCaseInfo();
        //List<Map<Integer, Integer>> maxRound = sbdataService.getMaxRound();
        int maxRound[] = {6,6,6};

        for (Case re : res) {
            int nowCaseId = re.getCaseId();
            if (re.getCurrentRound() > maxRound[nowCaseId]) {
                re.setIfFinished(true);
            }
        }
        return new ResponseBean(200,"success",res);
    }

    /**
     * 与前端交互，
     * @param jsonObject
     * @return 特定groupId的房间情况，供前端用户增改
     */
    @PostMapping("/hoteldata")
    public ResponseBean getHotelData(@RequestBody JSONObject jsonObject){
        Integer groupId = jsonObject.getInteger("groupId");
        List<HotelData> hotelInfo = sbdataService.getHotelInfo(groupId);

        return new ResponseBean(200,"success",hotelInfo);

    }

    /**
     * 与前端交互
     * @param jsonObject
     * @return 用户对某一张表的修改结果
     */
    @PostMapping("/order")
    public ResponseBean receiveOrderFromVue(@RequestBody List<JSONObject> jsonObject){
        Integer[] array = new Integer[jsonObject.size()];
        for(int i=0;i<jsonObject.size();i++) {
            Integer addIn = jsonObject.get(i).getInteger("id");

            array[i] = addIn;
        }
        return new ResponseBean(200,"success",array);
    }


    /**
     * 与沙盘后端交互
     * @param groupId
     * @return
     */
    @GetMapping("/isready")
    public ResponseBean isReady(String groupId){
        boolean isReady = sbdataService.isReady(groupId);
        isReady = false;
        if(isReady){

            return new ResponseBean(200,"success","");
        }
        else{
            return new ResponseBean(204,"Not Ready","");
        }

    }

    /**
     * 与沙盘后端交互
     * @param groupId
     * @return
     */
    @GetMapping("/neworder")
    public ResponseBean newOrder(String groupId){
        System.out.println(groupId);
        return new ResponseBean(200,"success",groupId);
    }








    /*
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
*/


}
