package com.einwin.ec.book.provider.mapper;

import com.einwin.ec.book.api.model.Book;
import com.einwin.framework.mapper.GenericMapper;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

@Mapper
public interface BookMapper extends GenericMapper<Book, Long> {

    /**
     * 查询所有书
     * @return
     */
    List<Book> getAll();

}
