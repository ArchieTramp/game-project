package ru.innopolis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.innopolis.models.Player;
import ru.innopolis.models.User;

import java.util.List;
import java.util.Optional;

/**
 * @author
 */

public interface PlayersRepository extends JpaRepository<Player, Long> {
   List<Player> findById(long id);
//    Optional<Player> findOneByLogin(String login);
}
