package com.itheima.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @aythor YOLO
 * @create 2022--06--07 23:10
 */
@SpringBootTest
class BookServiceTest {
    @Autowired
    IBookService iBookService;
    @Test
    void testGetById(){
        iBookService.getById(1);
    }
    @Test
    void testGetAll(){
        List<Book> list = iBookService.list();
        for(Book book : list)
            System.out.println(book);
    }
    @Test
    void testInsert(){
        Book book = new Book();
        book.setName("dobbo");
        book.setType("computer science");
        book.setDescription("RPC的一种实现技术");
        iBookService.save(book);
    }
    @Test
    void testUpdate(){
        Book book = new Book();
        book.setName("dobbo");
        book.setType("computer science");
        book.setId(13);
        book.setDescription("RPC的一种实现技术desc22");
        iBookService.updateById(book);
    }
    @Test
    void testDelete(){
        iBookService.removeById(13);
    }
    @Test
    void getPageTest(){
        Page<Book> page = iBookService.page(new Page<Book>(1,3), null);
        System.out.println(page);

        List<Book> records = page.getRecords();
        System.out.println(records);

    }

}

