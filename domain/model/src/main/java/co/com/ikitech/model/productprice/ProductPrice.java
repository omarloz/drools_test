package co.com.ikitech.model.productprice;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ProductPrice {
    private Integer basePrice;
}
