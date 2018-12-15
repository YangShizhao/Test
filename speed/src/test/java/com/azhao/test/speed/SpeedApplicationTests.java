package com.azhao.test.speed;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpeedApplicationTests {

    @Test
    public void contextLoads() {
        log.info("make sonarLint happy");
    }

}

