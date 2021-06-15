package com.it.pojo;

/**
 * 公司模拟
 *
 * @author Lyle
 * @date 2021/6/13
 */
public class Company {

    private String department;

    private int level;

    private String owner;

    public Company() {
    }

    public Company(String department, int level, String owner) {
        this.department = department;
        this.level = level;
        this.owner = owner;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
