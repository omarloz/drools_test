package co.com.ikitech.droolsdriven.Config;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.runtime.KieContainer;
import org.kie.internal.io.ResourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BMPConfig {

    private static final String[] drlFiles = {"rules/discountRules.drl"};

    @Bean
    public KieContainer kieContainer() {
        KieServices kieServices = KieServices.Factory.get();
        //Load ValidateRules and Ecosystem Definitions
        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();

        for (String ruleFile : drlFiles) {
            kieFileSystem.write(ResourceFactory.newClassPathResource(ruleFile));
        }

        //Generate Modules and all internal Structures
        KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem);
        kieBuilder.buildAll();
        KieModule kieModule = kieBuilder.getKieModule();
        return kieServices.newKieContainer(kieModule.getReleaseId());
    }
}
