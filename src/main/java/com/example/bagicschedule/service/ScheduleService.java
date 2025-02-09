package com.example.bagicschedule.service;

import com.example.bagicschedule.dto.ScheduleRequestDto;
import com.example.bagicschedule.dto.ScheduleResponseDto;
import com.example.bagicschedule.entity.Schedule;
import com.example.bagicschedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleResponseDto save(ScheduleRequestDto dto){
        Schedule schedule = new Schedule(dto.getName(), dto.getTodo());
        Schedule saveSchedule = scheduleRepository.save(schedule);

        return new ScheduleResponseDto(saveSchedule.getId(), saveSchedule.getName(), saveSchedule.getTodo());
    };

    public List<ScheduleResponseDto> findAll(){
        List<Schedule> schedules = scheduleRepository.findAll();

        List<ScheduleResponseDto> dtos = new ArrayList<>();
        for (Schedule schedule : schedules){
            ScheduleResponseDto dto = new ScheduleResponseDto(schedule.getId(), schedule.getName(), schedule.getTodo());
            dtos.add(dto);
        }
        return dtos;
    }

    public ScheduleResponseDto findById(Long id){
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("없음 ㅅㄱ")
        );
        return  new ScheduleResponseDto(schedule.getId(), schedule.getName(), schedule.getTodo());
    }
    @Transactional
    public ScheduleResponseDto update(Long id, ScheduleRequestDto dto){
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("없음 ㅅㄱ")
        );
        schedule.update(dto.getName(), dto.getTodo());
        return new ScheduleResponseDto(schedule.getId(), schedule.getName(), schedule.getTodo());
    }

    public void deleteById(Long id){
        if(!scheduleRepository.existsById(id)){
            throw  new IllegalArgumentException("스케줄 없음");
        }
        scheduleRepository.deleteById(id);
    }
}
