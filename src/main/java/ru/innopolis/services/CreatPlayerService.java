package ru.innopolis.services;

import ru.innopolis.forms.PlayerForm;
import ru.innopolis.forms.UserForm;
import ru.innopolis.models.Player;

/**
 * CreatPlayerService
 *
 * @author "Andrei Prokofiev"
 */

public interface CreatPlayerService {
    void signUp(PlayerForm playerForm);
}
