package co.com.ikitech.api;

import co.com.ikitech.model.productprice.ProductPrice;
import co.com.ikitech.usecase.pricecalculator.PriceCalculatorUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {

    private final PriceCalculatorUseCase priceCalculatorUseCase;

    @PostMapping("/test")
    public Mono<String> test(@RequestBody ProductPrice productPrice) {
        priceCalculatorUseCase.validateRules(productPrice);
        return Mono.just("Llego");
    }
}
