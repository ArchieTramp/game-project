package ru.innopolis.services.levelups;

import org.springframework.beans.factory.annotation.Autowired;
import ru.innopolis.models.Player;
import ru.innopolis.repositories.PlayersRepository;

public class LvlStrengthImpl implements LvlStrength {

    @Autowired
    private PlayersRepository playersRepository;


    @Override
    public void lvlStrength(Player player) {

        int str = player.getStrength();
        int point = player.getPoint();

        if (point > 0) {

            str = str + 1;

            player.setStrength(str);

            point = point - 1;

            player.setPoint(point);

            playersRepository.save(player);
        }
    }
}
