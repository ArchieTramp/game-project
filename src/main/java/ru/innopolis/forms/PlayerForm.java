package ru.innopolis.forms;

import lombok.Data;

@Data
public class PlayerForm {
    private Long id;
    private String nickName;
    private Integer HP;
    private Integer MP;
    private Integer level;
    private Integer strength;
    private Integer charisma;
    private Integer intelligence;
    private Integer luck;
    private Integer gold;
}
