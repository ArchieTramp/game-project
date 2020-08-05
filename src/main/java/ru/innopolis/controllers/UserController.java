package ru.innopolis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping(value = "/users/{userId}")
    public String getUsersPage(ModelMap model, @PathVariable Long userId) {
        User user = usersRepository.getOne(userId);
        model.addAttribute("user", user);
        return "user";
    }

    @PostMapping("/users/{userId}")
    public String bannedUsers(ModelMap model, @PathVariable Long userId) {
        if (userId != 11) {
            bannedPlayerService.bannedUser(userId);
        } else {
            model.addAttribute("message", "Админа банить нельзя");
            return "redirect:/users/{userId}";
        }
        return "redirect:/users";
    }
}
