package com.zking.ssm.shiro;

import com.zking.ssm.model.SysUser;
import com.zking.ssm.service.ISysUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;


public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private ISysUserService sysUserService;

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = token.getPrincipal().toString();
        SysUser sysUser = sysUserService.listUserByName(username);

        if (null ==sysUser){
            throw new UnknownAccountException();
        }
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                sysUser.getUsername(),sysUser.getPassword(), ByteSource.Util.bytes(sysUser.getSalt()),this.getName());
        return simpleAuthenticationInfo;
    }

    //权限
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = principalCollection.getPrimaryPrincipal().toString();

        Set<String> roles = sysUserService.listRolesByUserName(username);

        Set<String> permissions = sysUserService.listPermissionsByUserName(username);

        SimpleAuthorizationInfo simpleAuthorizationInfo= new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.getRoles();
        simpleAuthorizationInfo.setStringPermissions(permissions);
        return simpleAuthorizationInfo;
    }
}
