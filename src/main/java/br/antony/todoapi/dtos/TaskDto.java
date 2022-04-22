package br.antony.todoapi.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class TaskDto {

    @NotBlank
    private String description;
}
