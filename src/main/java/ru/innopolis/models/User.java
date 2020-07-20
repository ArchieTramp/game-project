package ru.innopolis.models;

import lombok.*;
import ru.innopolis.repositories.UsersRepository;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * User pojo
 *
 * @author Artyr Gilyazov
 */


//@AllArgsConstructor(access = AccessLevel.PRIVATE)


@Data
@AllArgsConstructor
public class User {
    public Integer userId;
    private String nickName;
    private String login;
    private String hashPassword;

    //    @Enumerated(value = EnumType.STRING)
    private Role role;
    //    @Enumerated(value = EnumType.STRING)
    private State state;


//    public User(Integer userId, String nickName, String login, String hashPassword) {
//        this.userId = userId;
//        this.nickName = nickName;
//        this.login = login;
//        this.hashPassword = hashPassword;
//    }






//    public Integer getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Integer userId) {
//        this.userId = userId;
//    }
//
//    public String getNickName() {
//        return nickName;
//    }
//
//    public void setNickName(String nickName) {
//        this.nickName = nickName;
//    }
//
//    public String getLogin() {
//        return login;
//    }
//
//    public void setLogin(String login) {
//        this.login = login;
//    }
//
//
//    public void setHashPassword(String hashPassword) {
//        this.hashPassword = hashPassword;
//    }
}
