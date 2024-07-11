package com.edu.api.entity.kafka;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class KafkaMessage {

    private String message;
    private int PriceOfCryptocurrency;

}
