package com.einwin.ec.book.provider.mapper;

import com.einwin.ec.book.api.model.Book;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.junit.Assert.*;
@RestController
public class BookMapperTest {
    @Autowired
    BookMapper bookMapper;
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    //@GetMapping("/getall")
    @Test
    public void getAll() throws Exception {

        List<Book> books = bookMapper.getAll();
        for(Book book : books){
            System.out.println(book);
        }
    }

}