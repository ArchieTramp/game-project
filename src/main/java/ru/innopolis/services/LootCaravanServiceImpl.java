package ru.innopolis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.innopolis.models.Player;
import ru.innopolis.repositories.PlayersRepository;

import java.util.Random;

@Service
public class LootCaravanServiceImpl implements LootCaravanService {

    @Autowired
    private PlayersRepository playersRepository;
    @Autowired
    private LevelUpByExpService levelUpByExpService;

    @Override
    public String lootCaravan(Player player) {

        long timeCheckin = player.getRestTime();
        long timeNow = System.currentTimeMillis();

        if (timeNow > timeCheckin + 3600000) {
            Random randomLoot = new Random();
            Random randomLuck = new Random();
            int mp = player.getMP();
            int exp = player.getExperience();
            int gold = player.getGold();
            int bandit = player.getBandit();
            int luck = player.getLuck();

            if (mp >= 50) {
                int resultLoot = randomLoot.nextInt(21);
                int resultOfLuck = randomLuck.nextInt(20);
                int doubleLoot = resultOfLuck + luck;
                int newGold = 0;

                mp = mp - 50;
                exp = exp + 10 + (50 * bandit);
                if (doubleLoot >= 20) {
                    newGold = (resultLoot * 2) + (10 * bandit);
                    gold = gold + newGold;

                    player.setMP(mp);
                    player.setExperience(exp);
                    player.setGold(gold);

                    levelUpByExpService.levelUpByExp(player);
                    playersRepository.save(player);


                } else {
                    newGold = resultLoot + (10 * bandit);
                    gold = gold + newGold;

                    player.setMP(mp);
                    player.setExperience(exp);
                    player.setGold(gold);

                    levelUpByExpService.levelUpByExp(player);
                    playersRepository.save(player);

                }
                return "Успешное ограбление каравана! Твоя выручка " + newGold;
            } else {
                return "Ковбой, ты устал, отдохни или выпей в Салуне";
            }

        } else {
            return "Караван ты не догонишь, ты ведь еще даже не отдохнул";
        }
    }
}
