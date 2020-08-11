package ru.innopolis.services.levelups;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.models.Player;
import ru.innopolis.repositories.PlayersRepository;

@Service
public class LvlStrengthImpl implements LvlStrength {

    @Autowired
    private PlayersRepository playersRepository;


    @Override
    public String lvlStrength(Player player) {

        int str = player.getStrength();
        int point = player.getPoint();

        if (point > 0) {

            str = str + 1;

            player.setStrength(str);

            point = point - 1;

            player.setPoint(point);

            playersRepository.save(player);

            return "Подкачался";

        }
        return "Подкачался";
    }
}
