package com.uestc.fff.information.mapper;

import com.uestc.fff.information.domain.ExerciseInfo;

import java.util.List;

public interface ExeListMapper {
    List<ExerciseInfo> selectByClass(String cid);
}
