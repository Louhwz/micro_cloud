package com.louhwz.sbdata.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.louhwz.sbdata.repository.second.SandboxDAO;
import com.louhwz.sbdata.service.OrderService;
import com.louhwz.sbdata.service.SbdataService;
import com.louhwz.sbdata.utils.*;
import com.teradata.common.bean.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static org.apache.http.client.methods.RequestBuilder.put;

/**
 * 200 OK 服务器返回用户请求的数据，该操作是幂等的
 * 201 CREATED 新建或者修改数据成功
 * 204 NOT CONTENT 删除数据成功
 * 400 BAD REQUEST 用户发出的请求有问题，该操作是幂等的
 * 401 Unauthoried 表示用户没有认证，无法进行操作
 * 403 Forbidden 用户访问是被禁止的
 * 422 Unprocesable Entity 当创建一个对象时，发生一个验证错误
 * 500 INTERNAL SERVER ERROR 服务器内部错误，用户将无法判断发出的请求是否成功
 * 503 Service Unavailable 服务不可用状态，多半是因为服务器问题，例如CPU占用率大，等等
 */
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class SbdataController {
    @Autowired
    SbdataService sbdataService;

    @Autowired
    SandboxDAO sandboxDAO;

    @Autowired
    OrderService orderService;

    /**
     * 测试用
     *
     * @return
     */
    @GetMapping("/createcontainer")
    public ResponseBean test() {
        return new ResponseBean(200,"success","creating container...");
    }

    @GetMapping("/ttsec")
    public List<String> testSecond() {
        return sandboxDAO.testSecond();
    }


    /**
     * 与前端交互
     *
     * @return 所有可以增改的case TODO 增加用户需要改进修改的case
     */
    @GetMapping("/caseshow")
    public ResponseBean getCase() {
        List<Case> res = sbdataService.getCaseInfo();
        //List<Map<Integer, Integer>> maxRound = sbdataService.getMaxRound();
        /*int maxRound[] = {6, 6, 6};*/

        for (Case re : res) {
            int nowCaseId = re.getCaseId();
            if (re.getCurrentRound() > 6) {
                re.setIfFinished(true);
            }
        }
        return new ResponseBean(200, "success", res);
    }

    /**
     * 与前端交互，
     *
     * @param jsonObject
     * @return 特定groupId的房间情况，供前端用户增改
     */
    @PostMapping("/hoteldata")
    public ResponseBean getHotelData(@RequestBody JSONObject jsonObject) {
        Integer expId = jsonObject.getInteger("groupId");

        System.out.println(jsonObject);

        List<HotelData> hotelInfo = sbdataService.getHotelInfo(expId);
        if (hotelInfo == null) {
            List<HotelData> hotelInfo1 = new ArrayList<>();
            return new ResponseBean(200, "no data", hotelInfo1);
        } else
            return new ResponseBean(200, "success", hotelInfo);

    }

    /**
     * 与前端交互，参数又可叫caseId
     *
     * @param expId
     * @return
     */
    @GetMapping("/groupincase")
    public ResponseBean getGroupsInCase(Integer expId) {
        List<I_Groups> groupsList = sbdataService.getGroupsInCase(expId);
        if (groupsList == null)
            return new ResponseBean(200, "success", "no data");
        else
            return new ResponseBean(200, "success", groupsList);
        //return new ResponseBean(200, "success", groupsList);
    }

    /**
     * 与前端交互，在order界面用户选择具体的groupid时调用这个接口
     *
     * @param groupId
     * @return
     */
    @GetMapping("/specifichoteldata")
    public ResponseBean getSpecificHotelData(Integer groupId) {
        List<HotelData> hotelInfo = sbdataService.getSpecificHotel(groupId);
        return new ResponseBean(200, "success", hotelInfo);
    }

    /**
     * 与前端交互
     *
     * @param jsonObject
     * @return 用户对某一张表的修改结果
     */
    @PostMapping("/order")
    public ResponseBean receiveOrderFromVue(@RequestBody List<JSONObject> jsonObject) {
/*        Integer[] array = new Integer[jsonObject.size()];
        for (int i = 0; i < jsonObject.size(); i++) {
            Integer addIn = jsonObject.get(i).getInteger("id");

            array[i] = addIn;
        }*/
        if (jsonObject == null) {
            return new ResponseBean(200, "success", "no data");
        }
        orderService.addOrder(jsonObject);
/*        for (int i = 0; i < jsonObject.size(); i++) {
            JSONObject t = jsonObject.get(i);
            HotelOrder increment = new HotelOrder(t.getInteger("expid"),t.getInteger("groupid"),t.getInteger("round"),
                    t.getInteger("customer_id"),t.getInteger("room_id"),t.getInteger("price"));

            SandboxDAO.addOrder(increment);
        }*/
        return new ResponseBean(200, "success", "");
    }


    /**
     * 与沙盘后端交互
     *
     * @param groupId
     * @return
     */
    @GetMapping("/isready")
    public ResponseBean isReady(Integer groupId) {
/*        boolean isReady = sbdataService.isReady(groupId);
        isReady = false;*/
        //TODO：好好写一下ready,status

        List<HotelOrder> res = orderService.getHotelOrder(groupId);
        if (res == null || res.size() == 0) {
            return new ResponseBean(204, "Not Ready", "");
        } else {
            return new ResponseBean(200, "success", res);
        }
        /*
        if (orderService.readyStatus(expId)) {
            //    sbdataService.getHotelOrder(groupId);
            List<HotelOrder> listGroup = new LinkedList<>();
            listGroup = orderService.getHotelOrder()
            for (int i = 0; i < 36; i++) {
                HotelOrder hotelOrder = new HotelOrder(42, 2, 1764808, 490, 580);
                hotelOrder.setIRoomId(490 + i);
                if (i <= 18) {
                    hotelOrder.setPrice(580);

                } else if (i > 18 && i <= 25) {
                    hotelOrder.setPrice(1200);

                } else {
                    hotelOrder.setPrice(1588);
                }
                listGroup.add(hotelOrder);
            }
            return new ResponseBean(200, "success", listGroup);
        } else {
            return new ResponseBean(204, "Not Ready", "");
        }*/

    }

    /**
     * 1、对出错、空值、传入参数的处理
     * 2、函数、变量命名规则
     *
     * @param expId
     * @return
     */
    private boolean ready(Integer expId) {
        List<Integer> groupList = orderService.getGroupList(expId);
        boolean res = false;
        for (Integer integer : groupList) {
            res |= orderService.readyStatus(integer);
        }
        return res;
    }


}
