package com.css.spring.rest.model;

import java.io.Serializable;
import java.util.Date;

/**
 * This is the model class represents the employee of an organization.
 * It is serializable to store the in file storage.
 * @see Serializable
 *
 * @author Kishore Routhu on 22/7/17 8:21 PM.
 */
public class Employee implements Serializable {

    private long id;
    private String name;
    private int age;
    private String joinDate;
    private double salary;
    private String designation;

    public Employee() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (getAge() != employee.getAge()) return false;
        if (!getName().equals(employee.getName())) return false;
        return getDesignation().equals(employee.getDesignation());
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getAge();
        result = 31 * result + getDesignation().hashCode();
        return result;
    }
}
