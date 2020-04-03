package eCorp;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "eCorp.environment.desktop")
@PropertySource(name="applicationProperties", value="classpath:config/application.properties")
public class eCorpSeleniunCucuberApp {
    
    
}
