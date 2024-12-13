package uk.co.a4loop.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RedisService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public String create(String value) {
        UUID uuid = UUID.randomUUID();
        redisTemplate.opsForValue().set(uuid.toString(), value);
        return uuid.toString();
    }

    public String read(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public boolean update(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
        return true;
    }

    public boolean delete(String key) {
        return redisTemplate.delete(key);
    }
}
