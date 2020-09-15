package com.uestc.fff.information.controller;

import com.uestc.fff.information.domain.SchoolInfo;
import com.uestc.fff.information.domain.StudentInfo;
import com.uestc.fff.information.domain.TeacherInfo;
import com.uestc.fff.information.domain.UserInfo;
import com.uestc.fff.information.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /*************登录***************/
    @RequestMapping(value = "/login")
    public String loginPages() {
        return "login";
    }

    @PostMapping(value = "/loginAction")
    public void loginCheck(@RequestParam("id") String userID,
                           @RequestParam("password") String userPassword,
                           HttpServletResponse response, HttpSession session) {

        response.setContentType("text/html;charset=utf-8");//操作返回消息提示
        try (PrintWriter writer = response.getWriter()) {

            UserInfo dbUser = userService.findByID(userID);

            if (dbUser == null)
            {
                writer.write("<script> alert('该账号不存在'); history.go(-1);</script>");
                writer.flush();
                return;
            }
            else
            {
                if (!userPassword.equals(dbUser.getPassword()))
                {
                    writer.write("<script> alert('密码错误'); history.go(-1);</script>");
                    writer.flush();
                    return;
                }
                else
                {
                    //用session保存用户登录信息
                    session.setAttribute("user", dbUser);
                    //创建cookie对象来保存session的id
                    Cookie cookie = new Cookie("userSessionID", session.getId());
                    cookie.setMaxAge(86400);//保存一天
                    response.addCookie(cookie);

                    if(dbUser.getStid().equals("admin")) {
                        writer.write("<script> alert('登录成功'); location.href='/manage/school';</script>");
                        writer.flush();
                    }
                    else {
                        //writer.write("<script> alert('登录成功'); location.href='/host/main?islogin=true';</script>");
                        writer.write("<script> alert('登录成功'); history.go(-2);</script>");
                        writer.flush();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/logoutAction")
    public void logOut(HttpSession session,
                       HttpServletResponse response,
                       HttpServletRequest request) {
        response.setContentType("text/html;charset=utf-8");
        try {
            PrintWriter writer = response.getWriter();
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if ("userSessionID".equals(cookie.getName())) {
                        cookie.setMaxAge(0);//设置原本的cookie记录有效期为0，相当于删除cookie
                        response.addCookie(cookie);
                    }
                }
            }
            //从session中删除user
            session.removeAttribute("user");
            writer.write("<script> alert('成功登出'); location.href='/host/main';</script>");//登出后返回主页面
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/userinfo")
    public String userInfoPages(Model model, HttpSession session){
        UserInfo userInfo =(UserInfo) session.getAttribute("user");

        if (userInfo.getSort().equals("S")) {
            StudentInfo studentInfo = userService.findStuBySID(userInfo.getStid());
            SchoolInfo schoolInfo = userService.findScByScid(studentInfo.getScId());

            model.addAttribute("sid", studentInfo.getSid());
            model.addAttribute("sname", studentInfo.getSname());
            model.addAttribute("smajor", studentInfo.getSmajor());
            model.addAttribute("sphone", studentInfo.getSphone());
            model.addAttribute("sage", studentInfo.getSage());
            model.addAttribute("stime", studentInfo.getAdmissionTime());
            model.addAttribute("sgrade", studentInfo.getSgrade());
            model.addAttribute("school", schoolInfo.getScName());

            return "StuInfo";
        }
        if (userInfo.getSort().equals("T")) {
            TeacherInfo teacherInfo = userService.findTeaByTID(userInfo.getStid());
            SchoolInfo schoolInfo = userService.findScByScid(teacherInfo.getScId());

            model.addAttribute("tid", teacherInfo.getTid());
            model.addAttribute("tname", teacherInfo.getTname());
            model.addAttribute("tmajor", teacherInfo.getTmajor());
            model.addAttribute("tphone", teacherInfo.getTphone());
            model.addAttribute("tage", teacherInfo.getTage());
            model.addAttribute("school", schoolInfo.getScName());

            return "TeaInfo";
        }
        return "";
    }

    @PostMapping("/changepassword")
    public void changePassword(HttpSession session, HttpServletResponse response,
                               @RequestParam("originpassword") String originPassword,
                               @RequestParam("newpassword") String newPassword,
                               @RequestParam("newpassword2") String newPassword2)
    {
        response.setContentType("text/html;charset=utf-8");
        UserInfo changeUser = (UserInfo) session.getAttribute("user");
        try
        {
            if(!originPassword.equals(changeUser.getPassword()))
            {
                response.getWriter().write("<script> alert('原密码不正确'); location.href='/user/userinfo';</script>");
                return;
            }
            if (!newPassword.equals(newPassword2))
            {
                response.getWriter().write("<script> alert('两次密码输入不一致'); location.href='/user/userinfo';</script>");
                return;
            }
            else
            {
                changeUser.setPassword(newPassword);
                userService.updateUserInfo(changeUser);
                session.setAttribute("user",changeUser);
                response.getWriter().write("<script> alert('密码修改成功'); location.href='/user/userinfo';</script>");
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @PostMapping("/changestuinfo")
    public void changeStuInfo(HttpSession session, HttpServletResponse response,
                               @RequestParam("name") String userName,
                               @RequestParam("phone") String userPhone)
    {
        response.setContentType("text/html;charset=utf-8");
        UserInfo userInfo = (UserInfo) session.getAttribute("user");
        StudentInfo changeUser = userService.findStuBySID(userInfo.getStid());
        changeUser.setSname(userName);
        changeUser.setSphone(userPhone);
        userService.updateStuInfo(changeUser);
        try {
            response.getWriter().write("<script>alert('修改成功');location.href='/user/userinfo';</script>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/changeteainfo")
    public void changeTeaInfo(HttpSession session, HttpServletResponse response,
                               @RequestParam("name") String userName,
                               @RequestParam("phone") String userPhone)
    {
        response.setContentType("text/html;charset=utf-8");
        UserInfo userInfo = (UserInfo) session.getAttribute("user");
        TeacherInfo changeUser = userService.findTeaByTID(userInfo.getStid());
        changeUser.setTname(userName);
        changeUser.setTname(userPhone);
        userService.updateTeaInfo(changeUser);
        try {
            response.getWriter().write("<script>alert('修改成功');location.href='/user/userinfo';</script>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}