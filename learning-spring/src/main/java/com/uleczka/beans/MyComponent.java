package com.uleczka.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component // or stereotype annotation like @Service, @Repository...
public class MyComponent {

    @Autowired
    @Qualifier("nastyBean")
    private Eatable eatable;

    public Eatable getEatable() {
        return eatable;
    }

    public void sayHello() {
        System.out.println("Hello from MyComponent!");
    }
}
