package ru.innopolis;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.innopolis.services.games.Game;
import ru.innopolis.services.games.gameDice.GameDice;
import ru.innopolis.models.Player;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

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
        Player player = new Player();

        for (int i = 0; i < 10; i++) {
            player.play(gameDice);
        }
    }
}