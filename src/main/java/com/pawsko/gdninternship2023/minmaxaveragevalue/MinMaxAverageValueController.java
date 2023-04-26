package com.pawsko.gdninternship2023.minmaxaveragevalue;

import com.pawsko.gdninternship2023.avarageexchangerate.AverageExchangeRate;
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
@RequestMapping("api/min_max_average_exchange_rate")
@Tag(name = "Min and max value for average exchange rate from last N quotations")
public class MinMaxAverageValueController {
    private final MinMaxAverageValueService minMaxAverageValueService;

    @GetMapping("/{currency}/{lastQuotations}")
    @Operation(description = "Provides minimum and maximum value of average exchange rate for given currency and last N quotations")
    @ApiResponse(responseCode = "200", description = "Min and max average exchange rate", content = {@Content(mediaType = "application/json",
            schema = @Schema(implementation = AverageExchangeRate.class))})
    MinMaxAverageValue getMinAndMaxAverageValue(@PathVariable String currency, @PathVariable String lastQuotations){
        return minMaxAverageValueService.getMinAndMaxAverageValueFromLastQuotations(currency, lastQuotations);
    }
}
