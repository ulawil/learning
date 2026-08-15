package com.uleczka.beans;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public @Nullable Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof MyInitializingBean) {
            System.out.println("MyBeanPostProcessor - BeanPostProcessor::postProcessBeforeInitialization");
        }
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public @Nullable Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof MyInitializingBean) {
            System.out.println("MyBeanPostProcessor - BeanPostProcessor::postProcessAfterInitialization");
        }
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
