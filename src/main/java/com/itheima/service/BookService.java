package com.itheima.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.domain.Book;

import java.util.List;

/**
 * @aythor YOLO
 * @create 2022--06--07 21:45
 */
public interface BookService {
    boolean save(Book book);

    boolean delete(Integer id);

    boolean update(Book book);

    Book selectById(Integer id);

    List<Book> selectAll();

    Page<Book> getPage(int pageNum, int pageSize);

    Page<Book> getPage(int pageNum, int pageSize, Book book);


}
