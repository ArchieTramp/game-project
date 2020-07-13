package ru.innopolis.games;

import ru.innopolis.games.gameDice.GameDice;
import ru.innopolis.games.player.Player;

/**
 * Main
 *
 * @author "Andrei Prokofiev"
 */
public class Main {
    public static void main(String[] args) {
        Game gameDice = new GameDice();
        Player player = new Player(1, "Ivan", 1000,1000, 0);

        for (int i = 0; i < 1000; i++) {
            gameDice.executeGame();
        }

    }
}
