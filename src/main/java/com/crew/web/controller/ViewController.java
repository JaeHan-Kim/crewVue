package com.crew.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ViewController {

    @GetMapping("/")
    public String main() {
        log.info("path root");
        return "1";
    }
    
    @GetMapping("api/c")
    public String main2() {
        log.info("path main2");
        return "1";
    }
}
