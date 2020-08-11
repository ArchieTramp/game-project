package ru.innopolis.services.levelups;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.models.Player;
import ru.innopolis.repositories.PlayersRepository;

@Service
public class LvlIntelligenceImpl implements LvlIntelligence {

    @Autowired
    private PlayersRepository playersRepository;

    @Override
    public String lvlIntelligence(Player player) {

        playersRepository.findByNickName(player.getNickName());

        int intel = player.getIntelligence();

        intel = intel + 1;

        player.setIntelligence(intel);

        playersRepository.save(player);
        return "Поумнел, поздравляю";

    }
}
