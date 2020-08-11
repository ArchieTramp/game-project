package ru.innopolis.services.levelups;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.models.Player;
import ru.innopolis.repositories.PlayersRepository;

@Service
public class LvlLuckImpl implements LvlLuck {

    @Autowired
    private PlayersRepository playersRepository;

    @Override
    public String lvlLuck(Player player) {

        playersRepository.findByNickName(player.getNickName());

        int luck = player.getLuck();

        luck = luck + 1;

        player.setLuck(luck);

        playersRepository.save(player);
        return "Поздравляю, удачливый Вы наш";

    }
}
