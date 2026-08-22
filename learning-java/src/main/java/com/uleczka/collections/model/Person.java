package com.uleczka.collections.model;

import java.util.Objects;

public class Person {

    private String name;
    private Integer age;
    private String sex;

    public Person(String name, Integer age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
//        System.out.println(this + " equals() called");

        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(age, person.age) && Objects.equals(sex, person.sex);
    }

    @Override
    public int hashCode() {
//        System.out.println(this + " hashCode() called");

        return Objects.hash(name, age, sex);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
