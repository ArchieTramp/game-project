package ru.innopolis.gamedev.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author 18395435
 * @created_at 07/07/2020 - 14:51
 * @project game-project
 */

@Controller
@RequestMapping("/game")
public class StartPage {

    @GetMapping(value = "/start")
    public @ResponseBody
    String createUser() {
        return "Hello";
    }
}
