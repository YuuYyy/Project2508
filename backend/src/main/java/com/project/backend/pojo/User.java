package com.project.backend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data   // 这些注解的用途：自动实现各种常用方法，如getValue、setValue、构造函数等
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @TableId(type = IdType.AUTO)    // id自动递增
    private Integer id;
    private String username;
    private String password;
    private String photo;
}
