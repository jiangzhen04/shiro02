package com.zking.shiro.controller;

import com.zking.shiro.model.User;
import com.zking.shiro.service.IUserService;
import com.zking.shiro.utils.PasswordHelper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping
public class StuController {

    @Resource
    private IUserService userService;


    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }


    @RequestMapping("/reg")
    public String reg(User user){

        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        String salt = PasswordHelper.createSalt();
        //加密后的凭证
        String pwd = PasswordHelper.createCredentials(user.getPassword(),salt);
        user.setPassword(pwd);
        user.setSalt(salt);
        userService.insert(user);

        return "login";
    }

    @RequestMapping("/toReg")
    public String toReg(User user){

        return "reg";
    }



    @RequestMapping("/login")
    public String login(User user, Model model){
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),user.getPassword());

        String message = null;
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            message = "账号错误";
        } catch (LockedAccountException e) {
            message = "账号已锁定，请与管理员联系";
        } catch (IncorrectCredentialsException e) {
            message = "密码错误";
        } catch (ExcessiveAttemptsException e) {
            message = "多次登录尝试失败，请60秒后再试";
        }

        if(null==message){
            Session session = subject.getSession();//此session为org.apache。shiro。session。Session
            session.setAttribute("user",user);//登录成功后要保存shiro的会话中，已备之后使用
            return "index";
        } else{
            model.addAttribute("message",message);
            return "login";
        }
    }

    @RequestMapping("/gj")
    @RequiresRoles(value = {"高级用户","管理员"},logical = Logical.OR)
    public String togj(){
        return "gj";
    }


}
