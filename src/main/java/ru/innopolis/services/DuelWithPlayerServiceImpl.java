package ru.innopolis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.models.Player;
import ru.innopolis.repositories.PlayersRepository;
import ru.innopolis.services.games.gameDice.GameDice;

@Service
public class DuelWithPlayerServiceImpl implements DuelWithPlayerService {

    @Autowired
    private PlayersRepository playersRepository;
    @Autowired
    private GameDice gameDice;
    @Autowired
    private LevelUpByExpService levelUpByExpService;
    @Autowired
    private LowHPService lowHPService;


    @Override
    public String duelWithPlayer(Player player, Player player1) {

        lowHPService.lowHP(player);

        long timeCheckin = player.getRestTime();
        long timeNow = System.currentTimeMillis();

        if (timeNow > timeCheckin + 3600000) {



            int mp = player.getMP();
            int exp = player.getExperience();
            int str = player.getStrength();


            int str1 = player1.getStrength();
            int lvl1 = player1.getLevel();


            if (mp >= 20) {

                int strBattle = str - str1;
                int dice;

                if (strBattle > 0) {
                    dice = strBattle;
                } else {
                    dice = 0;
                }

                int howManyDices = 1 + dice;

                for (int i = 0; i < howManyDices; i++) {

                    int throwDice = gameDice.executeGame();

                    if (throwDice >= 5) {

                        int hp1 = player1.getHP();

                        int dmg = 10 + (str * 15);

                        hp1 = hp1 - dmg;
                        exp = exp + 20 + (lvl1 * 5);

                        player.setExperience(exp);

                        player1.setHP(hp1);

                        levelUpByExpService.levelUpByExp(player);

                        playersRepository.save(player);
                        playersRepository.save(player1);

                        return "Отличный выстрел ковбой! Ты снес ему " + hp1 + " здоровья";

                    } else {

                        return "Неудача тоже опыт, ковбой! Пробуй еще!";
                    }
                }
            } else {

                return "Кто идет в бой уставший? Или трезвый? Отдохни или выпей!";
            }
        }
        else {
            return "Ну и куда ты? Отдохни до конца, а потом в бой!";
        }

       return "Дуэль дело такое, сегодня ты, завтра тебя!";
    }
}

