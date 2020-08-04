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

    @Override
    public void lootPlayer(Player player) {

        int mp = player.getMP();
        int exp = player.getExperience();
        int luck = player.getLuck();
        int gold = player.getGold();

        int luck1 = player1.getLuck();
        int gold1 = player1.getGold();
        int lvl1 = player1.geyLevel();

        if (mp >= 20) {

            int howManyDices = 1 + (luck - luck1); //как-то надо сделать чтобы в минус не уходило//

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
                } else {
                    System.out.println("Перебросить бы, а то маловато будет");
                }
            }
        } else {
            System.out.println("Мало энергии");
        }

    }
}

// TODO: 02.08.2020 решить проблему с доступом к другому игроку player1
