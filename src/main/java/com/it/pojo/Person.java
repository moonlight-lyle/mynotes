package com.it.pojo;

public class Person implements Comparable<Person> {
    private int age;
    private String name;

    public Person() {
    }

    public Person(int age) {
        this.age = age;
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Person person) {
        return age - person.getAge();
    }

    @Override
    public String toString() {
        return name + "_" + age;
    }
}
