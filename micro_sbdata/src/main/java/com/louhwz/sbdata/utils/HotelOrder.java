package com.louhwz.sbdata.utils;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 对应数据库中的I_RoomOrders表，目前ICustomerId字段硬编码
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelOrder {
    Integer expId;
    Integer groupId;
    Integer round;
    Integer iCustomerId;
    Integer iRoomId;
    Integer price;
}
