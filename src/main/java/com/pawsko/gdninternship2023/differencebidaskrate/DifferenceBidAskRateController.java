package com.pawsko.gdninternship2023.differencebidaskrate;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/major_diff_bid_ask")
@Tag(name = "Major difference ask to bid from last N quotations")
public class DifferenceBidAskRateController {
    private final DifferenceBidAskRateService differenceBidAskRateService;

    @GetMapping("/{currency}/{lastQuotations}")
    @Operation(description = "Provides maximum difference between bid and ask for given currency in last N quotations")
    @ApiResponse(responseCode = "200", description = "Major difference bid ask", content = {@Content(mediaType = "application/json",
            schema = @Schema(implementation = DifferenceBidAskRate.class))})
    DifferenceBidAskRate getDifference(@PathVariable String currency, @PathVariable String lastQuotations){
        return differenceBidAskRateService.getMajorBidAskRateDifference(currency, lastQuotations);
    }
}
