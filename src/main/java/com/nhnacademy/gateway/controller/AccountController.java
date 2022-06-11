package com.nhnacademy.gateway.controller;

import com.nhnacademy.gateway.domain.dto.request.AccountRegisterRequestDTO;
import com.nhnacademy.gateway.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;
    @GetMapping(value = "accounts/register")
    public ModelAndView registerPage() {
        return new ModelAndView("/account/register");
    }

    @PostMapping(value = "accounts/register")
    public ModelAndView register(@ModelAttribute AccountRegisterRequestDTO requestDTO) {
        accountService.registerAccountRequest(requestDTO);

        return new ModelAndView("redirect:/");
    }
}
