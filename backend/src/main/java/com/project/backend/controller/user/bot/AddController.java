package com.project.backend.controller.user.bot;

import com.project.backend.service.user.bot.AddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AddController {
    @Autowired
    private AddService addService;  // 注入接口

    @PostMapping("/user/bot/add")
    public Map<String, String> add(@RequestParam Map<String, String> data){
        return addService.add(data);
    }
}
