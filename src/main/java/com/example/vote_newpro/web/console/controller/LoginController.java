package com.example.vote_newpro.web.console.controller;

import com.example.vote_newpro.web.console.domain.entity.TableUserEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class LoginController {
    @PostMapping("/loginok")
    public String loginsuccess(Model model){
        model.addAttribute("msg","loginSuccess");
        return "redirect:/menu";
    }
}
