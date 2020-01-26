package com.example.vote_newpro.web.console.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError() {
        //do something like logging
        return "redirect:/result";
    }

    @Override
    public String getErrorPath() {
        return "redirect:/result";
    }
}