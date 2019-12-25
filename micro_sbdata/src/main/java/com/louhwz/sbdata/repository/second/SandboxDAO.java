package com.louhwz.sbdata.repository.second;

import com.louhwz.sbdata.utils.HotelOrder;
import com.mysql.cj.x.protobuf.MysqlxCrud;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SandboxDAO {
    List<String> testSecond();

    Boolean getReadyInfo(Integer groupId);

    List<HotelOrder> getHotelOrder(Integer groupId);
}
