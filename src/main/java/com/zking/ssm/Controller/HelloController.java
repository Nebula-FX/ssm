package com.zking.ssm.Controller;

import com.zking.ssm.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.RequestWrapper;
import java.util.Locale;
import java.util.Map;

@Controller
public class HelloController {

    @ModelAttribute
    public void init(){
        System.out.println("init..");
    }


    @RequestMapping(value = "/hello")
    public String hello(@RequestParam String name, Book book , @RequestParam Map map, HttpServletRequest request){
        System.out.println("name="+name);
        System.out.println("book"+book);
        System.out.println("map="+map);
        System.out.println("request="+request);
        return "index";
    }


 @RequestMapping(value = "/hello2")
    public ModelAndView hello2(@RequestParam String name, Book book , @RequestParam Map map, HttpServletRequest request){
     ModelAndView modelAndView = new ModelAndView();
     modelAndView.setViewName("index");
     modelAndView.addObject("book",book);
     return null;
    }

    @RequestMapping(value = "/hello3")
    public String hello3(@RequestParam String name, Book book , @RequestParam Map map, HttpServletRequest request,Model model){
        model.addAttribute("name",name);
        return "index";
    }

    @RequestMapping(value = "/hello4")
    public String hello4(@RequestParam String name, Book book , @RequestParam Map map, HttpServletRequest request,Model model){
        request.setAttribute("map",map);
//        return "forward:toIndex";
        return "redireet:toIndex";
    }


    @RequestMapping(value = "/toIndex")
    public String toIndex(){
        System.out.println("toIndex...");
        return "index";
    }


    @RequestMapping(value = "/home/index.html")
    public String toHome(){
        return "login";
    }

    @RequestMapping(value = "/change")
    public String change(String locale , HttpSession session){
        System.out.println("change...");
        if("zh".equals(locale)) {
            session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, Locale.CHINA);
        }else{
            session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, Locale.US);
        }
        return "index";
    }
}
