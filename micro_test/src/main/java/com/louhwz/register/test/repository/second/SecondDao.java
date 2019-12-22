package com.louhwz.register.test.repository.second;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SecondDao {
    List<String> testSecond();
}
