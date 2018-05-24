package com.SSMTest.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * Created by Administrator on 2018/5/14.
 */
@RequestMapping("/file")
@Controller
public class FileUpload {

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ResponseBody
    public String fileUpload(MultipartFile myFile, HttpServletRequest request){
        String msg = "";
        if(!myFile.isEmpty()){
            String path = request.getSession().getServletContext().getRealPath("upload");
            //System.out.println(myFile.getName());
            //System.out.println(myFile.getOriginalFilename());
            //getName 返回的是获取表单中文件组件的名字
            //getOriginalFilename 获取上传文件的原名
            String fileName = myFile.getOriginalFilename();
            File dir = new File(path,fileName);
            if(!dir.exists()){
                dir.mkdirs();
            }
            try {
                myFile.transferTo(dir);
                msg = "success";
            } catch (IOException e) {
                e.printStackTrace();
                msg = "error";
            }
        }else{
            msg = "error";
        }
        return msg;
    }

    @RequestMapping("/down")
    @ResponseBody
    public void down(HttpServletRequest request, HttpServletResponse response){
        String path = request.getSession().getServletContext().getRealPath("upload")+"/服务器.txt";
        InputStream is =null;
        try {
            is = new BufferedInputStream(new FileInputStream(new File(path)));
            String filename = "下载文件.txt";
            filename = URLEncoder.encode(filename,"UTF-8");
            //设置文件下载头
            response.setHeader("Content-Disposition","attachment;filename="+filename);
            //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
            response.setContentType("multipart/form-data");
            BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
            int len = 0;
            while((len = is.read()) != -1){
                bos.write(len);
                bos.flush();
            }
            bos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
