package com.lc.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    //ShiroFilterFactoryBean
    //过滤
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);

        //添加shiro的内置过滤器
        /**
         * aono 无需认证就可以访问
         * authc 必须认真
         * user 拥有记住我
         * perms 拥有对某个资源的权限才能访问
         * role 拥有某个角色的权限
         */
        Map<String,String> filterMap = new HashMap<>();
        //授权
        filterMap.put("/user/update","perms[user:update]");
        filterMap.put("/user/add","perms[user:add]");

        //拦截
        filterMap.put("/user/*","authc");//认证才可以通过
        bean.setFilterChainDefinitionMap(filterMap);
        bean.setLoginUrl("/login");//登录页
        bean.setUnauthorizedUrl("/unauthorized");
        return  bean;
    }


    //DefaultWebSecurityManager
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("sysRealm") SysRealm sysRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联Realm
        securityManager.setRealm(sysRealm);
        return securityManager;
    }

    //创建realm对象，需要自定义
    @Bean
    public SysRealm sysRealm(){
        return new SysRealm();
    }

    @Bean
    public ShiroDialect getShiroDialect (){
        return new ShiroDialect();
    }
}
