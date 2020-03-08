package com.louhwz.sbdata.service;


import com.alibaba.fastjson.JSONObject;
import com.louhwz.sbdata.utils.HotelOrder;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 主要用来编写沙盘访问订单数据和存储订单数据两个接口
 */
public interface OrderService {

    /**
     * 与沙盘交互的接口，得到hotelorder订单
     * @param groupId
     * @return
     */
    List<HotelOrder> getHotelOrder(Integer groupId);

    /**
     * 返回特定expid的groupid
     * @param expId
     * @return
     */
    List<Integer> getGroupList(Integer expId);

    boolean readyStatus(Integer integer);

    void addOrder(List<JSONObject> jsonObjects);
}
