package com.lc.controller;


import com.lc.entity.User;
import com.lc.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MyConller {

    @Autowired
    private UserService userService;

    @RequestMapping("index")
    public String toIndex(Model model){
        model.addAttribute("msg","hello shiro");
        return "index";
    }

    @RequestMapping("/user/add")
    public String add(){
        return "user/add";
    }

    @RequestMapping("/user/update")
    public String update(){
        return "user/update";
    }

    @RequestMapping("/unauthorized")
    @ResponseBody
    public String unauthorized(){
        return "未授权";
    }

    @PostMapping("/selectName")
    public User selectName(String name){
        return userService.selecByName(name);
    }


    /**
     * 登录
     * @return
     */
    @RequestMapping("/login")
    public String login(String username,String password,Model model){
        //获取当前用户
        Subject subject = SecurityUtils.getSubject();
        //封装用户的登录数据
        UsernamePasswordToken userToken = new UsernamePasswordToken(username,password);
        //userToken.isRememberMe();记住我
        try {
            subject.login(userToken);//在认证里进行性操作
            Session session =  subject.getSession();
            session.setAttribute("username",username);
            return "index";
        }catch (UnknownAccountException e){//用户名不存在
            model.addAttribute("msg","用户名不存在");
            return "login";
        }catch (IncorrectCredentialsException e){//密码错误
            model.addAttribute("msg","密码错误");
            return "login";
        }catch (LockedAccountException e){//密码错误
            model.addAttribute("msg","密码错误");
            return "login";
        }
    }

    /**
     * 登出
     */
    @RequestMapping("/loginout")
    public String loginout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "login";
    }
}
