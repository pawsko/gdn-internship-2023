package com.pawsko.gdninternship2023.minmaxaveragevalue;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class MinMaxAverageValueMapper {
    MinMaxAverageValue map(ExchangeRateNbp exchangeRateNbp) {
        MinMaxAverageValue minMaxAverageValue = new MinMaxAverageValue();

        List<Double> ratesList = exchangeRateNbp.getRates().stream().map(rate -> rate.getMid()).toList();

        minMaxAverageValue.setCurrency(exchangeRateNbp.getCurrency());
        minMaxAverageValue.setCurrencyCode(exchangeRateNbp.getCode());
        minMaxAverageValue.setMaxAverageValue(Collections.max(ratesList));
        minMaxAverageValue.setMinAverageValue(Collections.min(ratesList));
        return minMaxAverageValue;
    }
}
