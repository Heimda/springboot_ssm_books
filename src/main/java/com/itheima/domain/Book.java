package com.itheima.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @aythor YOLO
 * @create 2022--06--07 21:53
 */

@Data
@TableName("tbl_book")
public class Book {
    //主键自增策略
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String type;
    private String name;
    @TableField(value = "description")
    private String description;

}
