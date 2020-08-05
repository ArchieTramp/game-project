package ru.innopolis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.innopolis.models.Player;
import ru.innopolis.repositories.PlayersRepository;
import ru.innopolis.services.LootCaravanService;

/**
 * PlayerController
 *
 * @author "Andrei Prokofiev"
 */

@Controller
public class PlayerController {

    @Autowired
    PlayersRepository playersRepository;

    @Autowired
    LootCaravanService lootCaravanService;

    @GetMapping("/{playerId}")
    public String getPlayerPage(ModelMap model, @PathVariable Long playerId){

        Player player = playersRepository.findById(playerId).get();
        model.addAttribute("player", player);
        return "player";
    }

    @GetMapping("/start/{playerId}")
    public String startGame(ModelMap model,  @PathVariable Long playerId){
        Player player = playersRepository.findById(playerId).get();
        System.out.println(model);
        model.addAttribute("player", player);
        return "index";
    }

    @GetMapping("/lootcaravan/{playerId}")
    public String lootCaravanController(ModelMap model,  @PathVariable Long playerId){
        Player player = playersRepository.findById(playerId).get();
//        lootCaravanService.lootCaravan(player);
        model.addAttribute("player", player);

        return "index";

    }

}
