package com.edu.api.entity.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class YandexRoutes {
    private String status;
    private Distance distance;
    private Duration duration;

}
