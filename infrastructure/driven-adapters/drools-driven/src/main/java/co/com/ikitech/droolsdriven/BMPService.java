package co.com.ikitech.droolsdriven;

import co.com.ikitech.model.productprice.ProductPrice;
import co.com.ikitech.model.rules.ValidateRules;
import lombok.RequiredArgsConstructor;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BMPService implements ValidateRules {

    private final KieContainer kieContainer;

    @Override
    public void executeRules(ProductPrice productPrice) {
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(productPrice);
        kieSession.fireAllRules();
        kieSession.dispose();
    }

}
