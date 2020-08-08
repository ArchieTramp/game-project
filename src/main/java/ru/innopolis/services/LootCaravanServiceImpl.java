package ru.innopolis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.models.Player;
import ru.innopolis.repositories.PlayersRepository;
import java.util.Random;

@Service
public class LootCaravanServiceImpl implements LootCaravanService {

    @Autowired
    private PlayersRepository playersRepository;
    private LevelUpByExpServiceImpl levelUpByExpService;
    private LowHPServiceImpl lowHPService;

    @Override
    public void lootCaravan(Player player) {
        lowHPService.lowHP(player);
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

            mp = mp - 50;
            exp = exp + 10 + (50 * bandit);
            if (doubleLoot >= 20) {
                gold = gold + (resultLoot * 2) + (10 * bandit);
                System.out.println(player.getNickName() + " получил " + gold + "золота и " + exp
                        + " опыта, потратив " + mp); /*в логгер*/
                player.setMP(mp);
                player.setExperience(exp);
                player.setGold(gold);
                playersRepository.save(player);
                levelUpByExpService.levelUpByExp(player);
            } else {
                gold = gold + resultLoot + (10 * bandit);
                System.out.println(player.getNickName() + " получил " + gold + "золота и " + exp
                        + " опыта, потратив " + mp); /*в логгер*/
                player.setMP(mp);
                player.setExperience(exp);
                player.setGold(gold);
                playersRepository.save(player);
                levelUpByExpService.levelUpByExp(player);
            }

        } else {
            System.out.println("Нет энергии, отдохни в Салуне или приходи позже"); /*в логгер*/
        }
    }
}
