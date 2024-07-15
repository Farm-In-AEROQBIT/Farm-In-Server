package com.farminserver.api.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @GetMapping("/set")
    public String set(@RequestParam String key, @RequestParam String value) {
        redisTemplate.opsForValue().set(key, value);
        return "Set key " + key + " with value " + value;
    }

    @GetMapping("/get")
    public String get(@RequestParam String key) {
        return redisTemplate.opsForValue().get(key);
    }
}
