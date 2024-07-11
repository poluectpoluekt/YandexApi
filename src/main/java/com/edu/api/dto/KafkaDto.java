package com.edu.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class KafkaDto {

    private String message;
    private int PriceOfCryptocurrency; //для простоты не используется BigDecimal
}
