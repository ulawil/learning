package com.uleczka.beans.scoped;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("websocket")
public class MyWebsocketBean {
}
