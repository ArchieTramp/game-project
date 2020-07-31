package ru.innopolis.forms;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class PlayerForm {

    @NotBlank(message = "Поле не может быть пустым")
    private String nickName;
//    private Integer HP;
//    private Integer MP;
//    private Integer level;
//    private Integer strength;
//    private Integer charisma;
//    private Integer intelligence;
//    private Integer luck;
//    private Integer gold;

}
