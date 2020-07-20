package ru.innopolis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.innopolis.forms.UserForm;
import ru.innopolis.services.SignUpService;


/**
 *
 */
@Controller
public class SignUpController {

    @Autowired
    private SignUpService service;

    @GetMapping("/signup")
    public String getSignUpPage() {
        return "signup";
    }

    @PostMapping("/signUp")
    public String signUp(UserForm userForm) {
        service.signUp(userForm);
        return "redirect:/login";
    }
}
