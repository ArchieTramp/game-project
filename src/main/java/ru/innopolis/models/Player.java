package ru.innopolis.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.innopolis.services.games.Game;
import ru.innopolis.services.games.Play;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

/**
 * Player pojo
 *
 * @author "Andrei Prokofiev"
 * @author Artyr Gilyazov
 * <p>
 * добавил навыки
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "players", uniqueConstraints = @UniqueConstraint(columnNames = {"nickName"}))
//
public class Player implements Play {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nickName;
    private Integer HP; //очки здоровья//
    private Integer MP; //очки действия//
    private Integer experience;//очки опыта//
    private Integer level; //уровень//
    private Integer strength; //сила//
    private Integer charisma; //общение//
    private Integer intelligence; //знание//
    private Integer luck; //удача//
    private Integer gold; //бабки//
    private Integer bandit; //помощник//

    public Player(String nickName, Integer HP, Integer MP, Integer experience, Integer level, Integer strength, Integer charisma,
                  Integer intelligence, Integer luck, Integer gold, Integer bandit) {
        this.nickName = nickName;
        this.HP = HP;
        this.MP = MP;
        this.experience =  experience;
        this.level = level;
        this.strength = strength;
        this.charisma = charisma;
        this.intelligence = intelligence;
        this.luck = luck;
        this.gold = gold;
        this.bandit = bandit;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @Override
    public void play(Game game) {
         game.executeGame();
    }
}
