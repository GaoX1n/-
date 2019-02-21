package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("emsUser")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("login")
    public String login(String username, String password, HttpSession session){
        try {
            User user = userService.login(username, password);
            session.setAttribute("user",user);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/emsEmployee/selectAll";
    }
    @RequestMapping("regist")
    public String regist(User user, String kaptcha, HttpSession session, Map map){
        String kapt =(String)session.getAttribute("kaptcha");
        System.out.println(user);
        if(kaptcha.equalsIgnoreCase(kapt)){
            try {
                int i=userService.regist(user);
            }catch (Exception e){
                e.printStackTrace();
            }
            return "redirect:/login.jsp";
        }else {
            map.put("error","验证码错误");
            return "regist";
        }
    }
}
