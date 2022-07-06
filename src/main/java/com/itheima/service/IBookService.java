package com.itheima.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.domain.Book;

/**
 * @aythor YOLO
 * @create 2022--06--08 9:54
 */
public interface IBookService extends IService<Book> {

    Page<Book> getPage(Integer curPage, Integer pageSize, Book book);
}
