package ru.innopolis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.innopolis.models.Player;
import ru.innopolis.repositories.PlayersRepository;
import ru.innopolis.services.BarracksService;
import ru.innopolis.services.LootCaravanService;
import ru.innopolis.services.SaloonService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


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

    @Autowired
    BarracksService barracksService;

    @Autowired
    SaloonService saloonService;

    @GetMapping("/{playerId}")
    public String getPlayerPage(ModelMap model, @PathVariable Long playerId, HttpSession session) {
        Player player = playersRepository.findById(playerId).get();
        session.setAttribute("player", player);
        model.addAttribute("player", player);
        return "player";
    }

    @GetMapping("/start")
    public String getStartPage(ModelMap model, HttpServletRequest httpServletRequest) {
        Player player = (Player) httpServletRequest.getSession().getAttribute("player");
        model.addAttribute("player", player);
        model.addAttribute("gameMessage", "Hello cowboy!");
        return "index";
    }

    @PostMapping("/creatplayer/delete")
    public String delet(HttpServletRequest httpServletRequest) {
        Player player = (Player) httpServletRequest.getSession().getAttribute("player");
        playersRepository.deleteById(player.getId());
        return "redirect:/";
    }

    @PostMapping("/lootcaravan")
    public String lootCaravanController(ModelMap model, HttpServletRequest httpServletRequest) {
        Player player = (Player) httpServletRequest.getSession().getAttribute("player");
        String message = lootCaravanService.lootCaravan(player);
        model.addAttribute("player", player);
        model.addAttribute("gameMessage", message);
        return "index";
    }

    @PostMapping("/mercenary")
    public String barracksController(ModelMap model, HttpServletRequest httpServletRequest) {
        Player player = (Player) httpServletRequest.getSession().getAttribute("player");
        String message = barracksService.mercenaryInBarracks(player);
        model.addAttribute("player", player);
        model.addAttribute("gameMessage", message);
        return "index";
    }

    @PostMapping("/exitGame")
    public String exitGame(HttpServletRequest httpServletRequest) {
        httpServletRequest.removeAttribute("player");
        return "redirect:/";
    }

    @PostMapping("/saloon")
    public String saloon(ModelMap model, HttpServletRequest httpServletRequest) {
        Player player = (Player) httpServletRequest.getSession().getAttribute("player");
        String message = saloonService.drinkingPoison(player);
        model.addAttribute("player", player);
        model.addAttribute("gameMessage", message);
        return "index";
    }



}
