package ru.innopolis;

import ru.innopolis.games.Game;
import ru.innopolis.games.Play;
import ru.innopolis.games.gameDice.GameDice;
import ru.innopolis.player.Player;

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
        Player player = new Player(1, "Ivan", 1000,1000, 0);
        Play playeGame = new Player(1, "Ivan", 1000,1000, 0);

        for (int i = 0; i < 1000; i++) {
            gameDice.executeGame();
        }

    }
}
