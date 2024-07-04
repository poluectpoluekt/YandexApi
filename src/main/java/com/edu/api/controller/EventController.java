package com.edu.api.controller;

import com.edu.api.dto.DataRoutesDto;
import com.edu.api.dto.ResultRoutesDto;
import com.edu.api.exception.YandexResponseDataException;
import com.edu.api.service.EventService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RequestMapping("/api/event")
@RestController
public class EventController {

    private final EventService eventService;
    //private final Logger logger = LoggerFactory.getLogger(EventController.class);

    @PostMapping("/way")
    public ResultRoutesDto getWay(@RequestBody DataRoutesDto dataRoutesDto) throws YandexResponseDataException {
        return eventService.yandexApi(dataRoutesDto);

    }

    @PostMapping("/req")
    public void requestNotRole(){

    }

    @PreAuthorize("hasAuthority('USER')")
    @PostMapping("/role")
    public void requestForUserRole(){

    }
}
