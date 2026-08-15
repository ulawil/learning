package com.uleczka.beans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MyInitializingBean implements InitializingBean, BeanNameAware, BeanFactoryAware, ApplicationContextAware, DisposableBean {

    public MyInitializingBean() {
        System.out.println("MyInitializingBean - bean instantiated");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("MyInitializingBean - BeanNameAware::setBeanName");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("MyInitializingBean - BeanFactoryAware::setBeanFactory");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("MyInitializingBean - ApplicationContextAware::setApplicationContext");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("MyInitializingBean - InitializingBean::afterPropertiesSet");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("MyInitializingBean - @PostConstruct");
    }

    public void initMethod() {
        System.out.println("MyInitializingBean - @Bean's initMethod");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("MyInitializingBean - DisposableBean::destroy");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("MyInitializingBean - @PreDestroy");
    }

    public void destroyMethod() {
        System.out.println("MyInitializingBean - @Bean's destroyMethod");
    }
}
