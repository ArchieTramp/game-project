package ru.innopolis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.innopolis.forms.PlayerForm;
import ru.innopolis.services.LootCaravanService;
import sun.net.httpserver.HttpServerImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;

/**
 *
 */

@Controller
public class LootCaravanController {

    @Autowired
    private LootCaravanService lootCaravanService;

    @GetMapping("/lootCaravan")
    public String getLootCaravanPage() {
        return "lootCaravan";
    }
    @PostMapping("/lootCaravan")
    public String lootCaravan(PlayerForm playerForm, HttpServletRequest request, ModelMap model) {
        lootCaravanService.lootCaravan(playerForm);
        return "redirect:/start";
    }

    }



