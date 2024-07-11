package com.edu.api.service;

import com.edu.api.dto.KafkaDto;
import com.edu.api.entity.kafka.KafkaMessage;
import lombok.AllArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DataSenderKafka {

    private final KafkaTemplate<String, Object>  kafkaTemplate;
    private final NewTopic topic;

    public void send(KafkaDto kafkaDto){

        KafkaMessage kafkaMessage = new KafkaMessage(kafkaDto.getMessage(), kafkaDto.getPriceOfCryptocurrency());

        kafkaTemplate.send(topic.name(), kafkaMessage)
                .whenComplete((result, ex)-> {
                    if (ex == null){
                        //код
                    } else{
                        //можно записать лог
                        //также можно отправить сообщение снова или другим способом
                    }
                } );
    }
}
