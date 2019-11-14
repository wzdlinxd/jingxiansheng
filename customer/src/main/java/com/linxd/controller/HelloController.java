package com.linxd.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @author linxd
 * @date 2019/11/14 16:38
 * Description: No Description
 */
@RestController
public class HelloController {
    @GetMapping("/hi")
    public String hello() {
        return "hi";
    }
}
