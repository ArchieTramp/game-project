package ru.innopolis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.models.Player;


@Service
public class LowHPServiceImpl implements LowHPService {

    @Autowired
    private RestPlayerService restPlayerService;

    @Override
    public void lowHP(Player player) {

        int hp = player.getHP();
        int lvl = player.getLevel();
        int str = player.getStrength();
        int hpMax = 50 + (50 * lvl) + (str * 25);
        int hpParametr = (int) (hpMax * 0.15);

        if (hp < hpParametr) {
            restPlayerService.restPlayer(player);
        }

    }
}
