# Spring

- [Inversion of Control](#inversion-of-control)
- [Dependency Injection](#dependency-injection)
    - [Dependency Injection types](#dependency-injection-types)
    - [No unique Bean conflict](#no-unique-bean-conflict)
- [Spring bean](#spring-bean)
    - [Creating a Spring bean](#creating-a-spring-bean)
    - [Bean scopes](#bean-scopes)
    - [Bean lifecycle](#bean-lifecycle)
- [ApplicationContext](#applicationcontext)
- [BeanFactory](#beanfactory)
- [Stereotypes](#stereotypes)
- [Configuration types](#configuration-types)

## Inversion of Control

**Inversion of control** - the responsibility for creating, configuring and managing objects
is transferred from the application code to Spring IoC container; instead of a class creating
its own dependencies, the container creates the objects and provides their dependencies;
the main ways Spring achieves IoC is DependencyInjection.

## Dependency Injection

**Dependency Injection** - a technique for achieving Inversion of Control where an object's
dependencies are provided to it from outside, typically by the Spring IoC container,
instead of the objects creating those dependencies itself.

**Benefits of DI**:

- loose coupling
- easier testing
- better maintainability

### Dependency Injection types

- **Constructor injection** - preferred
    - makes required dependencies explicit
    - allows for final dependencies
    - avoids NPE
- **Setter injection** - useful for optional dependencies
    - does not allow final dependencies
    - can lead to NPE
- **Field injection**
    - does not allow for final dependencies
    - can lead to NPE
    - discouraged because of hidden dependencies issue

Dependencies are injected if annotated with `@Autowired` (unless the class has single
constructor, in which case it's not required in newer Spring versions).

### No unique Bean conflict

In case no unique bean can be found to inject, `NoUniqueBeanDefinitionException` is thrown.

Ways to resolve:

Way 1 - use `@Qualifier` on the bean and with `@Autowired`:

```java

@Configuration
public class MyConfig {

    @Bean
    public Eatable coffeeBean() {
        return ...
    }

    @Bean
    @Qualifier("tastyBean")
    public Eatable jellyBean() {
        return ...
    }
}
```

```java

@Component
public class MyComponent {

    @Autowired
    @Qualifier("tastyBean")
    private Eatable eatable;
}
```

Way 2 - use `@Qualifier` with bean name with `@Autowired`:

```java

@Configuration
public class MyConfig {

    @Bean
    public Eatable coffeeBean() {
        return ...
    }

    @Bean
    public Eatable jellyBean() {
        return ...
    }
}
```

```java

@Component
public class MyComponent {

    @Autowired
    @Qualifier("jellyBean") // name is actually a fallback qualifier if qualifier not specified
    private Eatable eatable;
}
```

Way 3 - annotate one of the beans with `@Primary`

```java

@Configuration
public class MyConfig {

    @Bean
    public Eatable coffeeBean() {
        return ...
    }

    @Bean
    @Primary
    public Eatable jellyBean() {
        return ...
    }
}
```

```java

@Component
public class MyComponent {

    @Autowired
    private Eatable eatable;
}
```

(!) `Qualifier` takes priority over `@Primary`

## Spring bean

**Spring bean** - an object that is instantiated, configured and managed by the Spring IoC
container. The container is responsible for managing the bean's lifecycle and dependencies.

### Creating a Spring bean

Way 1:

```java

@Component // or stereotype like @Service, @Repository... 
public class MyComponent {
}
```

Needs component scan enabled:

```java

@Configuration
@ComponentScan("com.uleczka")
public class MyConfig {
}
```

Way 2:

```java

@Configuration
public class MyConfig {

    @Bean
    public MyBean myBean() {
        return new MyBean();
    }
}
```

### Bean scopes

Set with `@Scope`, e.g.

```java

@Component
@Scope("prototype")
public class MyPrototypeBean {
}
```

- **singleton** - default scope; one instance per ApplicationContext
- **prototype** - new instance each time the bean is requested
- **request** - one instance per Http request
- **session** - one instance per Http session
- **application** - one instance per ServletContext
- **websocket** - one instance per WebSocket session

By default, singleton beans are eagerly initialized when the ApplicationContext starts;
`@Lazy` enables lazy initialization, so the bean is created only when it's first requested
from the context:

```java

@Component
@Lazy
public class MySingletonBean {
}
```

### Bean lifecycle

1. Bean instantiated
2. Bean's dependencies injected
3. aware callbacks called:
    1. BeanNameAware::setBeanName
    2. BeanFactoryAware::setBeanFactory
    3. ApplicationContextAware::setApplicationContext
4. BeanPostProcessor::postProcessBeforeInitialization called
5. init methods called:
    1. @PostConstruct
    2. InitializingBean::afterPropertiesSet
    3. @Bean's initMethod
6. BeanPostProcessor::postProcessAfterInitialization called

Bean is ready to use until context is closed, then:

1. destroy methods called:
    1. @PreDestroy
    2. DisposableBean::destroy
    3. @Bean's destroyMethod

## ApplicationContext

**ApplicationContext** - Spring's central IoC container, responsible for creating, configuring
and managing beans and their dependencies, also provides additional features such as even handling
and resource loading.

## BeanFactory

**BeanFactory** - basic IoC container interface in Spring; provides fundamental functionality
for creating and managing beans and resolving their dependencies.

## Stereotypes

Stereotype annotations are annotations that indicate the role or responsibility of a class within 
a Spring application and allow Spring to discover it as a component through component scanning.

Main stereotypes:

- `@Component`
- `@Repository`
- `@Service`
- `@Controller`

## Configuration types

- **XML configuration**
    - beans are defined in XML file
- **Java configuration**
    - beans are defined in `@Configuration` class with `@Bean` methods
    - optionally `@ComponentScan`
- **Annotation-based component registration**
    - `@ComponentScan` + stereotypes: `@Component`, `@Serivce`, `@Repository`, `@Controller`...
