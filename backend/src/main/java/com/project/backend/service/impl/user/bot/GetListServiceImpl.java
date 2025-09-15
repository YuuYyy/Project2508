package com.project.backend.service.impl.user.bot;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.project.backend.mapper.BotMapper;
import com.project.backend.pojo.Bot;
import com.project.backend.pojo.User;
import com.project.backend.service.user.bot.GetListService;
import com.project.backend.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GetListServiceImpl implements GetListService {
    @Autowired
    private BotMapper botMapper;

    @Override
    public List<Bot> getlist() {
        Map<String, String> map = new HashMap<>();
        User user = UserUtil.getUser();
        int userId = user.getId();

        QueryWrapper<Bot> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);

        return botMapper.selectList(queryWrapper);
    }
}