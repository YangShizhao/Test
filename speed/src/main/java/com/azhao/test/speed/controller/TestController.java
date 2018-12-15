package com.azhao.test.speed.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @author yshzhao
 * @since 2018/12/15
 */
@Slf4j
@RestController
public class TestController {

    @GetMapping(value = "test")
    public boolean isAvailable() {
        try {
            log.info("local time:{}", LocalDateTime.now());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
