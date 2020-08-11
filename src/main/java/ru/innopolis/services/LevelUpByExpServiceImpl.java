package ru.innopolis.services;

import org.springframework.stereotype.Service;
import ru.innopolis.models.Player;

@Service
public class LevelUpByExpServiceImpl implements LevelUpByExpService {

    @Override
    public void levelUpByExp(Player player) {

        int exp = player.getExperience();
        int lvl = player.getLevel();
        int str = player.getStrength();
        int charisma = player.getCharisma();
        int intel = player.getIntelligence();
        int parametr = (50 * lvl + (50 * (lvl * lvl) / (lvl + lvl)));
        int point = player.getPoint();


        if (exp >= parametr) {
            exp = (int) (exp - parametr + (((intel - 1) * 0.05) * parametr));
            lvl = lvl + 1;
            int hp = 50 + (50 * lvl) + (str * 25);
            int mp = 50 + (25 * lvl) + (charisma * 25);
            point = point + 1;

            player.setHP(hp);
            player.setMP(mp);
            player.setLevel(lvl);
            player.setExperience(exp);
            player.setPoint(point);

        }

    }
}
