package com.edu.api.controller;

import com.edu.api.dto.DataRoutesDto;
import com.edu.api.dto.ResultRoutesDto;
import com.edu.api.exception.YandexResponseDataException;
import com.edu.api.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RequestMapping("/api/event")
@RestController
public class EventController {

    private final EventService eventService;

    @PostMapping("/way")
    public ResultRoutesDto getWay(@RequestBody DataRoutesDto dataRoutesDto) throws YandexResponseDataException {
        return eventService.yandexApi(dataRoutesDto);

    }
}
