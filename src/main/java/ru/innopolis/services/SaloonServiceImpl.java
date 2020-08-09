package ru.innopolis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.models.Player;
import ru.innopolis.repositories.PlayersRepository;
import ru.innopolis.services.games.gameDice.GameDice;


@Service
public class SaloonServiceImpl implements SaloonService {

    @Autowired
    private PlayersRepository playersRepository;
    @Autowired
    private GameDice gameDice;

    @Override
    public String drinkingPoison(Player player) {

        long timeCheckin = player.getSaloonTime();
        long timeNow = System.currentTimeMillis();

        if (timeNow > (timeCheckin + 3600000)) {


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
                    long time = System.currentTimeMillis();

                    player.setMP(mp);
                    player.setHP(hp);
                    player.setSaloonTime(time);
                    playersRepository.save(player);
                    return "Выпил";
                } else {
                    return "Перебрось";
                }
            }
        }
        else {
            System.out.println("Рановато, приходи позже");
        }
            return "Luck";
        }

    }



