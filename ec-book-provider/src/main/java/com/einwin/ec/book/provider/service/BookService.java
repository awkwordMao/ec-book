package com.einwin.ec.book.provider.service;

import com.einwin.ec.book.api.model.Book;
import com.einwin.ec.book.provider.mapper.BookMapper;
import com.einwin.framework.mapper.GenericMapper;
import com.einwin.framework.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookService")
public class BookService extends GenericService<Book, Long> {
    public BookService(GenericMapper<Book, Long> genericMapper) {
        super(genericMapper);
    }
    @Autowired
    BookMapper bookMapper;

    public List<Book> getAll(){
        List<Book> books = bookMapper.getAll();
        for(Book book : books){
            System.out.println(book);
        }
        return books;
    }
}
