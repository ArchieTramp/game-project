package ru.innopolis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.innopolis.forms.UserForm;
import ru.innopolis.services.SignUpService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;


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

    @PostMapping("/signup")
    public String signUp(UserForm userForm, HttpServletRequest request, ModelMap model) {

        service.signUp(userForm);
        return "redirect:/login";
    }
}
