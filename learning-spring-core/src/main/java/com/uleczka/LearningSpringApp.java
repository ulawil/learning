package com.uleczka;

import com.uleczka.beans.MyBean;
import com.uleczka.beans.MyComponent;
import com.uleczka.beans.MyInitializingBean;
import com.uleczka.beans.scoped.MyPrototypeBean;
import com.uleczka.beans.scoped.MySingletonBean;
import com.uleczka.config.MyConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LearningSpringApp {
    static void main() {

        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(MyConfig.class)) {

            // getting beans from context
            MyComponent myComponent = context.getBean(MyComponent.class);
            MyBean myBean = context.getBean(MyBean.class);
            myComponent.sayHello();
            myBean.sayHello();

            // singleton bean test
            MySingletonBean mySingletonBean1 = context.getBean(MySingletonBean.class);
            MySingletonBean mySingletonBean2 = context.getBean(MySingletonBean.class);
            System.out.println(mySingletonBean1 == mySingletonBean2);

            // prototype bean test
            MyPrototypeBean myPrototypeBean1 = context.getBean(MyPrototypeBean.class);
            MyPrototypeBean myPrototypeBean2 = context.getBean(MyPrototypeBean.class);
            System.out.println(myPrototypeBean1 == myPrototypeBean2);

            // bean lifecycle test
            MyInitializingBean myInitializingBean = context.getBean(MyInitializingBean.class);

            // bean conflict test
            MyComponent myComponent2 = context.getBean(MyComponent.class);
            myComponent2.getEatable().eat();
        }
    }
}
