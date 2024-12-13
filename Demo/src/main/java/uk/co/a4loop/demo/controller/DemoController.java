package uk.co.a4loop.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import uk.co.a4loop.demo.service.RedisService;

@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class DemoController {

    @Autowired
    RedisService redisService;

    @SuppressWarnings("SameReturnValue")
    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

    @PostMapping("/data")
    public String create(@RequestBody String value) {
        return redisService.create(value);
    }

    @GetMapping("/data/{key}")
    public String read(@PathVariable String key) {
        return redisService.read(key);
    }

    @PutMapping("/data/{key}")
    public boolean update(@PathVariable String key, @RequestBody String value) {
        return redisService.update(key, value);
    }

    @DeleteMapping("/data/{key}")
    public boolean delete(@PathVariable String key) {
        return redisService.delete(key);
    }
}
