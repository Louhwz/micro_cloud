package com.louhwz.sbdata.utils;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotelData {
    int id;
    int groupId;
    String houseType;    //房型
    int floor;
    int no; //编号，用于定位在楼层中的位置
    int price;
    int area;
    int face;
    int totalSell;
    int ageing; //老化程度

    @Override
    public String toString() {
        return houseType + String.valueOf(price) + String.valueOf(id);
    }
}
