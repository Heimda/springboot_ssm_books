package com.itheima.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.domain.Book;
import org.apache.ibatis.annotations.Mapper;

/**
 * @aythor YOLO
 * @create 2022--06--07 21:46
 */
@Mapper
public interface BookDao extends BaseMapper<Book> {
}
