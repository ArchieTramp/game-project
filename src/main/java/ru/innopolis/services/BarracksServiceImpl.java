package ru.innopolis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.innopolis.models.Player;
import ru.innopolis.repositories.PlayersRepository;

@Service
public class BarracksServiceImpl implements BarracksService {


    @Autowired
    private PlayersRepository playersRepository;
    @Autowired
    private LowHPService lowHPService;

    @Override
    public String mercenaryInBarracks(Player player) {

        long timeCheckin = player.getRestTime();
        long timeNow = System.currentTimeMillis();

        if (timeNow > timeCheckin + 3600000) {

            lowHPService.lowHP(player);

            int bandit = player.getBandit();
            int gold = player.getGold();

            if (gold >= (500 + (bandit * 50))) {
                gold = gold - (500 + (bandit * 50));
                bandit = bandit + 1;

                player.setGold(gold);
                player.setBandit(bandit);

                playersRepository.save(player);

                return "Поздравляем! К вам присоединился бандит!";
            } else {
                return "Эй, ковбой, без золота тебе здесь делать нечего!";
            }
        } else {
            return "Оу ковбой, ты устал ведь, посиди отдохни у костра, а потом приходи";
        }

    }

}
