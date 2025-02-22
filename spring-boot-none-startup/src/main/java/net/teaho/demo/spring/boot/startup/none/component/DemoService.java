package net.teaho.demo.spring.boot.startup.none.component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author teaho2015<at>gmail.com
 * @date 2020-06
 * @since 1.0.0
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class DemoService {

    private final Map<String, String> map1;
    @Autowired
    private DemoBean demoBean;

    public void printMap() {
        log.info("map is:{}", map1);
        log.info("demoBean is:{}", demoBean);
    }

}
