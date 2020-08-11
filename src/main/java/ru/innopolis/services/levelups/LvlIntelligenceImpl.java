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

        int intel = player.getIntelligence();
        int point = player.getPoint();

        if (point > 0) {

            intel = intel + 1;

            player.setIntelligence(intel);

            point = point - 1;

            player.setPoint(point);

            playersRepository.save(player);

            return "Поумнел, поздравляю";
        }
        return "Поумнел, поздравляю";
    }
}
