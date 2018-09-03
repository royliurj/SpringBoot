package com.roy.springbootelastic;

import com.roy.springbootelastic.bean.Article;
import com.roy.springbootelastic.bean.Book;
import com.roy.springbootelastic.repository.BookRepository;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootElasticApplicationTests {

	@Autowired
	JestClient jestClient;

	@Autowired
    BookRepository bookRepository;

	@Test
	public void test02(){

        Book book = new Book();
        book.setId(1);
        book.setAuthor("roy");
        book.setTitle("asdf");

        //创建索引
	    bookRepository.index(book);
    }

    public void test03(){
        for (Book book : bookRepository.findByAuthor("roy")) {

            System.out.println(book);
        }
    }

	@Test
	public void contextLoads() throws IOException {

		//1, 给ES中索引一个文档；
		Article article = new Article();
		article.setId(1);
		article.setTitle("good news");
		article.setAuthor("zhang san");
		article.setContent("hello world");

		//构建一个索引
		Index index = new Index.Builder(article).index("roy").type("news").build();
		jestClient.execute(index);
	}

	@Test
	public void search() throws IOException {

	    String query = "{\n" +
                "    \"query\" : {\n" +
                "        \"match_phrase\" : {\n" +
                "            \"content\" : \"hello\"\n" +
                "        }\n" +
                "    }\n" +
                "}";

	    //构建搜索功能
	    Search search = new Search.Builder(query).addIndex("roy").addType("news").build();

	    SearchResult result = jestClient.execute(search);
        System.out.println(result.getJsonString());
    }

}
