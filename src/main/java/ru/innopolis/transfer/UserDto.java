package ru.innopolis.transfer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ru.innopolis.models.Player;
import ru.innopolis.models.Role;
import ru.innopolis.models.State;
import ru.innopolis.models.User;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;

/**
 *
 * @author
 */

@Data
@AllArgsConstructor
@Builder
public class UserDto {
    private String firstName;
    private String lastName;
    private Long id;
    private String login;
    private Role role;
    private State state;
    private List<Player> players;

    public static UserDto from(User user) {
        return UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .role(user.getRole())
                .state(user.getState())
                .build();
    }
}
