package com.zking.shiro.service;

import com.zking.shiro.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Transactional
public interface IUserService {

    /**
     * 注册
     * @param record
     * @return
     */
    int insert(User record);

    /**
     * 登录
     * @param username
     * @return
     */
    @Transactional(readOnly = true)
    User login(String username);


    /**
     * 通过用户名查询用户的角色
     * @param username
     * @return
     */
    @Transactional(readOnly = true)
    Set<String> findRoles(String username);

    /**
     * 通过用户名查询用户的权限
     * @param username
     * @return
     */
    @Transactional(readOnly = true)
    Set<String> findPermissions(String username);


}