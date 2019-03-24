package com.opendatams.controller;

import com.opendatams.service.CookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private CookService cookService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/one")
    public Map<String, Object> cookOne(
            @RequestParam("name") final String name
    ) {
        final long start = System.currentTimeMillis();

        final Map<String, Object> map = new HashMap<>();
        map.put("顾客", name);
        map.put("份数", 1);
        map.put("食物", cookService.cookOneFood());
        map.put("耗时", System.currentTimeMillis() - start);

        return map;
    }

    @GetMapping("/async")
    public Map<String, Object> cookAsync(
            @RequestParam("name") final String name
    ) {
        final long start = System.currentTimeMillis();

        final Map<String, Object> map = new HashMap<>();
        map.put("顾客", name);
        map.put("份数", 1);
        map.put("食物", cookService.cookAsyncFood());
        map.put("耗时", System.currentTimeMillis() - start);

        return map;
    }

    @GetMapping("/multi")
    public Map<String, Object> cookMulti(
            @RequestParam("name") final String name,
            @RequestParam("count") final int count
    ) {
        final long start = System.currentTimeMillis();

        final Map<String, Object> map = new HashMap<>();
        map.put("顾客", name);
        map.put("份数", count);
        map.put("食物", cookService.cookMultiFood(count));
        map.put("耗时", System.currentTimeMillis() - start);

        return map;
    }
}