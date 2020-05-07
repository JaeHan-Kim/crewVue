package com.crew.web.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * 클래스명: <code>ViewController</code><br/><br/>
 *
 * 설명을 기입하세요
 *
 * @since 2020. 5. 6.
 * @author JaeHan-Kim
 *
 */
@Slf4j
@Controller
public class ViewController implements ErrorController {

    @GetMapping("/")
    public String main() {
        log.info("path root");
        return "/index";
    }
    
    @GetMapping("/error")
    public String error(){
        return "/index";
    }
    
    @Override
    public String getErrorPath() {
        log.info("error!!");
        return "/error";
    }

}
