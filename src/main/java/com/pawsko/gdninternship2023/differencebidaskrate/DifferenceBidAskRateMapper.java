package com.pawsko.gdninternship2023.differencebidaskrate;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class DifferenceBidAskRateMapper {
    DifferenceBidAskRate map(BidAskNbp bidAskNbp) {
        DifferenceBidAskRate differenceBidAskRate = new DifferenceBidAskRate();

        List<Double> diffList = bidAskNbp.getRates().stream().map(rate -> rate.getAsk() - rate.getBid()).toList();

        differenceBidAskRate.setCurrency(bidAskNbp.getCurrency());
        differenceBidAskRate.setCurrencyCode(bidAskNbp.getCode());
        differenceBidAskRate.setMajorBidAsk(Collections.max(diffList));
        return differenceBidAskRate;
    }
}
