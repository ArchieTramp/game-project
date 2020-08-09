package ru.innopolis.services;

import org.springframework.beans.factory.annotation.Autowired;
import ru.innopolis.models.Player;
import ru.innopolis.repositories.PlayersRepository;

public class BarracksServiceImpl implements BarracksService {


    @Autowired
    private PlayersRepository playersRepository;
    @Autowired
    private LowHPService lowHPService;

    @Override
    public void mercenaryInBarracks(Player player) {

        lowHPService.lowHP(player);

        int bandit = player.getBandit();
        int gold = player.getGold();

        if (gold >= (500 + (bandit * 50))) {
            gold = gold - (500 + (bandit * 50));
            bandit = bandit + 1;

            player.setGold(gold);
            player.setBandit(bandit);

            playersRepository.save(player);
        } else {
            System.out.println("Подкопи бабла");
        }

    }
}
