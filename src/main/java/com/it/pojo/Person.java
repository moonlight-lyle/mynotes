package com.it.pojo;

public class Person implements Comparable<Person> {
    private int age;

    public Person() {
    }

    public Person(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Person person) {
        return age-person.getAge();
    }
}
