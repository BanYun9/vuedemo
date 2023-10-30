package com.example.spdemo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "A01")
public class A01 {
    private static final long serialVersionUID = 1L;

    @TableId
    private String A00;

    /**
     * 姓名
     */
    private String A0101;

    /**
     * 性别
     */
    private String A0104;

    /**
     * 出生日期
     */
    private Date A0107;
}
