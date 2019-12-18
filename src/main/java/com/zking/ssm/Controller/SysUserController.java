package com.zking.ssm.Controller;

import com.zking.ssm.model.Book;
import com.zking.ssm.model.SysUser;
import com.zking.ssm.service.IBookService;
import com.zking.ssm.util.PageBean;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RequestMapping(value = "/sysUser")
@Controller
public class SysUserController {

    @RequestMapping(value = "/login")
    public String login(SysUser sysUser,Model model){
        String username = sysUser.getUsername();
        String password = sysUser.getPassword();
        String message =null;

        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        try {
            subject.login(token);
        }catch (UnknownAccountException e) {
            e.printStackTrace();
            message="账号错误";
        }catch (IncorrectCredentialsException e){
            e.printStackTrace();
            message="密码错误";
        }catch(Exception e){
            message="账号或密码错误";
        }
        if(null == message){
            return "index";
        }else {
        model.addAttribute("message",message);
            return "login";
        }
    }
}
