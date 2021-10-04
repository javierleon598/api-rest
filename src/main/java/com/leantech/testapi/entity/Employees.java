package com.leantech.testapi.entity;


public class Employees {
    
    private Integer id;
    private String salary;
    private String name;
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

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Candidate getPerson(){
        return person;
    }

    public void setPerson(Candidate person){
        this.person = person;
    }

}
