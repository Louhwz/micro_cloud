package com.louhwz.sbdata.service;

import com.louhwz.sbdata.repository.second.SandboxDAO;
import com.louhwz.sbdata.utils.HotelOrder;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    @Autowired
    SandboxDAO sandboxDAO;

    @Override
    public List<HotelOrder> getHotelOrder(Integer groupId) {
        return sandboxDAO.getHotelOrder(groupId);
    }
}
