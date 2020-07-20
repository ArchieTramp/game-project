package ru.innopolis.player;

import ru.innopolis.games.Game;
import ru.innopolis.games.Play;

/**
 * Player pojo
 *
 * @author "Andrei Prokofiev"
 * @author Artyr Gilyazov
 *
 * добавил навыки
 */

public class Player implements Play {
    Integer userId;
    String nickName;
    Integer HP; //очки здоровья//
    Integer MP; //очки действия//
    Integer level; //уровень//
    Integer strength; //сила//
    Integer charisma; //общение//
    Integer intelligence; //знание//
    Integer luck; //удача//




    public Player(Integer userId, String nickName, Integer HP, Integer MP, Integer level, Integer strength, Integer charisma,
                  Integer intelligence, Integer luck) {
        this.userId = userId;
        this.nickName = nickName;
        this.HP = HP;
        this.MP = MP;
        this.level = level;
        this.strength = strength;
        this.charisma = charisma;
        this.intelligence = intelligence;
        this.luck = luck;

    }


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getHP() {
        return HP;
    }

    public void setHP(Integer HP) {
        this.HP = HP;
    }

    public Integer getMP() {
        return MP;
    }

    public void setMP(Integer MP) {
        this.MP = MP;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getStrength() { return strength; }

    public void setStrength(Integer strength) { this.strength = strength; }

    public Integer getCharisma() { return charisma; }

    public void setCharisma(Integer charisma) { this.charisma = charisma; }

    public Integer getIntelligence() { return intelligence; }

    public void setIntelligence(Integer intelligence) { this.intelligence = intelligence; }

    public Integer getLuck() { return luck; }

    public void setLuck(Integer luck) { this.luck = luck; }

    @Override
    public void play(Game game) {
        game.executeGame();
    }

//    @Override
//    public int playAgain(Game game) {
//        return 0;
//    }

}
