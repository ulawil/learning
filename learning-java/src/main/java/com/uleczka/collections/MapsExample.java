package com.uleczka.collections;

import com.uleczka.collections.model.Person;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class MapsExample {
    static void main() {

//        hashMapInternalsExample();
//        linkedHashMapExample();
        treeMapExample();
    }

    private static void hashMapInternalsExample() {
        HashMap<Person, Integer> penisSizes = new HashMap<>();

        Person p1 = new Person("Shidou", 18, "male");
        Person p2 = new Person("Shidou", 18, "male");
        Person p3 = new Person("Ulcia", 29, "female");

        penisSizes.put(p1, 20);
        penisSizes.put(p3, 0);
        penisSizes.put(p2, 21);
    }

    private static void linkedHashMapExample() {
        LinkedHashMap<Integer, Person> people = new LinkedHashMap<>();

        Person p1 = new Person("Shidou", 18, "male");
        Person p2 = new Person("Rin", 16, "male");
        Person p3 = new Person("Ulcia", 29, "female");

        people.put(1, p1);
        people.put(2, p2);
        people.put(3, p3);

        System.out.println(people.sequencedEntrySet());
    }

    private static void treeMapExample() {
        TreeMap<Integer, Person> people = new TreeMap<>(Comparator.comparingInt(Integer::intValue));

        Person p1 = new Person("Shidou", 18, "male");
        Person p2 = new Person("Rin", 16, "male");
        Person p3 = new Person("Ulcia", 29, "female");

        people.put(111, p1);
        people.put(10, p2);
        people.put(12, p3);

        System.out.println(people.entrySet());
    }
}
