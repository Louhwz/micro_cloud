package com.louhwz.sbdata.service;

import com.alibaba.fastjson.JSONObject;
import com.louhwz.sbdata.repository.second.SandboxDAO;
import com.louhwz.sbdata.utils.HotelOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    SandboxDAO sandboxDAO;

    @Override
    public List<HotelOrder> getHotelOrder(Integer groupId) {
        return sandboxDAO.getHotelOrder(groupId);
    }

    @Override
    public List<Integer> getGroupList(Integer expId) {
        return null;
    }

    @Override
    public boolean readyStatus(Integer integer) {
        return false;
    }

    @Override
    public void addOrder(List<JSONObject> jsonObject) {
        for (int i = 0; i < jsonObject.size(); i++) {
            JSONObject t = jsonObject.get(i);
            HotelOrder increment = new HotelOrder(t.getInteger("expid"),t.getInteger("groupid"),t.getInteger("round"),
                    t.getInteger("customer_id"),t.getInteger("room_id"),t.getInteger("price"));

            sandboxDAO.addOrder(increment);
        }
    }


}
