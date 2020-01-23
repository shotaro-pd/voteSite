package com.example.vote_newpro.web.console.controller;

import com.example.vote_newpro.web.console.controller.form.ValidForm;
import com.example.vote_newpro.web.console.domain.entity.VoteResultEntity;
import com.example.vote_newpro.web.console.domain.service.VoteDoSevice;
import com.example.vote_newpro.web.console.framework.auth.LoginUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class VoteController {

    @Autowired
    private VoteDoSevice voteDoSevice;

    @ModelAttribute
    ValidForm setUpForm() {
        return new ValidForm();
    }

    @RequestMapping("/menu")
    public String menuOpen(Model model,@AuthenticationPrincipal LoginUserDetails userDetails){
        model.addAttribute("num",voteDoSevice.checkTohyo(userDetails.getUserId()).size());
        return "menu";
    }

    @RequestMapping("/voteDo")
    public String voteDo(Model model, @AuthenticationPrincipal LoginUserDetails userDetails,ValidForm form){
        List<VoteResultEntity> voteResultEntityList = voteDoSevice.checkTohyo(userDetails.getUserId());
        if (!(voteResultEntityList.isEmpty())){
            return "redirect:/menu";
        }
        model.addAttribute("shinjinList",voteDoSevice.showHappyoshaForm(userDetails.getUserId()).getShinjin());
        model.addAttribute("ninenmeList",voteDoSevice.showHappyoshaForm(userDetails.getUserId()).getNinenme());
        model.addAttribute("form",form);
        return "voteDo";
    }

    @RequestMapping("/tohyo")
    public String tohyo(Model model,@Validated  ValidForm validForm, BindingResult result,@AuthenticationPrincipal LoginUserDetails userDetails){
        if(result.hasErrors()){
            return "redirect:/voteDo";
        }
        voteDoSevice.insertTohyo(validForm,userDetails);
        model.addAttribute("hidden","true");
        model.addAttribute("message","登録が完了しました");
        return "redirect:/menu";
    }

    @RequestMapping("/result")
    public String resultView(Model model){
        model.addAttribute("shinjinResultList",voteDoSevice.result().getShinjin());
        model.addAttribute("ninenmeResultList",voteDoSevice.result().getNinenme());
        return "result";
    }

    @GetMapping("/details")
    public String detailView(Model model,@RequestParam("userId") String userId){
        model.addAttribute("details",voteDoSevice.showDetails(userId));
        return "details";
    }

}
