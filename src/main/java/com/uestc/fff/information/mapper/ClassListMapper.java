package com.uestc.fff.information.mapper;

import com.uestc.fff.information.domain.ClassInfo;

import java.util.List;

public interface ClassListMapper {
    List<ClassInfo> selectBySchool(String scid);

}
