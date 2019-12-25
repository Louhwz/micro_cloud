package com.louhwz.sbdata.service;


import com.louhwz.sbdata.utils.HotelOrder;

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


}
