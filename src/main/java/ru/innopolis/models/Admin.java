package ru.innopolis.models;

/**
 * Admin pojo
 *
 * @author Artyr Gilyazov
 */

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@Entity
//@Table(name = "admins")
public class Admin {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String position;
    private String login;
    private String password;
    private String nickName;

}
