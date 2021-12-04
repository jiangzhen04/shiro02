package com.zking.shiro.mapper;

import com.zking.shiro.model.User;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer userid);

    /**
     * 注册
     * @param record
     * @return
     */
    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User login(String username);

    /**
     * 通过用户名查询用户的角色
     * @param username
     * @return
     */
    Set<String> findRoles(String username);

    /**
     * 通过用户名查询用户的权限
     * @param username
     * @return
     */
    Set<String> findPermissions(String username);


}