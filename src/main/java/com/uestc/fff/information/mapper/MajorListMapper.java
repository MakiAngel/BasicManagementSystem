package com.uestc.fff.information.mapper;

import com.uestc.fff.information.domain.MajorInfo;

import java.util.List;

public interface MajorListMapper {
    List<MajorInfo> selectBySchool(String scid);

}
