package ru.innopolis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.innopolis.models.Player;
import ru.innopolis.repositories.PlayersRepository;
import ru.innopolis.services.LootCaravanService;
import ru.innopolis.transfer.PlayerDto;
import static ru.innopolis.transfer.PlayerDto.from;


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
    public String getPlayerPage(ModelMap model, @PathVariable Long playerId) {
        PlayerDto player = from(playersRepository.findById(playerId).get());
        model.addAttribute("player", player);
        return "player";
    }

    @GetMapping("/start/{playerId}")
    public String startGame(ModelMap model, @PathVariable Long playerId) {

        PlayerDto player = from(playersRepository.findById(playerId).get());
        model.addAttribute("player", player);
        return "index";
    }

    @GetMapping("/lootcaravan/{playerId}")
    public String lootCaravanController(ModelMap model, @PathVariable Long playerId) {
        Player player1 = playersRepository.findById(playerId).get();
        lootCaravanService.lootCaravan(player1);
        PlayerDto player = from(player1);
        System.out.println(player);
        model.addAttribute("player", player);
        return "index";
    }
}
