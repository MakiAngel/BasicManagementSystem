package com.uestc.fff.information.mapper;

import com.uestc.fff.information.domain.TeacherInfo;

import java.util.List;

public interface TeacherListMapper {
    List<TeacherInfo> selectBySchool(String scid);
}
