package com.SSMTest.Controller;

import com.SSMTest.Model.User;
import com.SSMTest.Service.Impl.UserServiceImpl;
import com.SSMTest.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2018/5/10.
 */
@Controller
@RequestMapping("/hello")
public class Test {
    @Resource
    private UserServiceImpl usi;
    @Resource
    private User user;
    @RequestMapping("/a")
    @ResponseBody
    public String index() {
        System.out.println("进来了");
        return "Welcome to SSM";
    }
    @RequestMapping("/getUser/{id}")
    @ResponseBody
    public User getUser(@PathVariable String id){
        System.out.println("ggggggg");
        //String id = "2";
        return usi.getUserById(id);
    }
    @RequestMapping("/getName")
    @ResponseBody
    public User getName(@RequestParam String name){
        return usi.getUserById(name);
    }

    @RequestMapping("/upload")
    @ResponseBody
    public String uploadFile(){

        return null;
    }
}
