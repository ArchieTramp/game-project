package ru.innopolis;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.innopolis.games.Game;
import ru.innopolis.games.gameDice.GameDice;
import ru.innopolis.player.Player;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * MainTest
 *
 * @author Almaz_Kamalov
 */
class MainTest {

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testGameDice() throws NoSuchProviderException, NoSuchAlgorithmException {
        Game gameDice = new GameDice();
        Player player = new Player(
                1, "Ivan", 100, 100, 1, 1, 1, 1, 1);

        for (int i = 0; i < 10; i++) {
            player.play(gameDice);
        }
    }
}