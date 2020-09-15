package com.uestc.fff.information.mapper;

import com.uestc.fff.information.domain.MateriasInfo;

import java.util.List;

public interface MateriasListMapper {
    List <MateriasInfo> selectByClass(String cid);
}
