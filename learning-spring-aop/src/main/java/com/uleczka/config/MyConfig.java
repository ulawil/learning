package com.uleczka.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.uleczka")
@EnableAspectJAutoProxy
public class MyConfig {
}
