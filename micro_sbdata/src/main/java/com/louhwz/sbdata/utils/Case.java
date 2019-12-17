package com.louhwz.sbdata.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Case {
    Integer id;
    String name;
    String description;
    Integer caseId;
    String createTime;
    Integer currentRound;
    Boolean ifFinished = false;
}

