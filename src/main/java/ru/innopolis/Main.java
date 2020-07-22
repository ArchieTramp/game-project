package ru.innopolis;

import ru.innopolis.services.games.Game;
import ru.innopolis.services.games.gameDice.GameDice;
import ru.innopolis.models.Player;
import ru.innopolis.models.User;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

/**
 * Main
 *
 * @author "Andrei Prokofiev"
 */

public class Main {
    public static void main(String[] args) throws NoSuchProviderException, NoSuchAlgorithmException {
        Game gameDice = new GameDice();
        User user = User.builder()
                .id(0L)
                .firstName("A")
                .build();

        Player player = Player.builder()
                .id(user.getId())
                .build();
        for (int i = 0; i < 1000; i++) {
            player.play(gameDice);
        }


    }
}
