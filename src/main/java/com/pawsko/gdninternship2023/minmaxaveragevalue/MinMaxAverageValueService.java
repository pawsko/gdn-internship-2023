package com.pawsko.gdninternship2023.minmaxaveragevalue;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class MinMaxAverageValueService {

    private final MinMaxAverageValueMapper minMaxAverageValueMapper;

    MinMaxAverageValue getMinAndMaxAverageValueFromLastQuotations(String currency, String lastQuotations) {
        String url = "http://api.nbp.pl/api/exchangerates/rates/a/{currency}/last/{lastQuotations}/?format=json";
        Map<String, String> uriParams = Map.of("currency", currency, "lastQuotations", lastQuotations);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ExchangeRateNbp> exchangeRateNbpResponseEntity = restTemplate.exchange(url, HttpMethod.GET, null, ExchangeRateNbp.class, uriParams);

        return minMaxAverageValueMapper.map(exchangeRateNbpResponseEntity.getBody());
    }
}
