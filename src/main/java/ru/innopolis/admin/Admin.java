package ru.innopolis.admin;

/**
 * Admin pojo
 *
 * @author Artyr Gilyazov
 */


public class Admin {
    Integer userId;
    String position;
    String login;
    String password;
    String nickName;


    public Admin(Integer userId, String position, String login, String password, String nickName) {
        this.userId = userId;
        this.position = position;
        this.login = login;
        this.password = password;
        this.nickName = nickName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
