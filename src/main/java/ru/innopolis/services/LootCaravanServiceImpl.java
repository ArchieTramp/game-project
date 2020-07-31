package ru.innopolis.services;

import org.springframework.beans.factory.annotation.Autowired;
import ru.innopolis.forms.PlayerForm;
import ru.innopolis.models.Player;
import ru.innopolis.repositories.PlayersRepository;

import java.util.Random;

public class LootCaravanServiceImpl implements LootCaravanService {

//    @Autowired
    private PlayersRepository playersRepository;

//    @Override
    public void lootCaravan(PlayerForm playerform) {
        Random randomLoot = new Random();


//        Player player = Player.builder()
//                .MP(playerform.getMP())
//                .level(playerform.getLevel())
//                .gold(playerform.getGold())
//                .build();
//        playersRepository.save(player);


        /*запрос из бд значений*/
        int mP = 55;
        int lvl = 2000;
        int gold = 95;


        if (mP >= 50) {
            int resultLoot = randomLoot.nextInt(20);
            mP = mP - 50;
            lvl = lvl + 10;
            gold = gold + resultLoot;

            /*отправка значений в бд*/

        } else {
            /* если энергии не хватает */
            System.out.println("Нет энергии, отдохни в Салуне или приходи позже");
        }

    }
}
