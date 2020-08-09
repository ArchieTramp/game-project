package ru.innopolis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.innopolis.models.Player;
import ru.innopolis.repositories.PlayersRepository;

@Service
@EnableScheduling
public class RestPlayerServiceImpl implements RestPlayerService {

    @Autowired
    private PlayersRepository playersRepository;


    @Override
    @Scheduled (fixedDelay = 3600000)

    public void restPlayer(Player player) {

        int lvl = player.getLevel();
        int str = player.getStrength();
        int charisma = player.getCharisma();

        player.setHP(50 + (50 * lvl) + (str * 25));
        player.setMP(50 + (25 * lvl) + (charisma * 25));

        playersRepository.save(player);
    }
}

