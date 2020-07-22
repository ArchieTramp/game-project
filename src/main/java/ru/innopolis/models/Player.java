package ru.innopolis.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.innopolis.games.Game;
import ru.innopolis.games.Play;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Player pojo
 *
 * @author "Andrei Prokofiev"
 * @author Artyr Gilyazov
 * <p>
 * добавил навыки
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
//@Entity
@Table(name = "players")
public class Player implements Play {
    private Long id;
    private String nickName;
    private Integer HP; //очки здоровья//
    private Integer MP; //очки действия//
    private Integer level; //уровень//
    private Integer strength; //сила//
    private Integer charisma; //общение//
    private Integer intelligence; //знание//
    private Integer luck; //удача//

    @Override
    public void play(Game game) {
        game.executeGame();
    }

//    @Override
//    public int playAgain(Game game) {
//        return 0;
//    }

}