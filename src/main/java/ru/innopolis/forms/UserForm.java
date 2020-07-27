package ru.innopolis.forms;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 *
 */

@Data
public class UserForm {

    @Pattern(message = "Bad formed person firstName: ${validatedValue}",
            regexp = "^[A-Z][a-z]*(\\s(([a-z]{1,3})|(([a-z]+\\')?[A-Z][a-z]*)))*$")
    @NotBlank(message = "FirstName should not be empty")
    private String firstName;

    @NotBlank(message = "LastName should not be empty")
    private String lastName;

    @NotBlank(message = "Login should not be empty")
    private String login;

    @NotBlank(message = "Password should not be empty")
    private String password;

}
