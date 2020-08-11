package ru.innopolis.services.levelups;

import org.springframework.beans.factory.annotation.Autowired;
import ru.innopolis.models.Player;
import ru.innopolis.repositories.PlayersRepository;

public class LvlCharismaImpl implements LvlCharisma {

    @Autowired
    private PlayersRepository playersRepository;


    @Override
    public void lvlCharisma(Player player) {


    int charisma = player.getCharisma();
    int point = player.getPoint();

    if (point > 0) {

        charisma = charisma + 1;

        point = point - 1;

        player.setCharisma(charisma);

        player.setPoint(point);

        playersRepository.save(player);
    }
    }
}
