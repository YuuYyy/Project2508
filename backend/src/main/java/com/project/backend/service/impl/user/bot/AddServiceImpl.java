package com.project.backend.service.impl.user.bot;

import com.project.backend.mapper.BotMapper;
import com.project.backend.pojo.Bot;
import com.project.backend.pojo.User;
import com.project.backend.service.user.bot.AddService;
import com.project.backend.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class AddServiceImpl implements AddService {
    @Autowired
    private BotMapper botMapper;  // 注入数据库

    @Override
    public Map<String, String> add(Map<String, String> data) {
        User user = UserUtil.getUser();

        String title = data.get("title");
        String description = data.get("description");
        String content = data.get("content");

        Map<String,String> map = new HashMap<>();

        if(title == null || title.length() == 0){
            map.put("error_message", "标题不能为空");
            return map;
        }

        if(title.length() > 100){
            map.put("error_message", "标题长度不能大于100");
            return map;
        }

        if(description == null || description.length() == 0){
            description = "这个用户很懒，什么也没留下";
        }

        if(description != null && description.length() > 300){   // 需要先判空，因为若是null则没有长度
            map.put("error_message", "Bot描述长度不能大于300");
            return map;
        }

        if(content == null || content.length() == 0){
            map.put("error_message", "代码不能为空");
            return map;
        }

        if(title.length() > 10000){
            map.put("error_message", "代码长度不能大于10000");
            return map;
        }

        Date now = new Date();
        Bot bot = new Bot(null, user.getId(), title, description, content, 1500, now, now);

        botMapper.insert(bot);
        map.put("error_message", "success");

        return map;
    }
}
