package ru.innopolis.services;

import org.springframework.beans.factory.annotation.Autowired;
import ru.innopolis.models.Player;
import ru.innopolis.repositories.PlayersRepository;
import ru.innopolis.services.games.gameDice.GameDice;

public class SaloonServiceImpl implements SaloonService {

    @Autowired
    private PlayersRepository playersRepository;
    private GameDice gameDice;

    @Override
    public void drinkingPoison(Player player) {



        int charisma = player.getCharisma();
        int str = player.getStrength();
        int lvl = player.getLevel();

        for (int i = 0; i < charisma; i++) {

            int throwDice = gameDice.executeGame();
            int hp = player.getHP();
            int mp = player.getMP();


            if (throwDice >= 5) {

                hp = (int) (hp + ((50 + (50 * lvl) + (str * 25)) * 0.1));
                mp = (int) (mp + ((50 + (25 * lvl) + (charisma * 25)) * 0.1));

                player.setMP(mp);
                player.setHP(hp);
                playersRepository.save(player);

            } else {
                System.out.println("Перебрось");
            }
        }
    }
}

