package ru.innopolis.transfer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ru.innopolis.models.Player;
import ru.innopolis.models.User;

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
    private List<Player> players;

    public static UserDto from(User user) {
        return UserDto.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
//                .players(user.getPlayers())
                .build();


    }
}
