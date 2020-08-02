package ru.innopolis.services.levelups;

import org.springframework.beans.factory.annotation.Autowired;
import ru.innopolis.models.Player;
import ru.innopolis.repositories.PlayersRepository;

public class LvlCharismaImpl implements LvlCharisma {

    @Autowired
    private PlayersRepository playersRepository;


    @Override
    public void lvlCharisma(Player player) {

    playersRepository.findByNickName(player.getNickName());

    int charisma = player.getCharisma();

    charisma = charisma + 1;

    player.setCharisma(charisma);

    playersRepository.save(player);
    }
}
