package ru.innopolis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.innopolis.models.User;
import ru.innopolis.repositories.UsersRepository;
import ru.innopolis.services.BannedPlayerService;

/**
 * UserController
 *
 * @author "Andrei Prokofiev"
 */

@Controller
public class UserController {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private BannedPlayerService bannedPlayerService;

    @GetMapping(value = "/users/{userID}")
    public String getUsersPage(ModelMap model, @PathVariable Long userID) {
        User user = null;
        try {
            user = usersRepository.getOne(userID);
            model.addAttribute("allowBanned", false);

        } catch (Exception ex) {
            model.addAttribute("errorMessage", ex.getMessage());
            return "user";
        }
        model.addAttribute("user", user);

        return "user";
    }

    @PostMapping("/users/{userID}")
    public String bannedUsers(ModelMap model, @PathVariable Long userID) {
//        List<User> usersFromserver = usersRepository.findAll();
        if (userID != 11) {
            bannedPlayerService.bannedPlayer(userID);
        } else {

            model.addAttribute("message", "Админа банить нельзя");
            return "redirect:/users/{userID}";
        }
        return "redirect:/users";
    }
}
