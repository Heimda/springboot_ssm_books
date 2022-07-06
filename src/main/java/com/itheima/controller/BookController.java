package com.itheima.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.domain.Book;
import com.itheima.exception.BusinessException;
import com.itheima.service.BookService;
import com.itheima.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @aythor YOLO
 * @create 2022--06--07 21:44
 */

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private IBookService bookService;
//    @GetMapping("/{id}")
//    public Result getById(@PathVariable Integer id){
//        Book book = bookService.getById(id);
//        return new Result(book, Code.SELECT_SUC, "查询单个成功！");
//    }
    @Autowired
    private BookService bookService1;
    @GetMapping("/{id}")
    public Book getById1(@PathVariable Integer id){

        return bookService1.selectById(id);
    }
    @GetMapping()
    public Result getAll(){
        List<Book> list = bookService.list();
        //查询一定会成功，但是不一定有数据！
        return new Result(list, Code.SELECT_ALL_SUC, "查询所有成功！");
    }

    @PostMapping()
    public Result insertBook(@RequestBody Book book){
        if(book.getName().equals("123"))
            return new Result(Code.INSERT_ERR, "插入失败，请输入正确的书名");
//            throw new BusinessException(Code.INSERT_ERR, "插入记录失败，请输入正确的书名！");
        bookService.save(book);
        return new Result(null, Code.INSERT_SUC, "插入记录成功！");
    }

    @PutMapping()
    public Result updateBook(@RequestBody Book book){
        if(book.getName().equals("123"))throw new BusinessException(Code.UPDATE_ERR, "修改书本信息失败，请输入正确的书名！");
        bookService.updateById(book);
        return new Result(null, Code.UPDATE_SUC, "更新书本成功！");
    }

    @DeleteMapping("/{id}")
    public Result deleteBook(@PathVariable Integer id){
        boolean flag = bookService.removeById(id);
        if(flag)return new Result(null, Code.DELETE_SUC, "删除成功！");
        return new Result(null, Code.DELETE_ERR, "删除失败！");
    }

//    @GetMapping("/{curPage}/{pageSize}")
//    public Result getPage(@PathVariable(name = "curPage") Integer curPage, @PathVariable(name = "pageSize") Integer pageSize){
//        Page<Book> p = new Page<>(curPage, pageSize);
//        Page<Book> page = bookService.page(p);
//        //如果当前删除的是当前页的最后一个元素的话，那么就会产生空的查询页，正常情况下应该直接查询前面那一页的，那是因为我们没有更新curPage，因此可以设置返回给前端的page
//        if(curPage > page.getPages()){
//            page = bookService.page(new Page<>(page.getPages(), pageSize));
//        }
//
//        //查询到这里一定会成功！无非是有没有数据！
//        return new Result(page, Code.SELECT_PAGE_SUC, "当前页面显示成功！");
//    }
    //分页+条件查询
    @GetMapping("/{curPage}/{pageSize}")
    public Result getPage(@PathVariable(name = "curPage") Integer curPage, @PathVariable(name = "pageSize") Integer pageSize, Book book){
        Page<Book> p = new Page<>(curPage, pageSize);
        Page<Book> page = bookService.getPage(curPage, pageSize, book);

        //如果当前删除的是当前页的最后一个元素的话，那么就会产生空的查询页，正常情况下应该直接查询前面那一页的，那是因为我们没有更新curPage，因此可以设置返回给前端的page
        if(curPage > page.getPages()){
            page = bookService.getPage((int)page.getPages(), pageSize, book);
        }

        //查询到这里一定会成功！无非是有没有数据！
        return new Result(page, Code.SELECT_PAGE_SUC, "当前页面显示成功！");
    }

}
