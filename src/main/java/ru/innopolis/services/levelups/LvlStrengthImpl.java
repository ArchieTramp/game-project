package ru.innopolis.services.levelups;

import org.springframework.beans.factory.annotation.Autowired;
import ru.innopolis.models.Player;
import ru.innopolis.repositories.PlayersRepository;

public class LvlStrengthImpl implements LvlStrength {

    @Autowired
    private PlayersRepository playersRepository;


    @Override
    public void lvlStrength(Player player) {

        playersRepository.findByNickName(player.getNickName());

        int str = player.getStrength();

        str = str + 1;

        player.setStrength(str);

        playersRepository.save(player);

    }
}
