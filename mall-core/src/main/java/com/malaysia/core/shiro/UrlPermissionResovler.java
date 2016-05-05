package com.malaysia.core.shiro;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.PermissionResolver;
import org.apache.shiro.authz.permission.WildcardPermission;

/** 决定调用那种url资源匹配
 * Created by abner on 2016/3/7.
 */
public class UrlPermissionResovler implements PermissionResolver {
//    @Override
    public Permission resolvePermission(String s) {
        if(s.startsWith("/")){
            return new UrlPermission(s);
        }
        return new WildcardPermission(s);
    }
}
