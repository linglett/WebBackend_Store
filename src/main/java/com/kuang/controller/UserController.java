package com.kuang.controller;

import com.kuang.java.Md5;
import com.kuang.pojo.Books;
import com.kuang.pojo.User;
import com.kuang.service.UserService;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;
    @RequestMapping("/allUser")
    public String list(Model model) {
        List<User> list = userService.queryAllUser();
        model.addAttribute("list", list);
        return "index";//根据后续的springMVC跳转到
    }
    @RequestMapping("/toUpdateUser")
    public String toUpdateUser(Model model, String id) {
        User user = userService.queryUserByAccount(id);
        System.out.println(user);
        model.addAttribute("user",user);
        return "index";
    }
    @ResponseBody
    @RequestMapping("/loginJudge")
    public String loginJudge(Model model, String userAccount, String password){
        System.out.println(userAccount+"password:"+password);//测试是否传过来
        User user = userService.queryUserByAccount(userAccount);
        System.out.println("是否输入正确"+password.equals(user.getPassword()));
        if(Md5.getMD5String(password).equals(user.getPassword()))
        {
            System.out.println(user);
            model.addAttribute("user",user);
            return "1";
        }
        return "0";
    }

    /**
     * 账号注册查重
     * @param userAccount 传入注册账号
     * @return 1:表示已经存在此账号 0:表示不存在此账号
     *
     */
    @ResponseBody
    @RequestMapping("/checkAccount")
    public String checkAccount(Model model,String userAccount){
        System.out.println("checkAccount"+userAccount);//测试是否传过来
        User user = userService.queryUserByAccount(userAccount);
        System.out.println(user);
        if(user!=null){
            System.out.println("账号查重返回1");
            return "1";
        }
        return "0";
    }
    @ResponseBody
    @RequestMapping("/registerJudge")
    public String registerJudge(Model model,String phoneNumber,String userName,String password,String email) {
        User registerUser=new User(phoneNumber,userName, Md5.getMD5String(password),email,0);
        System.out.println(registerUser);
        userService.addUser(registerUser);
        model.addAttribute("user",registerUser);
        return "1";
    }
    @ResponseBody
    @RequestMapping("/registerSSM" )
    public void t(String phoneNumber,String code) {
        System.out.println(phoneNumber+"sadasdasdasdasdad"+code);
        String host = "http://yzx.market.alicloudapi.com";
        String path = "/yzx/sendSms";
        String method = "POST";
        String appcode = "e9aea6eb77e145cba398f1c6810cd0a0";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("mobile", phoneNumber);
        querys.put("param", "code:"+code);
        //querys.put("param", "这里填写你和商家定义的变量名称和变量值填写格式看上一行代码");
        querys.put("tpl_id", "TP2001127");
        Map<String, String> bodys = new HashMap<String, String>();
        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            HttpResponse response = HttpUtil.doPost(host, path, method, headers, querys, bodys);
            System.out.println(response.toString());

            //获取response的body
            //System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
