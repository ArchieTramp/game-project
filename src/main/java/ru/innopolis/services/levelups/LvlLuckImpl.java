package ru.innopolis.services.levelups;

import org.springframework.beans.factory.annotation.Autowired;
import ru.innopolis.models.Player;
import ru.innopolis.repositories.PlayersRepository;

public class LvlLuckImpl implements LvlLuck {

    @Autowired
    private PlayersRepository playersRepository;

    @Override
    public void lvlLuck(Player player) {

        int luck = player.getLuck();
        int point = player.getPoint();

        if (point > 0) {

            luck = luck + 1;

            player.setLuck(luck);

            point = point - 1;

            player.setPoint(point);

            playersRepository.save(player);
        }

    }
}
