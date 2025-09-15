package com.project.backend.service.impl.user.bot;

import com.project.backend.mapper.BotMapper;
import com.project.backend.mapper.UserMapper;
import com.project.backend.pojo.Bot;
import com.project.backend.pojo.User;
import com.project.backend.service.user.bot.UpdateService;
import com.project.backend.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class UpdataServiceImpl implements UpdateService {
    @Autowired
    private BotMapper botMapper;

    @Override
    public Map<String, String> update(Map<String, String> data) {
        Map<String,String> map = new HashMap<>();
        User user = UserUtil.getUser();

        int bot_id = Integer.parseInt(data.get("bot_id"));
        Bot bot = botMapper.selectById(bot_id);
        if(bot == null){
            map.put("error_message", "Bot不存在或已被删除");
            return map;
        }
        if(!bot.getUserId().equals(user.getId())){
            map.put("error_message", "无权修改该Bot");
            return map;
        }

        String title = data.get("title");
        String description = data.get("description");
        String content = data.get("content");

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
        Bot new_bot = new Bot(      // 新建修改后的bot并替换
                bot.getId(),
                user.getId(),
                title,
                description,
                content,
                bot.getRating(),
                bot.getCreatetime(),
                now
        );
        botMapper.updateById(new_bot);

        map.put("error_message", "success");
        return map;
    }
}
