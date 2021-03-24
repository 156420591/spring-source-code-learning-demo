package net.teaho.demo.spring.cloud.context.named.config;

import net.teaho.demo.spring.cloud.context.named.app.Rule;
import net.teaho.demo.spring.cloud.context.named.app.RuleImplA;
import net.teaho.demo.spring.cloud.context.named.app.SimpleClientName;
import net.teaho.demo.spring.cloud.context.named.app.SimplePropertiesFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author teaho2015@gmail.com
 * @date 2020-06
 * @since 1.0.0
 */
@Configuration
public class DefaultSimpleConfiguration {


    @SimpleClientName
    private String name = "client";


    @Autowired
    private SimplePropertiesFactory propertiesFactory;

    @Bean
    @ConditionalOnMissingBean
    public Rule rule() {
        if (this.propertiesFactory.isSet(Rule.class, name)) {
            return this.propertiesFactory.get(Rule.class, name);
        }
        return new Rule.Default();
    }
}
