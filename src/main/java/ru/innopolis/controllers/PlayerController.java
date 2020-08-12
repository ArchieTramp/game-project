package ru.innopolis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.innopolis.models.Player;
import ru.innopolis.repositories.PlayersRepository;
import ru.innopolis.services.*;
import ru.innopolis.services.levelups.LvlCharisma;
import ru.innopolis.services.levelups.LvlIntelligence;
import ru.innopolis.services.levelups.LvlLuck;
import ru.innopolis.services.levelups.LvlStrength;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

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

    @Autowired
    DuelWithPlayerService duelWithPlayerService;

    @Autowired
    LootPlayerService lootPlayerService;

    @Autowired
    RestPlayerService restPlayerService;

    @Autowired
    LevelUpByGoldService levelUpByGoldService;

    @Autowired
    LvlCharisma lvlCharisma;

    @Autowired
    LvlIntelligence lvlIntelligence;

    @Autowired
    LvlLuck lvlLuck;

    @Autowired
    LvlStrength lvlStrength;

    @GetMapping("/{playerId}")
    public String getPlayerPage( ModelMap model, @PathVariable Long playerId, HttpSession session) {
        Player player = playersRepository.findById(playerId).get();
        session.setAttribute("player", player);
        model.addAttribute("player", player);
        return "player";
    }

    @GetMapping("/start")
    public String getStartPage(ModelMap model, HttpServletRequest httpServletRequest) {
        Player player = (Player) httpServletRequest.getSession().getAttribute("player");
        model.addAttribute("player", player);
        String message = (String) httpServletRequest.getSession().getAttribute("gameMessage");
        model.addAttribute("gameMessage", message);
        httpServletRequest.getSession().removeAttribute("gameMessage");
        if (model.getAttribute("gameMessage") == null) {
            model.addAttribute("gameMessage", "Приветствую тебя, ковбой!!");

        }
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

    @RequestMapping("/start/players")
    public String selectPlayerToDuel(ModelMap model, HttpServletRequest httpServletRequest) {
        List<Player> players = playersRepository.findAll();
        Player player = (Player) httpServletRequest.getSession().getAttribute("player");
        model.addAttribute("player", player);
        model.addAttribute("players", players);
        return "selectplayer";
    }

    @RequestMapping("/start/players/{playerId}")
    public String duel(ModelMap model, @PathVariable Long playerId, HttpServletRequest httpServletRequest, HttpSession session) {
        Player player2 = playersRepository.findById(playerId).get();
        Player player = (Player) httpServletRequest.getSession().getAttribute("player");
        String message = duelWithPlayerService.duelWithPlayer(player, player2);
        session.setAttribute("gameMessage", message);
        return "redirect:/start";

    }
    @RequestMapping("/start/lootplayers")
    public String selectPlayerToLoot(ModelMap model, HttpServletRequest httpServletRequest) {
        List<Player> players = playersRepository.findAll();
        Player player = (Player) httpServletRequest.getSession().getAttribute("player");
        model.addAttribute("player", player);
        model.addAttribute("players", players);
        return "selectplayerloot";
    }

    @RequestMapping("/start/lootplayers/{playerId}")
    public String lootPlayer(ModelMap model, @PathVariable Long playerId, HttpServletRequest httpServletRequest, HttpSession session) {
        Player player2 = playersRepository.findById(playerId).get();
        Player player = (Player) httpServletRequest.getSession().getAttribute("player");
        String message = lootPlayerService.lootPlayer(player, player2);
        session.setAttribute("gameMessage", message);
        return "redirect:/start";
    }

    @RequestMapping("/rest")
    public String rest(ModelMap model, HttpServletRequest httpServletRequest) {
        Player player = (Player) httpServletRequest.getSession().getAttribute("player");
        String message = restPlayerService.restPlayer(player);
        model.addAttribute("gameMessage", message);
        return "index";
    }

    @RequestMapping("/levupbygold")
    public String levUpByGold(ModelMap model, HttpServletRequest httpServletRequest) {
        Player player = (Player) httpServletRequest.getSession().getAttribute("player");
        String message = levelUpByGoldService.levelUp(player);
        model.addAttribute("gameMessage", message);
        return "index";
    }

    @RequestMapping("/lvlcharisma")
    public String lvlCharisma(ModelMap model, HttpServletRequest httpServletRequest) {
        Player player = (Player) httpServletRequest.getSession().getAttribute("player");
        String message = lvlCharisma.lvlCharisma(player);
        model.addAttribute("gameMessage", message);
        return "index";
    }

    @RequestMapping("/lvlintelligence")
    public String lvlIntelligence(ModelMap model, HttpServletRequest httpServletRequest) {
        Player player = (Player) httpServletRequest.getSession().getAttribute("player");
        String message = lvlIntelligence.lvlIntelligence(player);
        model.addAttribute("gameMessage", message);
        return "index";
    }

    @RequestMapping("/lvlluck")
    public String lvlLuck(ModelMap model, HttpServletRequest httpServletRequest) {
        Player player = (Player) httpServletRequest.getSession().getAttribute("player");
        String message = lvlLuck.lvlLuck(player);
        model.addAttribute("gameMessage", message);
        return "index";
    }

    @RequestMapping("/lvlstrength")
    public String lvlStrength(ModelMap model, HttpServletRequest httpServletRequest) {
        Player player = (Player) httpServletRequest.getSession().getAttribute("player");
        String message = lvlStrength.lvlStrength(player);
        model.addAttribute("gameMessage", message);
        return "index";
    }






}
