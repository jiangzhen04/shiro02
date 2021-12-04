package com.zking.shiro.utils;

import com.zking.shiro.model.User;
import com.zking.shiro.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.Set;

public class MyRealm extends AuthorizingRealm {

    @Resource
    private IUserService userService;

//    @Override
//    public void setName(String name) {
//        super.setName("MyRealm");
//    }

//    @Override
//    public boolean supports(AuthenticationToken token) {
//        return token instanceof UsernamePasswordToken;
//    }

    //提供授权信息
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //获取用户名
        String username = principals.getPrimaryPrincipal().toString();

        //根据用户名查询用户的角色
        Set<String> roles = userService.findRoles(username);

        //根据用户名查询用户权限
        Set<String> permissions = userService.findPermissions(username);

        SimpleAuthorizationInfo authorizationInfo =
                new SimpleAuthorizationInfo();

        //设置角色
        authorizationInfo.setRoles(roles);

        //设置权限
        authorizationInfo.setStringPermissions(permissions);

        return authorizationInfo;
    }

    /**
     * 提供认证信息
     * @param
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取用户名
        String username = token.getPrincipal().toString();
        //获取密码
        String passwrod = token.getCredentials().toString();

        //通过用户名查询用户信息
        User u = userService.login(username);

        if(null==u){
            throw new RuntimeException("用户名不存在");
        }

        //保存用户认证信息
        SimpleAuthenticationInfo simpleAuthenticationInfo =
                new SimpleAuthenticationInfo(
                        u.getUsername(),
                        u.getPassword(),
                        ByteSource.Util.bytes(u.getSalt()),
                        this.getName()
                );


        return simpleAuthenticationInfo;
    }


}
