package com.edu.api.service;

import com.edu.api.dto.DataRoutesDto;
import com.edu.api.dto.ResultRoutesDto;
import com.edu.api.entity.api.*;
import com.edu.api.exception.YandexResponseDataException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@AllArgsConstructor
@Service
public class EventService {

    private final RestTemplate restTemplate;

    @Value("${my.yandex.key")
    private final String yandexApiKey;

    public ResultRoutesDto yandexApi(DataRoutesDto dataRoutes) throws YandexResponseDataException {

        String url = "https://api.routing.yandex.net/v2/distancematrix?origins=" + dataRoutes.getSource()
                + "&destinations=" + dataRoutes.getTarget() +"&departure_time=" + dataRoutes.getTimeTransportation()
                + "&traffic=" + dataRoutes.getTraffic() + "&apikey=" + yandexApiKey;

        ResponseEntity<ResponseYandexApi> response = restTemplate
                .exchange(url, HttpMethod.GET, null, ResponseYandexApi.class);

        if (response.getBody() == null) {
            throw new YandexResponseDataException();
        } else if (response.getBody().getListRoutes().size() == 1) {
            YandexRoutes bestRoutes = response.getBody().getListRoutes().get(0);
            return new ResultRoutesDto(bestRoutes.getDistance().getValue(), bestRoutes.getDuration().getValue());
        } else {
            Optional<YandexRoutes> resultByYandex = response.getBody().getListRoutes()
                    .stream().min(Comparator.comparing(YandexRoutes::getDuration));
            return new ResultRoutesDto(resultByYandex.get().getDistance().getValue(), resultByYandex.get().getDuration().getValue());
        }
    }
}
