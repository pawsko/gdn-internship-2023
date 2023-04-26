package com.pawsko.gdninternship2023.avarageexchangerate;

import org.springframework.stereotype.Service;

@Service
public class AverageExchangeRateDtoMapper {
    AverageExchangeRate map(ExchangeRateNbp averageExchangeRateNbp) {
        AverageExchangeRate averageExchangeRate = new AverageExchangeRate();
        averageExchangeRate.setCurrency(averageExchangeRateNbp.getCurrency());
        averageExchangeRate.setCurrencyCode(averageExchangeRateNbp.getCode());
        averageExchangeRate.setRate(averageExchangeRateNbp.getRates().get(0).getMid());

        return averageExchangeRate;
    }
}
