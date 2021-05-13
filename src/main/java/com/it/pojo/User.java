package com.it.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * ToDo
 *
 * @author Lyle
 * @date 2020/1/13
 */
public class User implements Serializable {
    private String username;
    private String password;
    private Integer age;
    private List<Account> accounts;//List集合类型在前端用: 集合名[索引].属性名 来进行数据绑定

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

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", accounts=" + accounts +
                '}';
    }
}
