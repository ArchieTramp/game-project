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
public class CreatPlayerServiceImpl implements CreatPlayerService{
    @Autowired
    private PlayersRepository playersRepository;

    @Override
    public void signUp(PlayerForm playerForm) {
        Player player = Player.builder()
                .nickName(playerForm.getNickName())
                .HP(100)
                .MP(100)
                .level(1)
                .strength(100)
                .charisma(100)
                .intelligence(100)
                .luck(100)
                .gold(100)
                .build();
        playersRepository.save(player);

    }
}
