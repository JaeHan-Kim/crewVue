package com.crew.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ViewController {

    @GetMapping("/")
    public String main() {
        log.info("path root");
        return "/index";
    }
    
    @GetMapping("api/c")
    public String main2() {
        log.info("path main2");
        return "1";
    }
}
