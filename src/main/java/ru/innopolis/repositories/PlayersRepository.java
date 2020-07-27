package ru.innopolis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.innopolis.models.Player;



/**
 * @author
 */

public interface PlayersRepository extends JpaRepository<Player, Long> {


}
