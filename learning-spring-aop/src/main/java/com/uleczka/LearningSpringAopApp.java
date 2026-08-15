package com.uleczka;

import com.uleczka.config.MyConfig;
import com.uleczka.service.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LearningSpringAopApp {
    static void main() {

        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        OrderService orderService = context.getBean(OrderService.class);

        orderService.createOrder("Alice", 100);
        orderService.cancelOrder("123");

    }
}
