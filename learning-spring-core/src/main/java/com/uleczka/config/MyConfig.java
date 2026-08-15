package com.uleczka.config;

import com.uleczka.beans.Eatable;
import com.uleczka.beans.MyBean;
import com.uleczka.beans.MyInitializingBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan("com.uleczka")
public class MyConfig {

    @Bean
    public MyBean myBean() {
        return new MyBean();
    }

    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    public MyInitializingBean myInitializingBean() {
        return new MyInitializingBean();
    }

    @Bean
    @Qualifier("nastyBean")
    public Eatable coffeeBean() {
        return () -> System.out.println("Eaten coffee bean, but it's disgusting");
    }

    @Bean
    @Primary
    public Eatable jellyBean() {
        return () -> System.out.println("Eaten jelly bean, it's sweet");
    }
}
