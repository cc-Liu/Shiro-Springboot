package com.lc.config;

import com.lc.entity.User;
import com.lc.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class SysRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("授权用户");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //info.addStringPermission("user:update");//授权update

        //获取当前对象
        Subject subject = SecurityUtils.getSubject();
        User currenUser  = (User) subject.getPrincipal();//拿到user对线
        info.addStringPermission(currenUser.getPerm());
        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("认证");
        //获取当前登录用户
        UsernamePasswordToken userToken = (UsernamePasswordToken)authenticationToken;
        //Object token2 = authenticationToken.getCredentials().toString();
        User user = userService.selecByName(userToken.getUsername());
        if(user == null){
            return null;//用户不存在 返回login方法
        }
        return new SimpleAuthenticationInfo(user,userToken.getPassword(),"");
    }
}
