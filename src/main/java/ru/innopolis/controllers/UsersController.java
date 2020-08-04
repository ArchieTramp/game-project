package ru.innopolis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.innopolis.models.Role;
import ru.innopolis.models.User;
import ru.innopolis.repositories.UsersRepository;
import ru.innopolis.services.BannedPlayerService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 *
 */
@Controller
public class UsersController {
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private BannedPlayerService bannedPlayerService;

    @GetMapping(value = "/users")
    public String getUsersPage(ModelMap model, Authentication authentication) {
//        if (authentication.getCredentials() != Role.ADMIN) {
//            return "profile";
//        }
        model.addAttribute("usersFromServer", usersRepository.findAll());
        return "users";
    }

}
