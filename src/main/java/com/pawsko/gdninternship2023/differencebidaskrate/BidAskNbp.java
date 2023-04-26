package com.pawsko.gdninternship2023.differencebidaskrate;

import lombok.Data;

import java.util.List;

@Data
public class BidAskNbp {
    private String table;
    private String currency;
    private String code;
    private List<Rate> rates;

}
