package com.uleczka.collections;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentMapExample {
    static void main() {

        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();

        Map<Integer, String> map2 = Collections.synchronizedMap(new HashMap<>());
    }
}
