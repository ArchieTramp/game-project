package ru.innopolis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.models.Player;
import ru.innopolis.repositories.PlayersRepository;
import ru.innopolis.services.games.gameDice.GameDice;

@Service
public class LootPlayerServiceImpl implements LootPlayerService {

    @Autowired
    private PlayersRepository playersRepository;
    @Autowired
    private GameDice gameDice;
    @Autowired
    private LevelUpByExpService levelUpByExpService;
    @Autowired
    private LowHPService lowHPService;

    @Override
    public String lootPlayer(Player player, Player player1) {

        lowHPService.lowHP(player);

        long timeCheckin = player.getRestTime();
        long timeNow = System.currentTimeMillis();

        if (timeNow > timeCheckin + 3600000) {

            int mp = player.getMP();
            int exp = player.getExperience();
            int luck = player.getLuck();
            int gold = player.getGold();

            int luck1 = player1.getLuck();
            int gold1 = player1.getGold();
            int lvl1 = player1.getLevel();


            if (mp >= 20) {

                int luckBattle = luck - luck1;
                int dice;

                if (luckBattle > 0) {
                    dice = luckBattle;
                } else {
                    dice = 0;
                }

                int howManyDices = 1 + dice;

                for (int i = 0; i < howManyDices; i++) {

                    int throwDice = gameDice.executeGame();

                    if (throwDice >= 5) {
                        int resultofloot = (int) (gold1 * 0.2);
                        gold = (int) (gold + (gold1 * 0.2));
                        gold1 = (int) (gold1 - (gold1 * 0.2));
                        exp = exp + 10 + (lvl1 * 5);
                        mp = mp - 20;


                        player.setGold(gold);
                        player.setExperience(exp);
                        player.setMP(mp);

                        player1.setGold(gold1);

                        levelUpByExpService.levelUpByExp(player);
                        playersRepository.save(player);
                        playersRepository.save(player1);
                        return "Ты успешно ограбил " + player1.getNickName() + " на " + resultofloot + "золота!";

                    } else {
                        mp = mp - 20;
                        player.setMP(mp);
                        playersRepository.save(player);
                        return "Перебросить бы, а то маловато выбросил";
                    }
                }
            } else {
                return "Мало энергии, отдохнуть бы тебе или выпить в Салуне";
            }
        } else {
            return "Да ты же отдыхаешь, ковбой! Приходи позже!";
        }
        return "Грабить других ребят всегда приятно!";
    }
}

