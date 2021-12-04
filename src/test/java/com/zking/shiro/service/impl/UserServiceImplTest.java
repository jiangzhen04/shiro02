package com.zking.shiro.service.impl;

import com.zking.shiro.model.User;
import com.zking.shiro.service.IUserService;
import com.zking.shiro.utils.PasswordHelper;
import org.junit.Test;
import sun.security.util.Password;

import javax.annotation.Resource;

import java.util.Set;

import static org.junit.Assert.*;

public class UserServiceImplTest extends BaseTestCase{

    @Resource
    private IUserService userService;

    private User user;

    @Override
    public void setUp() {
        super.setUp();
        user = new User();
    }

    @Test
    public void insert() {
        user.setUsername("ls");
        String salt = PasswordHelper.createSalt();
        //加密后的凭证
        String pwd = PasswordHelper.createCredentials("123",salt);
        user.setPassword(pwd);
        user.setSalt(salt);
        userService.insert(user);
    }

    @Test
    public void login() {

        User zs = userService.login("zs");
        System.out.println(zs);

    }


    @Test
    public void findRoles() {

        Set<String> roles = userService.findRoles("admin");
        for (String r : roles) {
            System.out.println(r);
        }

    }

    @Test
    public void findPre() {
        Set<String> zs = userService.findPermissions("zs");
        for (String z : zs) {
            System.out.println(z);
        }

    }



}