package com.zking.ssm.Controller;

import com.zking.dto.MyFileDto;
import com.zking.ssm.model.Book;
import com.zking.ssm.service.IBookService;
import com.zking.ssm.util.PageBean;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RequestMapping(value = "/book")
@Controller
//@RestController
public class BookController {

    @Autowired
    private IBookService bookService;

    @ModelAttribute
    public void init(Model model){
        System.out.println("init..");

        Book book = new Book();
        model.addAttribute("book",book);

        String[] bookType = {"古典","神话","小说"};
        model.addAttribute("bookType",bookType);

    }

    @RequestMapping(value = "/toAdd")
    public String toAdd(){
        return "book/addBook";
    }

    @RequestMapping(value = "/addBook")
    public String addBook(@Validated @ModelAttribute Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "book/addBook";
        } else {
            bookService.insert(book);
            return "redirect:listBook";//逻辑视图名
        }
    }

    @RequiresRoles(value = "管理员")
    @RequestMapping(value = "/listAll")
    @ResponseBody
    public List<Book> listAll(){
        List<Book> bookList = bookService.listAll();
        return bookList;
    }


    @RequiresPermissions(value = "bookmanager:book:query")
    @RequestMapping(value = "/list1")
    @ResponseBody
    public Book list1(){
        Book book = bookService.selectByPrimaryKey(1);
        book.setCreateDate(new Date());
        return book;
    }

    @RequestMapping(value = "/list2")
    @ResponseBody
    public List<Map> list2(){
        List<Map> maps = bookService.ListMap();
        return maps;
    }

    @RequestMapping(value = "/list3")
    @ResponseBody
    public Map list3(){
       Map map = bookService.ListMapone(1);
        return map;
    }

    @RequestMapping(value = "/toList")
    public String toList(){
        return "book/listBook";
    }

    @RequestMapping(value = "/listBook")
    public String listBook(HttpServletRequest request, Book book,Model model){

        PageBean pageBean = new PageBean();
        pageBean.initPageBean(request,pageBean);
        List<Book> books = bookService.listBookByPager(book, pageBean);

        model.addAttribute("books",books);
        model.addAttribute("pageBean",pageBean);
        return "book/listBook";
    }


    @RequestMapping(value = "/toUpload")
    public String toUpload(){
        System.out.println("toUpload...");
        return "book/upload";
    }

//    @RequestMapping(value = "/upload")
//    public String upload(MyFileDto myFileDto){
//        System.out.println("upload...");
//        Integer bookId = myFileDto.getBookId();
//        MultipartFile file = myFileDto.getFile();
//        System.out.println(bookId);
//        System.out.println(file);
//        return "redirect:/book/listBook";
//    }
}
