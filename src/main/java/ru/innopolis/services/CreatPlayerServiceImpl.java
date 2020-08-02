package ru.innopolis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.forms.PlayerForm;
import ru.innopolis.models.Player;
import ru.innopolis.repositories.PlayersRepository;
import ru.innopolis.repositories.UsersRepository;

/**
 * CreatPlayerServiceImpl
 *
 * @author "Andrei Prokofiev"
 */

@Service
public class CreatPlayerServiceImpl implements CreatPlayerService {
    @Autowired
    private PlayersRepository playersRepository;

    @Override
    public void signUp(PlayerForm playerForm) {
        Player player = Player.builder()
                .nickName(playerForm.getNickName())
                .HP(125)
                .MP(100)
                .level(1)
                .experience(0)
                .strength(1)
                .charisma(1)
                .intelligence(1)
                .luck(1)
                .gold(10)
                .build();
        playersRepository.save(player);

    }
}
