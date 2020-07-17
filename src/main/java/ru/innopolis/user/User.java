package ru.innopolis.user;

/**
 * User pojo
 *
 * @author Artyr Gilyazov
 */

public class User {
    Integer userId;
    String nickName;
    String login;
    String password;

    public User(Integer userId, String nickName, String login, String password) {
        this.userId = userId;
        this.nickName = nickName;
        this.login = login;
        this.password = password;
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
}
