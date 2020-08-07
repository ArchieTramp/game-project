package ru.innopolis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.annotation.SessionScope;
import ru.innopolis.forms.PlayerForm;
import ru.innopolis.models.Player;
import ru.innopolis.repositories.PlayersRepository;
import ru.innopolis.services.LootCaravanService;
import ru.innopolis.transfer.PlayerDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import java.util.List;

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
        return "index";
    }

    @PostMapping("/lootcaravan")
    public String lootCaravanController(ModelMap model, HttpServletRequest httpServletRequest) {
        Player player = (Player) httpServletRequest.getSession().getAttribute("player");
        lootCaravanService.lootCaravan(player);
//        PlayerDto player = from(player1);
        model.addAttribute("player", player);
        return "redirect:/start";
    }

    @PostMapping("/creatplayer/delete")
    public String delet(HttpServletRequest httpServletRequest) {
        Player player = (Player) httpServletRequest.getSession().getAttribute("player");
        playersRepository.deleteById(player.getId());
        return "redirect:/";
    }

    @PostMapping("/exitGame")
    public String exitGame(HttpServletRequest httpServletRequest) {
        httpServletRequest.removeAttribute("player");
        return "redirect:/";
    }


}
