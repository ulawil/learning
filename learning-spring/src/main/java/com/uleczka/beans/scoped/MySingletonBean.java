package com.uleczka.beans.scoped;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton") // default scope
@Lazy
public class MySingletonBean {
}
