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

//    @Override
//    public int compareTo(YandexRoutes o) {
//        if (this.duration.getValue() > o.getDuration().getValue()) {
//            return 1;
//        } else if (this.duration.getValue() < o.getDuration().getValue()) {
//            return -1;
//        } else return 0;
//    }
}
