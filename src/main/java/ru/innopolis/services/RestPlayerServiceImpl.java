package ru.innopolis.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.innopolis.models.Player;
import ru.innopolis.repositories.PlayersRepository;

@Service
@AllArgsConstructor
public class RestPlayerServiceImpl implements RestPlayerService {

    private final PlayersRepository playersRepository;

    @Override
    public void restPlayer(Player player) {

        int lvl = player.getLevel();
        int str = player.getStrength();
        int charisma = player.getCharisma();

        player.setHP(50 + (50 * lvl) + (str * 25));
        player.setMP(50 + (25 * lvl) + (charisma * 25));

        playersRepository.save(player);
    }
}

