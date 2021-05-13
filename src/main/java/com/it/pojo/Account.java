package com.it.pojo;

import java.io.Serializable;

/**
 * ToDo
 *
 * @author Lyle
 * @date 2020/1/13
 */
public class Account implements Serializable {
   private String name;
   private double money;

   private Address address;

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", money=" + money +
                ", address=" + address +
                '}';
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Account() {
    }

    public Account(String name, double money, String provinceName, String cityName) {
        this.name = name;
        this.money = money;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

}
