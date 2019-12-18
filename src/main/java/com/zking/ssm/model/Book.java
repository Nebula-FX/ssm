package com.zking.ssm.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@ToString
//@JsonIgnoreProperties(value = {"bookId","bookName"}) // 放到类上
public class Book {
    private Integer bookId;

    @NotBlank(message = "书本名字不能为空")
    @JsonProperty("bname")   //类似于取别名
    private String bookName;

    @NotNull(message = "书本价格不能为空")
    @Range(min = 20,max = 100,message = "价格不能小于20大于100")
    private Float price;

    @JsonIgnore
    private Long img;


    private Date createDate;

    public Book(Integer bookId, String bookName, Float price, Long img) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.price = price;
        this.img = img;
    }

    public Book() {
        super();
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Long getImg() {
        return img;
    }

    public void setImg(Long img) {
        this.img = img;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getCreateDate() {
        return createDate;
    }
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}