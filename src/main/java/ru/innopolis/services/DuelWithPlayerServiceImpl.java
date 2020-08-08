package ru.innopolis.services;

import org.springframework.beans.factory.annotation.Autowired;
import ru.innopolis.models.Player;
import ru.innopolis.repositories.PlayersRepository;
import ru.innopolis.services.games.gameDice.GameDice;

public class DuelWithPlayerServiceImpl implements DuelWithPlayerService {

    @Autowired
    private PlayersRepository playersRepository;
    private GameDice gameDice;
    private LevelUpByExpServiceImpl levelUpByExpService;
    private LowHPServiceImpl lowHPService;


    @Override
    public void duelWithPlayer(Player player, Player player1) {

        lowHPService.lowHP(player);

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
            }
            else {
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

                    playersRepository.save(player);
                    playersRepository.save(player1);

                    levelUpByExpService.levelUpByExp(player);

                } else {
                    System.out.println("Перебросить бы, а то маловато будет");
                }
            }
        } else {
            System.out.println("Мало энергии");
        }
    }
}

