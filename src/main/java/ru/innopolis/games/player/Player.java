package ru.innopolis.games.player;

import ru.innopolis.games.Game;
import ru.innopolis.games.Play;

/**
 * User
 *
 * @author "Andrei Prokofiev"
 */
public class Player implements Play {
    Integer userId;
    String nickName;
    Integer HP;
    Integer MP;
    Integer level;

    public Player(Integer userId, String nickName, Integer HP, Integer MP, Integer level) {
        this.userId = userId;
        this.nickName = nickName;
        this.HP = HP;
        this.MP = MP;
        this.level = level;
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

    @Override
    public void play(Game game) {
        game.executeGame();
    }

//    @Override
//    public int playAgain(Game game) {
//        return 0;
//    }

}
