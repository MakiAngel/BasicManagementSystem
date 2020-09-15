package com.uestc.fff.information.controller;

import com.uestc.fff.information.domain.*;
import com.uestc.fff.information.service.UploadService;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;

@Controller
public class UploadController {
    @Autowired
    private UploadService uploadService;

    @RequestMapping("/upload")
    @ResponseBody
    public String Upload(ClassInfo classInfo,
                         @RequestParam("Lname") String lname,
                         @RequestParam("file1") MultipartFile file1,
                         @RequestParam("file2") MultipartFile file2,
                         @RequestParam("file3") MultipartFile file3,
                         @RequestParam("file4") MultipartFile file4,
                         HttpServletResponse response, HttpSession session) {
        UserInfo userInfotest = (UserInfo) session.getAttribute("user");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = null;

        try{
            writer = response.getWriter();
            if (userInfotest == null) {
                writer.write("<script> alert('请先登录'); location.href='/user/login';</script>");
                writer.flush();
            }
            if(userInfotest.getSort().equals("S")) {
                writer.write("<script> alert('对不起，学习资料仅限老师上传'); location.href='/host/main?islogin=true';</script>");
                writer.flush();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

        MateriasInfo materiasInfo = new MateriasInfo();
        //uuId自动生成
        CreateUuid16 createUuid16 = new CreateUuid16();
        createUuid16.setUuid16();
        materiasInfo.setLid(createUuid16.uuid16);
        materiasInfo.setLname(lname);
        materiasInfo.setCid(classInfo.getCid());

        if (!file1.isEmpty()) {
            // 获取文件名称,包含后缀
            String fileName = file1.getOriginalFilename();

            // 存放在这个路径下：该路径是该工程目录下的static/files/文件下：
            String path0 = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static/files/";
            String path = path0.substring(1, path0.length());
            try {
                // 该方法是对文件写入的封装
                FileUtil.fileupload(file1.getBytes(), path, fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }

            // 接着创建对应的实体类，将以下路径进行添加，然后通过数据库操作方法写入
            materiasInfo.setMaterial(fileName);
        }
        if (!file2.isEmpty()) {
            String fileName = file2.getOriginalFilename();
            String path0 = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static/files/";
            String path = path0.substring(1, path0.length());

            try {
                FileUtil.fileupload(file2.getBytes(), path, fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }

            materiasInfo.setPpt(fileName);
        }
        if (!file3.isEmpty()) {
            String fileName = file3.getOriginalFilename();

            String path0 = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static/files/";
            String path = path0.substring(1, path0.length());

            try {
                FileUtil.fileupload(file3.getBytes(), path, fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
            materiasInfo.setVideo(fileName);
        }
        if (!file4.isEmpty()) {
            String fileName = file4.getOriginalFilename();

            String path0 = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static/files/";
            String path = path0.substring(1, path0.length());

            try {
                FileUtil.fileupload(file4.getBytes(), path, fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
            materiasInfo.setReference(fileName);
        }
        uploadService.SaveM(materiasInfo);

        writer.write("<script> alert('上传成功'); history.go(-1);</script>");
        writer.flush();
        return "success";
    }

    @RequestMapping("/download")
    public ResponseEntity<byte[]> down( @RequestParam("filename") String filename,
                                        HttpSession session) throws Exception{
        //获取下载文件的路径 (获取tomcat服务器的位置)
        String realPath = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static/files/";
        //String realPath = session.getServletContext().getRealPath("files");
        String finalPath = realPath+ File.separator + filename;
        //创建字节输入流
        InputStream in = new FileInputStream(finalPath);
        //available():获取输入流所读取的文件的最大字节数
        byte[] body = new byte[in.available()];
        //把字节读取到数组中
        in.read(body);
        // 解决中文乱码
        String downloadfile =  new String(filename.getBytes("UTF-8"),"iso-8859-1");
        //设置请求头
        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment;filename="+ downloadfile);
        //设置响应状态
        HttpStatus statusCode = HttpStatus.OK;
        in.close();

        ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(body, headers, statusCode);
        return entity;

    }
}
