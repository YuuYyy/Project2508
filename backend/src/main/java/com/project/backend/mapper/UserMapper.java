package com.project.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.project.backend.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
