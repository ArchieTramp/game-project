package ru.innopolis.services.levelups;

import org.springframework.beans.factory.annotation.Autowired;
import ru.innopolis.models.Player;
import ru.innopolis.repositories.PlayersRepository;

public class LvlIntelligenceImpl implements LvlIntelligence {

    @Autowired
    private PlayersRepository playersRepository;

    @Override
    public void lvlIntelligence(Player player) {

        playersRepository.findByNickName(player.getNickName());

        int intel = player.getIntelligence();

        intel = intel + 1;

        player.setIntelligence(intel);

        playersRepository.save(player);

    }
}
