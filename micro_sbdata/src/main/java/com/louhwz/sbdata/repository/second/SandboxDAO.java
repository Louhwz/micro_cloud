package com.louhwz.sbdata.repository.second;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SandboxDAO {
    List<String> testSecond();
}
