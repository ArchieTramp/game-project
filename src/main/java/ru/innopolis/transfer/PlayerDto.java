package ru.innopolis.transfer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ru.innopolis.models.Player;
import ru.innopolis.models.User;

/**
 * PlayerDto
 *
 * @author "Andrei Prokofiev"
 */

@Data
@AllArgsConstructor
@Builder
public class PlayerDto {
    private String nickName;

    public static PlayerDto from(Player player) {
        return PlayerDto.builder()
                .nickName(player.getNickName())
                .build();
    }


}
