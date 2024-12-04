package co.com.ikitech.usecase.pricecalculator;

import co.com.ikitech.model.productprice.ProductPrice;
import co.com.ikitech.model.rules.ValidateRules;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PriceCalculatorUseCase {

    private final ValidateRules validateRules;

    public void validateRules(ProductPrice productPrice) {
        validateRules.executeRules(productPrice);
    }
}
