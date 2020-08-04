package ru.innopolis.services;

import org.springframework.beans.factory.annotation.Autowired;
import ru.innopolis.models.Player;
import ru.innopolis.repositories.PlayersRepository;
import ru.innopolis.services.games.gameDice.GameDice;

public class DuelWithPlayerServiceImpl implements DuelWithPlayerService {

    @Autowired
    private PlayersRepository playersRepository;
    private GameDice gameDice;


    @Override
    public void duelWithPlayer(Player player) {
//
//        int mp = player.getMP();
//        int exp = player.getExperience();
//        int str = player.getStrength();
//
//
//        int str1 = player1.getStrength();
//        int lvl1 = player1.geyLevel();
//
//        if (mp >= 20) {
//
//            int howManyDices = 1 + (str - str1); //как-то надо сделать чтобы в минус не уходило//
//
//            for (int i = 0; i < howManyDices; i++) {
//
//                int throwDice = gameDice.executeGame();
//
//                if (throwDice >= 5) {
//
//                    int hp1 = player1.getHP();
//
//                    int dmg = 10 + (str * 15);
//
//                    hp1 = hp1 - dmg;
//                    exp = exp + 20 + (lvl1 * 5);
//
//                    player.setExperience(exp);
//
//                    player1.setHP(hp1);
//
//                    playersRepository.save(player);
//                    playersRepository.save(player1);
//
//                } else {
//                    System.out.println("Перебросить бы, а то маловато будет");
//                }
//            }
//        } else {
//            System.out.println("Мало энергии");
//        }
    }
}

// TODO: 02.08.2020 решить проблему с доступом к другому игроку player1
