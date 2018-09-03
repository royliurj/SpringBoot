package com.roy.springbootelastic.repository;


import com.roy.springbootelastic.bean.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface BookRepository extends ElasticsearchRepository<Book,Integer> {

    public List<Book> findByAuthor(String author);
}
