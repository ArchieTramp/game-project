package ru.innopolis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.forms.PlayerForm;
import ru.innopolis.forms.UserForm;
import ru.innopolis.models.Player;
import ru.innopolis.models.State;
import ru.innopolis.models.User;
import ru.innopolis.repositories.UsersRepository;

import java.util.Optional;

/**
 * BannedPlayerServiceImpl
 *
 * @author "Andrei Prokofiev"
 */

@Service
public class BannedPlayerServiceImpl implements BannedPlayerService {
    @Autowired
    UsersRepository usersRepository;

    @Override
    public void bannedPlayer(Long id) {
        Optional<User> userFromDB = usersRepository.findById(id);
        User user1 = userFromDB.get();
        user1.setState(State.BANNED);
        usersRepository.save(user1);
    }
}
