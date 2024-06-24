package com.edu.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class DataRoutesDto {

    private String source;
    private String target;
    //private String methodTransportation;
    private String timeTransportation;
    private String traffic;
}
