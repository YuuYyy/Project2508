package com.project.backend.service.impl.user.account;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.project.backend.mapper.UserMapper;
import com.project.backend.pojo.User;
import com.project.backend.service.user.account.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Map<String, String> register(String username, String password, String confirmedPassword) {
        Map<String, String> map = new HashMap<>();
        if(username == null || password == null) {
            map.put("error_message", "用户名或密码不能为空");
            return map;
        }

        username = username.trim(); // 删除首位空白字符（包括制表符、回车等）
        if(username.length() == 0 || password.length() == 0) {
            map.put("error_message", "用户名或密码不能为空");
            return map;
        }

        if(username.length() < 1 || username.length() > 32) {
            map.put("error_message", "用户名长度：1 ~ 32");
            return map;
        }

        if(password.length() < 1 || password.length() > 32) {
            map.put("error_message", "密码长度：1 ~ 32");
            return map;
        }

        // 检测用户名是否重复
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        List<User> users = userMapper.selectList(queryWrapper);
        if(!users.isEmpty()) {
            map.put("error_message", "用户名已存在");
            return map;
        }

        if(!password.equals(confirmedPassword)) {
            map.put("error_message", "两次输入的密码不同！");
            return map;
        }

        String encodePassword = passwordEncoder.encode(password);
        String photo = "https://cdn.acwing.com/media/user/profile/photo/124742_lg_7ccc04d030.jpg";
        User user = new User(null, username, encodePassword, photo);
        userMapper.insert(user);    // 存入数据库

        map.put("error_message", "success");
        return map;
    }
}
