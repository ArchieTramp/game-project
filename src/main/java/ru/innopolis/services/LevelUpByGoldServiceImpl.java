package ru.innopolis.services;

import org.springframework.beans.factory.annotation.Autowired;
import ru.innopolis.models.Player;
import ru.innopolis.repositories.PlayersRepository;

public class LevelUpByGoldServiceImpl implements LevelUpByGoldService {

    @Autowired
    private PlayersRepository playersRepository;
    private LevelUpByExpServiceImpl levelUpByExpService;

    @Override
    public void levelUp(Player player) {

        playersRepository.findByNickName(player.getNickName());

        int gold = player.getGold();
        int exp = player.getExperience();

        if (gold >= 50) {

            gold = gold - 50;
            exp = exp + 100;

            player.setGold(gold);
            player.setLevel(exp);

            playersRepository.save(player);

            levelUpByExpService.levelUpByExp(player);


        } else {
            System.out.println("Мало золота");
        }

    }
}
