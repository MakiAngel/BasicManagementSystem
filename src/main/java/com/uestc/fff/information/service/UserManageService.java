package com.uestc.fff.information.service;

import com.uestc.fff.information.domain.UserInfo;
import com.uestc.fff.information.domain.UserInfoExample;
import com.uestc.fff.information.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManageService {
    @Autowired
    UserInfoMapper userInfoMapper;

    public List<UserInfo> userInfoList() { return  userInfoMapper.selectByExample(new UserInfoExample()); }

    public void deleteUserByID(String id) {
        userInfoMapper.deleteByPrimaryKey(id);
    }

    public UserInfo findUserByUid(String uid){
        return userInfoMapper.selectByPrimaryKey(uid);
    }

    public List<UserInfo> searchUser(String stid){
        UserInfoExample userInfoExample = new UserInfoExample();
        userInfoExample.createCriteria().andStidLike("%" + stid + "%");
        return userInfoMapper.selectByExample(userInfoExample);
    }

    public void updateUser(UserInfo userInfo) {
        userInfoMapper.updateByPrimaryKey(userInfo);
    }
}
