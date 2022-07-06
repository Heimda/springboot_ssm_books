package com.itheima.dao;

/**
 * @aythor YOLO
 * @create 2022--06--07 23:10
 */

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookDaoTest{

    @Autowired
    private BookDao bookDao;
    @Test
    void testPage(){
        IPage<Book> page = new Page<Book>(2,3);
        IPage<Book> bookIPage = bookDao.selectPage(page, null);
        System.out.println(bookIPage);
    }
}