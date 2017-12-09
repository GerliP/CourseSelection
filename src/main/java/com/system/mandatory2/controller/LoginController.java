package com.system.mandatory2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by gerli on 18/11/2017.
 */
@Controller
public class LoginController {

    @GetMapping("/")
    public String index(){
        return "login";
    }
}
