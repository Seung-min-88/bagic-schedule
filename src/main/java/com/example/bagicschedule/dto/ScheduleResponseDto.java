package com.example.bagicschedule.dto;

import lombok.Getter;

@Getter
public class ScheduleResponseDto {
    private Long id;
    private String name;
    private String todo;

    public ScheduleResponseDto(Long id, String name, String todo){
        this.id = id;
        this.name = name;
        this.todo = todo;
    }
}
