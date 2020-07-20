package ru.innopolis.forms;


import lombok.Data;

import java.util.Objects;

/**
 *
 */

@Data
public class UserForm {
    private String firstName;
    private String lastName;
    private String login;
    private String password;

}
