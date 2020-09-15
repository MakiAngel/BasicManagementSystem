package com.uestc.fff.information.controller;

import com.uestc.fff.information.domain.*;
import com.uestc.fff.information.service.HostService;
import com.uestc.fff.information.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/host")
public class HostController {
    @Autowired
    private HostService serviceHost;
    @Autowired
    private UserService userService;

    @RequestMapping("/main")
    public String hostPages(Model model, HttpSession session){
        boolean islogin = false;
        UserInfo test = (UserInfo) session.getAttribute("user");

        if (test == null) { islogin = false; }
        else {
                islogin = true;

                if (test.getSort().equals("S")){
                    StudentInfo s = userService.findStuBySID(test.getStid());
                    model.addAttribute("User_name", s.getSname());
                }
                if (test.getSort().equals("T")){
                    TeacherInfo t = userService.findTeaByTID(test.getStid());
                    model.addAttribute("User_name", t.getTname());
                }
        }
        model.addAttribute("isLogin",islogin);

        return "host";
    }

    @PostMapping("/post")
    public String receiveParam(String nameKey,
                               Model model, HttpSession session, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        List<SchoolInfo> resultList = serviceHost.fullSearch(nameKey);
        List<SchoolInfo> fullSearResultList = new ArrayList<SchoolInfo>();
        boolean islogin = false;
        UserInfo test = (UserInfo) session.getAttribute("user");

        if (test == null) { islogin = false; }
        else {
            islogin = true;
            if (test.getSort().equals("S")){
                StudentInfo s = userService.findStuBySID(test.getStid());
                model.addAttribute("User_name", s.getSname());
            }
            if (test.getSort().equals("T")){
                TeacherInfo t = userService.findTeaByTID(test.getStid());
                model.addAttribute("User_name", t.getTname());
            }
        }
        model.addAttribute("isLogin",islogin);

        if(resultList==null){
            model.addAttribute("resultNum",0);
            session.setAttribute("resultList", fullSearResultList);
        }
        else{
            session.setAttribute("resultList", resultList);

            Cookie cookie = new Cookie("resultSession", session.getId());
            cookie.setMaxAge(86400);//保存一天
            httpServletResponse.addCookie(cookie);

            model.addAttribute("resultNum",resultList.size());
            model.addAttribute("resultList",resultList);
        }

        return "searchResult";
    }
}
