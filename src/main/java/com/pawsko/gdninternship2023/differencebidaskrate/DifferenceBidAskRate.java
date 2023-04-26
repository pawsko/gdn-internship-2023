package com.pawsko.gdninternship2023.differencebidaskrate;

import lombok.Data;

@Data
public class DifferenceBidAskRate {
    private String currency;
    private String currencyCode;
    private double majorBidAsk;
}
