package ru.innopolis.models;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import ru.innopolis.forms.UserForm;

import javax.persistence.*;
import javax.validation.Validation;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * User pojo
 *
 * @author Artyr Gilyazov
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "fix_user", uniqueConstraints = @UniqueConstraint(columnNames = {"login"}))
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String login;

    private String hashPassword;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    @Enumerated(value = EnumType.STRING)
    private State state;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    List<Player> players;


    public static User from(UserForm form) {
        return User.builder()
                .firstName(form.getFirstName())
                .lastName(form.getLastName())
                .build();
    }

}
