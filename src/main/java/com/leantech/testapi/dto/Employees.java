package com.leantech.testapi.dto;

import com.leantech.testapi.entity.Candidate;

public class Employees {
    
    private Integer id;
    private String salary;
    private Candidate person;
    
    public Employees(){}

    public Integer getId(){
        return id;
    }
    
    public void setId(Integer id){
        this.id = id;
    }

    public String getSalary(){
        return salary;
    }

    public void setSalary(String salary){
        this.salary = salary;
    }

    public Candidate getPerson(){
        return person;
    }

    public void setPerson(Candidate person){
        this.person = person;
    }

}
