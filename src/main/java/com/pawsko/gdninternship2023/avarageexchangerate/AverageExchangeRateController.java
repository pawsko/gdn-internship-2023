package com.pawsko.gdninternship2023.avarageexchangerate;

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
@RequestMapping("api/average_exchange_rate")
@Tag(name = "Average Exchange Rate")
public class AverageExchangeRateController {
    private final AverageExchangeRateService averageExchangeRateService;

    @GetMapping("/{currency}/{effectiveDate}")
    @Operation(description = "Provides average exchange rate for given currency and date")
    @ApiResponse(responseCode = "200", description = "Average exchange rate", content = {@Content(mediaType = "application/json",
            schema = @Schema(implementation = AverageExchangeRate.class))})
    AverageExchangeRate getRate(@PathVariable String currency, @PathVariable String effectiveDate) {
        return averageExchangeRateService.getRateByCurrencyNameAndDate(currency, effectiveDate);
    }

}
