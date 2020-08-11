package ru.innopolis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.models.Player;
import ru.innopolis.repositories.PlayersRepository;

@Service
public class LevelUpByGoldServiceImpl implements LevelUpByGoldService {

    @Autowired
    private PlayersRepository playersRepository;
    @Autowired
    private LevelUpByExpService levelUpByExpService;
    @Autowired
    private LowHPService lowHPService;

    @Override
    public String levelUp(Player player) {

        lowHPService.lowHP(player);

        long timeCheckin = player.getRestTime();
        long timeNow = System.currentTimeMillis();

        if (timeNow > timeCheckin + 3600000) {



            int gold = player.getGold();
            int exp = player.getExperience();

            if (gold >= 50) {

                gold = gold - 50;
                exp = exp + 100;

                player.setGold(gold);
                player.setExperience(exp);

                levelUpByExpService.levelUpByExp(player);

                playersRepository.save(player);


                return "Ты получил немного опыта, а опыт не пропьешь!";


            } else {
                return "Я не буду учить тебя бесплатно, подкопи золотишка и приходи";
            }

        } else {
            return "Друг ты устал, проспись а потом приходи!";
        }
    }
}
