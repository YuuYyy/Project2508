package com.project.backend.controller.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.project.backend.mapper.UserMapper;
import com.project.backend.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired // 调用数据库的mapper需要该注解
    UserMapper userMapper;

    // UserMapper负责将这些方法转化为"select ..."等sql语句
    @GetMapping("/user/all/")
    public List<User> getAllUser(){
        return userMapper.selectList(null);
    }

    @GetMapping("user/{userId}/")
    public User getUser(@PathVariable("userId") Integer userId){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", userId);
        return userMapper.selectOne(queryWrapper);
    }

    @GetMapping("user/add/{userId}/{username}/{password}/")
    public String addUser(@PathVariable("userId") Integer userId,
                          @PathVariable("username") String username,
                          @PathVariable("password") String password){
//        if(password.length()<6){
//            return "密码过短";
//        }
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(password);
        User user = new User(userId, username, encodedPassword);
        userMapper.insert(user);
        return "Add User Successfully";
    }

    @GetMapping("user/delete/{userId}/")
    public String deleteUser(@PathVariable("userId") Integer userId){
        userMapper.deleteById(userId);
        return "Delete User Successfully";
    }
}
