package com.ling.lingcloud.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试.
 * 详细说说
 * Class created on 2023/9/30 by 钟舒艺
 *
 * @author 钟舒艺
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class TestController {


    /**
     * 测试
     *
     * @return {@link String}
     */
    @GetMapping("/test")
    public String test() {
        return "test";
    }

}
