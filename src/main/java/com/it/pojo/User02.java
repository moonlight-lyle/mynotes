package com.it.pojo;

import java.io.Serializable;
import java.util.Map;

/**
 * ToDo
 *
 * @author Lyle
 * @date 2020/1/13
 */
public class User02 implements Serializable {

    private String username;
    private String password;
    private Integer age;
    private Map<String,Account> accountMap;//Map集合类型在前端用: 集合名[键名].属性名 来进行数据绑定,键名随便写,写什么就存什么键

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Map<String, Account> getAccountMap() {
        return accountMap;
    }

    public void setAccountMap(Map<String, Account> accountMap) {
        this.accountMap = accountMap;
    }

    @Override
    public String toString() {
        return "User02{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", accountMap=" + accountMap +
                '}';
    }
}