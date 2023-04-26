package com.pawsko.gdninternship2023.avarageexchangerate;

import lombok.Data;

@Data
public class AverageExchangeRate {
    private String currency;
    private String currencyCode;
    private double rate;
}
