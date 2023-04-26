package com.pawsko.gdninternship2023.avarageexchangerate;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class AverageExchangeRateService {

    private final AverageExchangeRateDtoMapper averageExchangeRateDtoMapper;

    AverageExchangeRate getRateByCurrencyNameAndDate(String currency, String effectiveDate) {
        String url = "http://api.nbp.pl/api/exchangerates/rates/a/{currency}/{effectiveDate}/?format=json";
        Map<String, String> uriParams = Map.of("currency", currency, "effectiveDate", effectiveDate);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ExchangeRateNbp> rateNbpResponseEntity = restTemplate.exchange(url, HttpMethod.GET, null, ExchangeRateNbp.class, uriParams);

        return averageExchangeRateDtoMapper.map(rateNbpResponseEntity.getBody());
    }
}
