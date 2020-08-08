package ru.innopolis.services;

import org.springframework.beans.factory.annotation.Autowired;
import ru.innopolis.models.Player;
import ru.innopolis.models.User;
import ru.innopolis.repositories.PlayersRepository;
import ru.innopolis.services.games.gameDice.GameDice;

public class LootPlayerServiceImpl implements LootPlayerService {

    @Autowired
    private PlayersRepository playersRepository;
    private GameDice gameDice;
    private LevelUpByExpServiceImpl levelUpByExpService;
    private LowHPServiceImpl lowHPService;

    @Override
    public void lootPlayer(Player player, Player player1) {
        lowHPService.lowHP(player);
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
            }
            else {
                dice = 0;
            }

            int howManyDices = 1 + dice;

            for (int i = 0; i < howManyDices; i++) {

                int throwDice = gameDice.executeGame();

                if (throwDice >= 5) {
                    gold = (int) (gold + (gold1 * 0.2));
                    gold1 = (int) (gold1 - (gold1 * 0.2));
                    exp = exp + 10 + (lvl1 * 5);

                    player.setGold(gold);
                    player.setExperience(exp);

                    player1.setGold(gold1);

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

