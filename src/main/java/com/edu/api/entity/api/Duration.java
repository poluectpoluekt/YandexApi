package com.edu.api.entity.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Duration implements Comparable<Duration> {

    private int value;

    @Override
    public int compareTo(Duration o) {
        if (this.value > o.getValue()) {
            return 1;
        } else if (this.value < o.getValue()) {
            return -1;
        } else return 0;
    }
}
