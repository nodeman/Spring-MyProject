package com.teamsoft.spring.controller;

import com.teamsoft.spring.exception.GeneralException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseController {

    @GetMapping("/")
    public String root() throws Exception {
        //throw new Exception("Exception 테스트");
        //throw new GeneralException("GeneralException 테스트");
        return "index";
    }

}