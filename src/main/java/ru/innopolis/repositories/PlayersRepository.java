package ru.innopolis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.innopolis.models.Player;



/**
 *
 *
 *
 */

public interface PlayersRepository extends JpaRepository<Player, Long> {


}
