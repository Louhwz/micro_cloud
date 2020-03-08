package com.louhwz.sbdata.repository.second;

import com.louhwz.sbdata.utils.HotelOrder;
import com.mysql.cj.x.protobuf.MysqlxCrud;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * 操作云服务器上的数据库，保存订单生成前端的数据。
 */
@Repository
public interface SandboxDAO {
    void addOrder(HotelOrder increment);

    List<String> testSecond();

    Boolean getReadyInfo(Integer groupId);

    List<HotelOrder> getHotelOrder(Integer groupId);


}
