package com.pawsko.gdninternship2023.avarageexchangerate;

import lombok.Data;

import java.util.List;

@Data
public class ExchangeRateNbp {
    private String table;
    private String currency;
    private String code;
    private List<Rate> rates;
}
