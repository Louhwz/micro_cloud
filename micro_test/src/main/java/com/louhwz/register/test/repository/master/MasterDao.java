package com.louhwz.register.test.repository.master;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MasterDao {

    List<String> testMaster();
}
