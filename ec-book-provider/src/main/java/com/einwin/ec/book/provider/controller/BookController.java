package com.einwin.ec.book.provider.controller;

import com.einwin.ec.book.api.model.Book;
import com.einwin.ec.book.api.service.BookRemoteService;
import com.einwin.ec.book.provider.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


@RestController
public class BookController implements BookRemoteService {

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookService bookService;

//    @Autowired
//    @SuppressWarnings("SpringJavaAutowiringInspection")
//    public BookController(BookService bookService) {
//        this.bookService = bookService;
//    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(){
        return "hello";
    }

    @RequestMapping(value = "/getbyid/{id}", method = RequestMethod.GET)
    public Book getById(@PathVariable("id") Long id){
        System.out.println("到这了");
        Book result = null;
        result = bookService.get(id);
        return result;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public int insertBook(){
        int result = 0;
        Book book1 = new Book();

        book1.setBookId(1002);
        book1.setBookName("水浒传");
        book1.setBookAuthor("施耐庵");
        book1.setRepertory(20);
        book1.setPrice(23);
        book1.setCreatedBy("施耐庵");
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        book1.setCreationDate(timestamp);
        result = bookService.insert(book1);
        return result;//成功为1
    }
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public int updateBook(@PathVariable("id") Long id){

        int result = 0;
        Book book = bookService.get(id);
        book.setBookName("三国演义");
        book.setBookId(1003);
        book.setBookAuthor("罗贯中");
        bookService.update(book);
        return result;//成功之后为0
    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public int delete(@PathVariable("id") Long id){
        int result = 0;
        bookService.delete(id);
        return result;//成功为0
    }

    @GetMapping("/getall")
    public List<Book> getAll(){

        return bookService.getAll();
    }
}
