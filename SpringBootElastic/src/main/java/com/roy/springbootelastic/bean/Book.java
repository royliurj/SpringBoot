package com.roy.springbootelastic.bean;

import org.springframework.data.elasticsearch.annotations.Document;

//标注文档信息
@Document(indexName = "roy", type = "book")
public class Book {

    private Integer id;
    private String author;
    private String title;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
