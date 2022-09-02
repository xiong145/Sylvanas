package com.sylvanas.user.controller;

import cn.hutool.core.codec.Base64;
import com.sylvanas.user.Bo.NameRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author xiong
 */
@RestController
@RequestMapping(value = "user")
public class RedisController {
    @Autowired
    RedisTemplate redisTemplate;

    @RequestMapping(value = "userRedis")
    public Map<String, Object> userRedis() {
        Boolean b = true;
        HashMap hash = new HashMap();
        Integer i = 0;
        while (b) {
            if (i > 100) break;
            NameRedis name = new NameRedis();
            name.setName(Base64.encode(i.toString()));
            redisTemplate.opsForValue().set(i.toString(), name.getName(), 100, TimeUnit.SECONDS);
            hash.put(i.toString(),   redisTemplate.opsForValue().get(i.toString()));
            i++;
        }
        return hash;

    }
}
