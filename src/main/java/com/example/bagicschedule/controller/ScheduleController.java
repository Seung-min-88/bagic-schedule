package com.example.bagicschedule.controller;

import com.example.bagicschedule.dto.ScheduleRequestDto;
import com.example.bagicschedule.dto.ScheduleResponseDto;
import com.example.bagicschedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping("/schedules")
    public ResponseEntity<ScheduleResponseDto> save(@RequestBody ScheduleRequestDto dto){
        return ResponseEntity.ok(scheduleService.save(dto));
    }

    @GetMapping("/schedules")
    public ResponseEntity<List<ScheduleResponseDto>> findAll(@RequestBody ScheduleRequestDto dto){
        return ResponseEntity.ok(scheduleService.findAll());
    }

    @GetMapping("/schedules/{id}")
    public ScheduleResponseDto findOne(@PathVariable Long id){
        return scheduleService.findById(id);
    }

    @PutMapping("/schedules/{id}")
    public ScheduleResponseDto update(@PathVariable Long id, @RequestBody ScheduleRequestDto dto){
        return scheduleService.update(id, dto);
    }

    @DeleteMapping("/schedules/{id}")
    public void deleteSchedule(@PathVariable Long id){
        scheduleService.deleteById(id);
    }
}
