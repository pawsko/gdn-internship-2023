package com.pawsko.gdninternship2023.differencebidaskrate;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class DifferenceBidAskRateService {

    private final DifferenceBidAskRateMapper differenceBidAskRateMapper;

    DifferenceBidAskRate getMajorBidAskRateDifference(String currency, String lastQuotations) {
        String url = "http://api.nbp.pl/api/exchangerates/rates/c/{currency}/last/{lastQuotations}/?format=json";
        Map<String, String> uriParams = Map.of("currency", currency, "lastQuotations", lastQuotations);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<BidAskNbp> bidAskNbpResponseEntity = restTemplate.exchange(url, HttpMethod.GET, null, BidAskNbp.class, uriParams);

        return differenceBidAskRateMapper.map(bidAskNbpResponseEntity.getBody());
    }
}
