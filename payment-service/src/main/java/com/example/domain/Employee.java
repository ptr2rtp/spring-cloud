package com.example.domain;


import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {

    private @Id @GeneratedValue Long id;
    private String name;
    private String job;
    private Integer salary;
    private Integer commission;

    public Employee() {
    }

    public Employee(Long id, String name, String job, Integer salary, Integer commission) {
        this.id = id;
        this.name = name;
        this.job = job;
        this.salary = salary;
        this.commission = commission;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getCommission() {
        return commission;
    }

    public void setCommission(Integer commission) {
        this.commission = commission;
    }

    @Override
    public int hashCode() {
        return Objects.hash(commission, id, job, name, salary);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        return Objects.equals(commission, other.commission) && Objects.equals(id, other.id)
                && Objects.equals(job, other.job) && Objects.equals(name, other.name)
                && Objects.equals(salary, other.salary);
    }

    public String toString() {
        return String.format("%20s %20s %20s %20s %20s", id, name, job, salary, commission);

    }
}