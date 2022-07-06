package com.itheima.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.dao.BookDao;
import com.itheima.domain.Book;
import com.itheima.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @aythor YOLO
 * @create 2022--06--07 21:45
 */

@Service
public class BookServiceImpl2 implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public boolean save(Book book) {
        int i = bookDao.insert(book);
        return i == 1;
    }

    @Override
    public boolean delete(Integer id) {
        return bookDao.deleteById(id) > 0;
    }



    @Override
    public boolean update(Book book) {
        return bookDao.updateById(book) > 0;
    }

    @Override
    @Cacheable(value = "cacheSpace", key = "#id")
    public Book selectById(Integer id) {
        return bookDao.selectById(id);
    }

    @Override
    public List<Book> selectAll() {
        return bookDao.selectList(null);
    }

    @Override
    public Page<Book> getPage(int pageNum, int pageSize) {
        Page<Book> page = new Page<Book>(pageNum, pageSize);
        Page<Book> bookPage = bookDao.selectPage(page, null);
        return bookPage;
    }

    @Override
    public Page<Book> getPage(int pageNum, int pageSize, Book book) {
        return null;
    }
}
