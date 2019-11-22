package com.louhwz.sbdata.repository;

import com.louhwz.sbdata.utils.Sbdata;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SbdataDao {
    Sbdata getDataById(Integer id);
}
