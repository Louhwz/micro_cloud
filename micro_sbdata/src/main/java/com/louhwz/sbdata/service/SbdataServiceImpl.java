package com.louhwz.sbdata.service;

import com.louhwz.sbdata.repository.SbdataDao;
import com.louhwz.sbdata.utils.Response;
import com.louhwz.sbdata.utils.Sbdata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SbdataServiceImpl implements SbdataService{

    @Autowired
    SbdataDao sbdataDao;

    @Override
    public Response getData(Integer caseId) {

        Sbdata sbdata = sbdataDao.getDataById(caseId);
        return new Response(200,"查询成功",sbdata);
    }
}
